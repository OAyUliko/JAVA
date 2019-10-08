import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//只负责监听，收到请求了的话就交给多线程去处理。
public class server1 {
    //public static HashMap<String, PrintWriter> users= new HashMap<String,PrintWriter>();
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(800);//指定服务器端口号
        while (true)
        {
            System.out.println("-------开始等待---------");
            Socket socket=server.accept();//侦听要连接到此套接字并接受它
            SocketHandler handler=new SocketHandler(socket);//构造函数新建对象
            Thread thread = new Thread(handler);
            thread.start();//多线程
        }
    }
}
