import java.io.*;

class Tester
{
  public static void main(String args[])
  {
    if(args.length > 0)
    {
      for(int i = 0; i < args.length; i++)
      {
        batch(args[i]);
      }
    }
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
            System.out.println();
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
