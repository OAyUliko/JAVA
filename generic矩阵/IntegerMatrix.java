package demo;

public class IntegerMatrix extends GenericMatrix<Integer>{

    @Override//以下是继承父类方法的重用
    protected Integer add(Integer e1, Integer e2) {
        return e1+e2;
    }

    @Override
    protected Integer multiply(Integer e1, Integer e2) {
        return e1*e2;
    }

    @Override
    protected Integer zero(Integer e1, Integer e2) {
        return 0;//？？？？不懂呀
    }
}
