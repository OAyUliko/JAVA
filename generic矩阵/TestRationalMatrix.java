package demo;

public class TestRationalMatrix {
    char[][] Matrix_1= new char[][]{{'A','B'},{0,0},{1,1}};
    Number[][] Matrix_2=new Number[][]{{0,1,1},{1,1,0}};
    IntegerMatrix result_=new IntegerMatrix();//结果矩阵
    GenericMatrix.printResult(Matrix_1, Matrix_2, result.addMatrix(Matrix1, Matrix2), '*');
}
