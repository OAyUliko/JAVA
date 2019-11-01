package MyCon;
import java.sql.Connection;

//含有状态的数据连接
public class MyCon {
    public static int FREE=100;//空闲
    public static int BUZY=101;//繁忙
    public static int CLOSED=102;//关闭

    //类型为Connection的con，表示一个连接对象
    public Connection con;
    private int state=FREE;

    public MyCon(Connection con) {
        this.con = con;
    }
    // 通过构造函数，将Connection类和MyCon类联系起来
    public Connection getCon() {
        return con;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }

}
