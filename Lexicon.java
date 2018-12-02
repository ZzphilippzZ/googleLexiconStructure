// Philipp Adams cs435 7785 mp
import java.util.Arrays;

class Lexicon
{
  private int[] hashTable;
  private char[] wordArray;
  private int sizeFactor = 15;
  private int size = -1;
  private int sizeRemaining = -1;
  private int insertPosition = 0;

  public Lexicon(int size)
  {
    this.size = size;
    this.sizeRemaining = size;

    hashTable = new int[size];
    wordArray = new char[sizeFactor*size];

    Arrays.fill(hashTable, -1);
    Arrays.fill(wordArray, ' ');
  }

  public boolean isEmpty()
  {
    if(sizeRemaining == size)
    {
      return true;
    }
    return false;
  }

  public boolean isFull()
  {
    if(sizeRemaining == 0 || wordArray[wordArray.length - 1] != ' ')
    {
      return true;
    }
    return false;
  }

  public int insert(String word)
  {
    while(this.isFull() || (insertPosition + word.length() + 1) >= wordArray.length)
    {
      this.doubleSize();
    }

    int hPrime = hPrime(size, word);
    int insertIndex = -1;

    int i = 0;
    while(i < size)
    {
      insertIndex = (hPrime + i*i) % size;
      if(hashTable[insertIndex] < 0)
      {
        hashTable[insertIndex] = insertPosition;

        for(int j = 0; j < word.length(); j++)
        {
          wordArray[insertPosition++] = word.charAt(j);
        }
        wordArray[insertPosition++] = '\\';

        sizeRemaining--;
        return insertIndex;
      }
      i++;
      if(i == size)
      {
        this.doubleSize();
      }
    }
    return -1;
  }

  //returns hashTableIndex if found or -1 if not found
  public int search(String word)
  {
    int hPrime = hPrime(size, word);
    int insertIndex = -1;
    int startingIndex = -1;

    int i = 0;
    do
    {
      insertIndex = (hPrime + i*i) % size;
      startingIndex = hashTable[insertIndex];

      if(!((startingIndex + word.length() + 1) >= wordArray.length) && startingIndex > -1 && wordArray[startingIndex + word.length()] == '\\')
      {
          for(int j = 0; j < word.length(); j++)
          {
            if(word.charAt(j) != wordArray[startingIndex + j])
            {
              break;
            }
            return insertIndex;
          }
      }
      i++;
    } while(i < size && startingIndex != -1);
    return -1;
  }

  public int delete(String word)
  {
    if(!this.isEmpty())
    {
      int hashTableIndexOfWord = search(word);
      if(hashTableIndexOfWord != -1)
      {
        int startingIndex = hashTable[hashTableIndexOfWord];
        while(wordArray[startingIndex] != '\\')
        {
          wordArray[startingIndex++] = '*';
        }
        hashTable[hashTableIndexOfWord] = -2;
        sizeRemaining++;
      }
      return hashTableIndexOfWord;
    }
    return -1;
  }

  private int hPrime(int modInt, String word)
  {
    int sum = sumOfChar(word);

    return sum % modInt;
  }

  private int sumOfChar(String word)
  {
    int sum = 0;
    for(int i = 0; i < word.length(); i++)
    {
      sum += (int) word.charAt(i);
    }
    return sum;
  }

  public void doubleSize()
  {
    Lexicon newL = new Lexicon(size * 2);

    for(int i = 0; i < hashTable.length; i++)
    {
      int startingIndex = hashTable[i];
      if(startingIndex > -1)
      {
        String word = "";
        while(wordArray[startingIndex] != '\\')
        {
          word += wordArray[startingIndex++];
        }
        newL.insert(word);
      }
    }
    this.hashTable = newL.hashTable;
    this.wordArray = newL.wordArray;
    this.size = newL.size;
    this.insertPosition = newL.insertPosition;
    this.sizeRemaining = newL.sizeRemaining;
  }

  public void debugPrint()
  {
    System.out.print("T\tA: ");

    for(int i = 0; i < wordArray.length; i++)
    {
      System.out.print(wordArray[i]);
    }
    System.out.println();

    for(int i = 0; i < hashTable.length; i++)
    {
      System.out.println(i+ ": " +(hashTable[i] < 0 ? "" : hashTable[i]));
      //System.out.println(i+ ": " +hashTable[i]);
    }
    System.out.println();
  }
}
