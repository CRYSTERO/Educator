package tom.util;

import com.alibaba.fastjson.JSON;
import tom.entity.admin.Administrator;

public class Admin_JSON
{
    public static void main(String[] args)
    {
        String Id = "999999";
        String name = "马云";
        String password = "123456";

        Administrator administrator = new Administrator(Id, name, password);
//        administrator.setId(Id);
//        administrator.setName(name);
//        administrator.setPassword(password);

        System.out.println(JSON.toJSONString(administrator));
    }
}
