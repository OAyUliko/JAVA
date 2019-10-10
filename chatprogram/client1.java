package chatprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.0.107" ,800);//创建流套接字并将其连接到指定IP地址的指定端口号
        InputStreamReader reader=new InputStreamReader(socket.getInputStream());//返回此套接字的输入流，将字节流变成字符流
        BufferedReader bufferedReader=new BufferedReader(reader);//读取输入流
        Scanner sc=new Scanner(System.in);
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());//获得套接字的输出流
        int n;
        System.out.print("请选择:1.注册  2.登陆  3.发消息  4.注销");
        while(true)
        {

            n=sc.nextInt();
            String s=sc.nextLine();
            switch (n)//获取输入值
            {
                case 1://注册
                {
                    System.out.print("开始注册！");
                    //printWriter.flush();
                    String str=sc.nextLine();//利用Scanner类来输入
                    String str1="<register name=“"+str+"”/>";
                    System.out.println(str1);//显示用户输入的是什么
                    //printWriter.println(str1);
                    System.out.flush();
                    String echo= bufferedReader.readLine();
                    System.out.println("服务器响应:"+echo);
                }
                case 2://登录
                {
                    System.out.print("开始登录！");
                    String str=sc.nextLine();//利用Scanner类来输入
                    String str2="<login name=“"+str+"”/>";
                    //System.out.println(str1);//显示用户输入的是什么
                    printWriter.flush();
                    String echo= bufferedReader.readLine();
                    System.out.println("服务器响应:"+echo);
                }
                case 3://发消息
                {
                    System.out.print("请输入接受方的ID！");
                    String str=sc.nextLine();//利用Scanner类来输入
                    System.out.print("请输入要发送的消息！");
                    String mess=sc.nextLine();//利用Scanner类来输入
                    String str3="<message from me to=“"+str+"” message=“"+"mess"+"”/>" ;
                    //System.out.println(str1);//显示用户输入的是什么
                    printWriter.flush();
                    String echo= bufferedReader.readLine();
                    System.out.println(echo);
                }
                case 4:
            }
        }




    }
}
