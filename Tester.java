class Tester
{
  public static void main(String args[])
  {
    Lexicon l = new Lexicon (11);

    l.insert("alex");
    l.insert("tom");
    l.insert("jerry");
    //l.debugPrint();

    System.out.println(l.search("alex"));
    System.out.println(l.search("tom"));
    System.out.println(l.search("jerry"));
    System.out.println(l.search("mary"));
    System.out.println(l.delete("tom"));
    System.out.println(l.delete("aley"));
    System.out.println(l.delete("alex"));
    System.out.println(l.delete("jerry"));
    l.insert("jerry");
    l.insert("tom");
    System.out.println(l.delete("jerry"));
    l.insert("tom");
    l.debugPrint();
    l.doubleSize();
    l.debugPrint();
  }
}
