package tom.util;

public class MD5Tester
{
    public static void main(String[] args)
    {
        String s = "123456";
        String password = MD5Utils.stringToMD5(s);
        System.out.println(password);
    }

}
