package tom.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils
{
    public static String stringToMD5(String s)
    {
        byte[] secret = null;
        try
        {
            secret = MessageDigest.getInstance("md5").digest(s.getBytes());
        }
        catch (NoSuchAlgorithmException E)
        {
            System.out.println("没有这个算法！");
        }
        String md5Code = new BigInteger(1,secret).toString();
        for (int i = 0; i < 32 - md5Code.length(); i++)
        {
            md5Code = "0" + md5Code;
        }
        System.out.println(md5Code);
        return md5Code;
    }
}
