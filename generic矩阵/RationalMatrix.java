package demo;
//合理矩阵？？
public class RationalMatrix extends GenericMatrix<Number>{
    //Number里没有String这种字符型啊..

    @Override
    protected Number add(Number e1, Number e2) {
        String E1 = String.valueOf((Number) e1);//强制将e1number型换成string，保存在E1
        String E2 = String.valueOf((Number) e2);
        Number E3=Integer.parseInt(E1)+Integer.parseInt(E2);//强制将E1字符型结果转换成整型
        return E3;
    }

    @Override
    protected Number multiply(Number e1, Number e2) {
        String E1 = String.valueOf((Number) e1);//强制将e1number型换成string，保存在E1
        String E2 = String.valueOf((Number) e2);
        Number E3=Integer.parseInt(E1)*Integer.parseInt(E2);//强制将E1字符型结果转换成整型,但是感觉不是这么写的...
        return E3;
    }

    @Override
    protected Number zero(Number e1, Number e2) {
        return null;
    }
}
