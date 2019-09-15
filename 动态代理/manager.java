package proxy_ex;

public class manager implements Star {
    private Liuyan ly=new Liuyan();
    @Override
    public void sing(double money) {//经纪人拿到了柳岩的工资
    if (money<10000)
        System.out.println("钱太少了，换个人签约");
    else
        System.out.println("经纪人我要拿走"+money*0.3+"元");
        ly.sing((int) (money*0.7));
    }

}

