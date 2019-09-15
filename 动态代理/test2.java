package proxy_ex;

public class test2 {
    public static void main(String[] args) {
        XiaoMi xiaoMi = new XiaoMi();
        System.out.println(xiaoMi.salePhones(2000.0));
        System.out.println("---------------------------------------");
        ProxyXiaoMi proxyXiaoMi = new ProxyXiaoMi();
        SalePhones salePhonesByProxy = (SalePhones) proxyXiaoMi.doForProxy(xiaoMi);
        System.out.println(salePhonesByProxy.salePhones(2000.0));
    }
}
