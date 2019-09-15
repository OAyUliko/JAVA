package proxy_ex;

interface Star{//明星接口
    public abstract void sing(double money);
}
public class Liuyan implements Star{
    @Override
    public void sing(double money) {
        System.out.println("我演戏");
        System.out.println("赚了"+money+"元");
    }
}
