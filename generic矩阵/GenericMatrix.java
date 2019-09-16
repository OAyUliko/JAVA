package demo;

abstract class GenericMatrix<E extends Number> {
    //抽象方法,里面不写内容,相当于去实现已有的运算的功能
    protected abstract E add(E e1, E e2);//相加

    protected abstract E multiply(E e1, E e2);//相乘

    protected abstract E zero(E e1, E e2);//不懂为什么要零矩阵？？？感觉用不到呀.初始化？？？

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {//泛型方法,声明这个方法使用了一个类型参数E[][]
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length))//只有矩阵1的行数=矩阵2的行数，矩阵1的列数=矩阵2的列数，才可以相加
            System.out.println("不符合矩阵运算的加法规则！");
        E[][] matrix3 = (E[][]) new Number[matrix1.length][matrix2[0].length];//类型转换要放最前面，要是放在for里面，只是局部变量，不能传递值
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix3[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        return matrix3;//返回值用于矩阵的输出
    }

    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        if ((matrix1.length != matrix2[0].length) || (matrix1.length != matrix2[0].length))//矩阵1的行数=矩阵2的列数，矩阵1的列数=矩阵2的列数，才可以相乘
            System.out.println("不符合矩阵运算的乘法规则！");
        E[][] matrix4 = (E[][]) new Number[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix4[i][i] = multiply(matrix1[i][j], matrix2[j][i]);//乘法的结果是矩阵1的行数，矩阵2的列数
            }
        return matrix4;//返回值用于矩阵的输出
    }

    public void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {//打印结果的函数
        //m1，m2分别为矩阵1，2，m3为结果，op为所实现的运算符号，是＋还是*，靠实参传进去
        for (int i = 0; i < m1.length; i++) {//输出m1矩阵和符号
            for (int j = 0; j < m1[0].length; j++) {
                System.out.print(" " + m1[i][j]);
                if (i == m1.length)
                    System.out.print(" " + op + " ");
                else
                    System.out.print("   ");//矩阵里面数字的间隔
            }
        }
        for (int i = 0; i < m1.length; i++) {//输出m2矩阵和等号
            for (int j = 0; j < m2.length; j++) {
                System.out.print(" " + m2[i][j]);
                if (i == m1.length / 2)
                    System.out.print(" = ");
                else
                    System.out.print("   ");
            }
        }
        for (int i = 0; i < m1.length; i++) {//输出结果m3矩阵
            for (int j = 0; j < m3.length; j++) {
                System.out.print(m3[i][j] + " ");
                System.out.println();//换行符
            }
        }
    }
}


