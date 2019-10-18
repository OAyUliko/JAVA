import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class jsontoxml {
        public static void jsonToXML(String json) {
            XMLSerializer xmlSerializer = new XMLSerializer();
            xmlSerializer.setRootName("xml");// 根节点名称
            String xmlStr = "";
// jsonArray和jsonObject的区别：前者是数组，以[]开头结尾，后者是对象，以{}开头结尾
             JSONObject jobj = JSONObject.fromObject(json);
             xmlStr = xmlSerializer.write(jobj);
            System.out.println("转换后的参数：" + xmlStr);
        }
    }
