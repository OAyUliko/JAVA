package MyCon;


public class DBTest {
    public static void main(String[] args)
    {
        System.out.println(ConPool.getInstance().toSting());
        MyCon con=null;
        for(int i =0;i<5;i++)
        {
            con=ConPool.getInstance().GetCon();
        }
        System.out.println(ConPool.getInstance().toSting());
        ConPool.getInstance().SetFree(con);
        System.out.println(ConPool.getInstance().toSting());
    }
}
