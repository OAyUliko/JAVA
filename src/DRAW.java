import com.sun.xml.internal.ws.server.ServerRtException;
import org.omg.CORBA.PRIVATE_MEMBER;
import sun.text.CodePointIterator;

public class DRAW {
    public static void main(String [] args)
    {
        SQUARE square=new SQUARE(150,200,1,22L,5);
        ELLIPSE ellipse=new ELLIPSE(300,280,3,18L);
    }

}

class SHAPE {
    private int OrgX; //逻辑坐标 X
    private int OrgY; //逻辑坐标 Y
    private int BorderType; //边框线型（实线，虚线，虚点线）
    private long FillColor; //填充颜色

     SHAPE(int orgX, int orgY, int borderType, long fillColor) {
        OrgX = orgX;
        OrgY = orgY;
        BorderType = borderType;
        FillColor = fillColor;
    }

    int getorgx() {
        return OrgX;
    }

    int getory() {
        return OrgY;
    }

    int getborderType() {
        return BorderType;
    }

    long getfillcolor() {
        return FillColor;
    }
}

    class FUNC{
        public void Draw(CDC pDC)
        { //...C++内部的库
        }
    }

 //---------以两个基类为例进行改写，因为几个图形类的函数都是差不多的
//-------------------------------------以正方形派生类为例改写
class SQUARE<CRgn, CBrush> extends SHAPE {
    private int width;

    SQUARE(int orgX, int orgY, int borderType, long fillColor, int width) {
        super(orgX, orgY, borderType, fillColor);
        super.getborderType();
        super.getfillcolor();
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    void IsMatched(CPoint pnt) {
        CRgn rgn = null;
        int x1 = super.getorgx() - width / 2;
        int y1 = super.getory() - width / 2;
        int x2 = super.getorgx() + width / 2;
        int y2 = super.getory() + width / 2;
        CRgn finalRgn = rgn;
        CRgn finalRgn1 = finalRgn;
        class Create {
            CRgn CreateRectRgn(int X1, int Y1, int X2, int Y2) {
                return finalRgn1; //C++中的数据库里的类
            }
        }
    }
    void Draw(CDC pDC)
    {
        //创建画笔及用来保存原画笔的指针
        CPen pen = new CPen(), pOldPen;
        pen.CreatePen(getborderType());
        pOldPen = pDC.SelectObject(pen);
        //绘制图形
        pDC.Rectangle(getorgx() - width / 2, getorgx() + width / 2, getorgx() + width / 2, getory() + width / 2);
        //使用当前画笔和刷子
        pDC.SelectObject(pOldPen);
    }
}

//-------------------------------------以椭圆派生类为例改写
class ELLIPSE<CRgn> extends SHAPE{
    private int radius;//半径
    private int height;//高度
    ELLIPSE(int orgX, int orgY, int borderType, long fillColor) {
        super(orgX, orgY, borderType, fillColor);//继承父类的基本参数
        super.getborderType();
        super.getfillcolor();
        this.radius = radius;
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }
    public int getHeight() {
        return height;
    }

    void IsMatched(CPoint pnt) {
        CRgn rgn = null;
        int x1 = super.getorgx() - radius / 2;
        int y1 = super.getory() + height / 2;
        int x2 = super.getorgx() + radius / 2;
        int y2 = super.getory() - height / 2;
        CRgn finalRgn = rgn;
        CRgn finalRgn1 = finalRgn;
        class Create {
            CRgn CreateEllipticRgn(int X1, int Y1, int X2, int Y2) {
                return finalRgn1; //C++中的数据库里的类
            }
        }
    }

    void Draw(CDC pDC)
    {
        //创建画笔及用来保存原画笔的指针
        CPen pen = new CPen(), pOldPen;
        pen.CreatePen(getborderType());
        pOldPen = pDC.SelectObject(pen);
        //绘制图形
        pDC.Ellipse(getorgx() - radius / 2, getorgx() + height / 2, getorgx() + radius / 2, getory() - height / 2);
        //使用当前画笔和刷子
        pDC.SelectObject(pOldPen);
    }
}

