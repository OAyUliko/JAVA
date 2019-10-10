package chatprogram;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler implements Runnable {
    private Socket socket;
    Scanner sc=new Scanner(System.in);
    public SocketHandler(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run()//线程完成具体工作的代码
    {
        try {
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);//读取来自客户端输入的字符流
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
            String client1 = "<" + socket.getInetAddress().toString() + " : " + socket.getPort() + ">";
            while(true)
            {

                String request=bufferedReader.readLine();
                String rename="a";
                    //把输入保存在request,里面只有一个姓，没有引号
               if(request.startsWith("<register name"))
                    {
                        rename=request;
                if(rename.equals(" ")){
                    printWriter.println("<result comment=‘register’ state=‘error’ maeeage=‘’/>");
                }else{
                    printWriter.println("<result comment=‘register’ state=‘ok’/>");
                }
                }
                else if(request.startsWith("<login name"))
                {
                    if(request ==rename)//??
                        printWriter.println("<result comment=‘login’ state=‘ok’/");
                    else
                        printWriter.println("<result comment=‘login’ state=‘error’ maeeage=‘’/>");
                }
                else if(request.startsWith("<message from me to"))
                {
                    String str="";
                    String mess="";
                }
            }
        }

        catch (Exception e)
        {
        e.printStackTrace();
        }

    }
}
