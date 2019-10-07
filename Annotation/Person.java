package Annotation;
//测试类
@Entity(tableName = "People")
public class Person {
    @ID
    @Column(nullable=false)
    private Integer id;
    @Column(nullable=false,length=16)
    private String name;
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

