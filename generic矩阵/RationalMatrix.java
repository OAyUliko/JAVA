package demo;

public class RationalMatrix extends GenericMatrix<String >{

    @Override
    protected String add(String e1, String e2) {
        return e1+e2;
    }


    @Override
    protected String multiply(String e1, String e2) {
        String e3=new String;

    }

    @Override
    protected String zero(String e1, String e2) {
        return null;
    }
}
