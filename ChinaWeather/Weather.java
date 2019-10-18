package ChinaWeather;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


/*①找到要调用的API接口
**②向指定URL添加参数发送请求
**③对返回的字符串进行处理
*/
public class Weather {
    public static void main(String[] args) throws Exception {
        System.out.println("请选择查询城市的对应代码：101200101--武汉  101200201--襄阳  101200601--黄石" +
                    "101200801--荆州  101200901--宜昌  101201001--恩施");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();//还不知道怎么把多个城市对应点写进来....

        String UrlStr="http://t.weather.sojson.com/api/weather/city/101200801";//调用的API位：https://www.tianqiapi.com/?action=v1
        URL Url=new URL(UrlStr);
        StringBuffer sb = new StringBuffer();//预备将结果保存在StringBuffer里
        URLConnection conn = Url.openConnection();
        //Url对象用openconnection()打开连接；获得URLConnection类对象，再用URLConnection类对象的connect（）方法进行连接，这里没有用是因为首先打开了连接，默认用了connect
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));//返回结果
        String line = null;
        while ((line = reader.readLine()) != null){
            sb.append(line);//数组进行扩充 再进行字符串append添加的时候，会先计算添加后字符串大小
        }
        reader.close();
        System.out.println(sb);//输出json结果


        //将结果写入result.json 方便转成xml？？
        File file = new File("D:/java练习/ChinaWeather/src/ChinaWeather/result.json");
        String ss = sb.toString();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);//bufferedwriter可以直接用tostring，不用getbytes了
        bw.write(ss);
        bw.close();//记得关闭

        jsontoxml.jsonToXML(ss);//json转xml
    }
}
}
