import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(" 192.168.0.102" ,800);//创建流套接字并将其连接到指定IP地址的指定端口号
        InputStreamReader reader=new InputStreamReader(socket.getInputStream());//返回此套接字的输入流，将字节流变成字符流
        BufferedReader bufferedReader=new BufferedReader(reader);//读取输入流
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());//获得套接字的输出流，传到客户端

        int n;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            switch (n=System.in.read())
            {
                case 1:
                {
                    System.out.print("请输入用户名:");
                    String str1=sc.nextLine();//利用Scanner类来输入
                    String str="<register  name=”"+str1+"”/>";
                    System.out.println(str);//显示用户输入的是什么
                    printWriter.flush();
                    String echo= bufferedReader.readLine();
                    System.out.println("服务器响应:"+echo);
                }
                case 2:
                case 3:
                case 4:
            }
        }




    }
}
