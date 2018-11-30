import java.io.*;

class Tester
{
  public static void main(String args[])
  {
    /*
    Lexicon l = new Lexicon (1);

    l.insert("thisisareallylongwordthatisntreallyawordbutjustfortesting");
    l.debugPrint();
    l.delete("alex");
    l.debugPrint();

    l.insert("tom");
    l.debugPrint();
    l.insert("jerry");
    l.debugPrint();

    l.delete("tom");
    l.debugPrint();
    l.delete("jerry");
    l.debugPrint();
    l.insert("jerry");
    l.debugPrint();
    l.insert("tom");
    l.debugPrint();
    l.delete("jerry");
    l.debugPrint();
    l.insert("tom");
    l.insert("alex");
    l.insert("tom");
    l.insert("tom");
    l.delete("thisisareallylongwordthatisntreallyawordbutjustfortesting");

    l.debugPrint();
    System.out.println(l.search("tom"));
    System.out.println(l.search("aley"));
    System.out.println(l.search("alex"));
    */

    batch("test.txt");
  }

  public static void batch(String filename)
  {
    try(BufferedReader br = new BufferedReader(new FileReader(filename)))
    {
      String currentLine = "";
      String[] lineTokens;
      Lexicon l = null;

      while((currentLine = br.readLine()) != null)
      {
        String token2 = "";
        lineTokens = currentLine.split(" ");

        if(lineTokens.length == 2)
        {
          token2 = lineTokens[1];
        }

        int result = 0;
        String output = "";
        int operation = Integer.parseInt(lineTokens[0]);
        switch (operation)
        {
          case 10:
            l.insert(token2);
            break;
          case 11:
            result = l.delete(token2);
            if(result < 0)
            {
              output = token2+ " not found";
            }
            else
            {
              output = token2+ " deleted from slot " +result;
            }
            System.out.println(output);
            break;
          case 12:
            result = l.search(token2);
            if(result < 0)
            {
              output = token2+ " not found";
            }
            else
            {
              output = token2+ " found at slot " +result;
            }
            System.out.println(output);
            break;
          case 13:
            l.debugPrint();
            break;
          case 14:
            l = new Lexicon(Integer.parseInt(token2));
            break;
          default:
            System.out.println("Case " +operation+ " does not exist");
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
