package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

//用于描述数据库中某一字段
public class ColumnInfo {
    private String columnName;//字段名称
    private Class<?> type;//字段类型
    private boolean isID = false;//是否是主键
    private boolean nullable = true;//是否可以为空
    private int length = 32;//字段长度
    private boolean needPersist = false;//该字段是否需要保存在数据库中

    //将属性对应的Field对象转换成字段信息对象
    //@param field Field对象
    //@return
    public ColumnInfo parse(Field field) {
        columnName = field.getName();//获取属性字段名
        type = field.getType();//获取属性类型
        Annotation[] annotations = field.getAnnotations();//获取属性注解
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Column.class)) //如果包含Column注解，则表明需要持久化存储
            {
                needPersist = true;
                Column column = (Column) annotation;
                if (!column.fieldName().equals(""))//如果fieldName不为空，则将字段名设置为注释fieldName的参数值
                {
                    columnName = column.fieldName();
                }
                nullable = column.nullable();
                if (column.length() != -1) {
                    length = column.length();
                }
            } else if (annotation.annotationType().equals(ID.class))//判断是否包含ID注解
            {
                needPersist = true;
                ID id = (ID) annotation;
                isID = true;
                if (!id.value().equals("")) {
                    columnName = id.value();
                }
            }
        }
        if (needPersist)
            return this;
        else
            return null;
    }


//SQL语句
    @Override
    public String toString()
    {
        StringBuilder sql=new StringBuilder(columnName);
        if(type.equals(String.class))
        {
            sql.append(" "+"VARCHAR("+length+")");
        }
        else if(type.equals(Integer.class))
        {
            sql.append(" "+"INT");
        }
        if(isID)
        {
            sql.append(" "+"PRIMARY KEY");
        }
        if(!nullable)
        {
            sql.append(" "+"NOT MULL");
        }
        sql.append(";");
        return sql.toString();
    }
}
