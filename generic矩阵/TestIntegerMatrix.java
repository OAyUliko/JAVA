package demo;

public class TestIntegerMatrix {
    public static void main(String[] args){
        Integer[][] Matrix1=new Integer[][]{{1,0},{0,0},{1,1}};
        Integer[][] Matrix2=new Integer[][]{{0,1,1},{1,1,0}};
        IntegerMatrix result=new IntegerMatrix();//结果矩阵
        GenericMatrix.printResult(Matrix1, Matrix2, result.addMatrix(Matrix1, Matrix2), '+');
    }
}
