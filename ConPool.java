package MyCon;

import javax.annotation.PostConstruct;
import javax.xml.stream.FactoryConfigurationError;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//创建实例的类
public class ConPool {
    private List<MyCon>FreeCons=new ArrayList<MyCon>();//空闲列表
    private List<MyCon>BuzyCons=new ArrayList<MyCon>();//繁忙列表
    private int max=10;//最大连接数
    private int min=2;
    private int current=0;//目前连接数
    private static ConPool instance;//私有的构造实例，首先需要判断current和min的关系，来检查连接数

    public static ConPool getInstance(){//获得连接池实例
        if(instance==null)
        {
            instance=new ConPool();
        }
        return instance;
    }

    private ConPool(){//私有构造函数,检查空闲连接数，如果小于min，创建连接CreatCon，free队列+1
        if(this.current<this.min)
            this.FreeCons.add(this.CreatCon());
    }

    private MyCon CreatCon(){//创建新连接
        try {
            Connection con=MySqlDao.getConnection();//连接为con
            MyCon myCon=new MyCon(con);//进行MyCon的实例化
            this.current++;
            return myCon;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    //连接创建好之后，进行获得
    public MyCon GetCon(){
        MyCon myCon=this.GetFreeCon();
        if(myCon!=null)
            return myCon;
        else
            return this.GetNewCon();
    }

    //如果连接池是空的
    private MyCon GetFreeCon(){
        if(FreeCons.size()>0)
        {
            MyCon con=FreeCons.remove(0);//remove所以才用con
            con.setState(MyCon.BUZY);
            this.BuzyCons.add(con);
            return con;
        }
        else
            return null;
    }

    //连接池非空
    private MyCon GetNewCon(){
        if(this.current<this.max)
        {
            MyCon myCon=this.CreatCon();
            myCon.setState(MyCon.BUZY);//myCon和con都可以进行状态的设置...
            this.BuzyCons.add(myCon);
            return myCon;
        }
        else
            return null;
    }

    public void SetFree(MyCon con){//remove和add才用con
        this.BuzyCons.remove(con);
        con.setState(MyCon.FREE);
        this.FreeCons.add(con);
    }

    public String toSting(){
        return "当前连接数："+this.current+"空闲连接数："+this.FreeCons.size()+"繁忙连接数"+this.BuzyCons.size();
    }
}
