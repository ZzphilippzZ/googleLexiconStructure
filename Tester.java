class Tester
{
  public static void main(String args[])
  {
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
  }
}
