package  webadv.s99201105.p02;


import java.io.*;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) {
        //写入文件
        FileWriter fw = null;
        try {
            fw = new FileWriter("password.txt");
            BufferedWriter sw = new BufferedWriter(fw);
            sw.write("17206102\n");
            sw.write(sha256hex("123456"));
            sw.close();
            fw.close();


        //控制台获取账号密码
        String username="";
        String password="";
        Scanner input = new Scanner(System.in);
        System.out.println("username: ");
        username=input.nextLine();
        System.out.println("password: ");
        password=input.nextLine();
        //从文件获取
        FileReader fr = null;

            fr = new FileReader("password.txt");
            BufferedReader br = new BufferedReader(fr);
            String txtUsername = br.readLine();
            System.out.println(txtUsername);
            String txtPassword = br.readLine();
            System.out.println(txtPassword);
            br.close();
            fr.close();
            //验证
            if(username.equals(txtUsername)&&sha256hex(password).equals(txtPassword)){
                System.out.println("登录成功！");

            }
            else{
                System.out.println("登录失败。");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
