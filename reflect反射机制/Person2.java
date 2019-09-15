package demo;

public class Person2 {
     /*private*/  Person2(){};//类的构造方法1
    public Person2(String name,int age){//类的构造方法2
            super();
            this.name=name;
            this.age=age;
        }
    Person2(String name){//类的构造方法3
        super();
        this.name=name;
    }
    protected Person2(int age){//类的构造方法4
        super();
        this.age=age;
    }

    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
       System.out.println(name);
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person2{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}



