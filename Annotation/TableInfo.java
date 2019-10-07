package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//创建表
public class TableInfo {
    private String tableName;//表名
    private Class<?> clazz;//表所对应的实体类
    private boolean needPersist = false;//持久化存储
    private Map<String, ColumnInfo> columns = new HashMap<String, ColumnInfo>();//表中所有字段信息

    public TableInfo parse(Class<?> clazz) {
        this.clazz = clazz;
        this.tableName = this.clazz.getSimpleName();
        Annotation[] annotations = this.clazz.getAnnotations();
        for (Annotation annotation: annotations) {
            if(annotation.annotationType().equals(Entity.class)) //如果包含Entity注解，则表明需要持久化存储
            {
                needPersist=true;
                Entity entity=(Entity)annotation;
                if(!entity.tableName().equals(""))
                {
                    tableName=entity.tableName();
                }
            break;
            }
        }
        if(needPersist) {
                Field[] fields=clazz.getDeclaredFields();
                for(Field field:fields)
                {
                    ColumnInfo column=new ColumnInfo();
                    column=column.parse(field);
                    if(column!=null)
                    {
                        columns.put(field.getName(),column);
                    }
                }
            return this;
        }
        else
        {
            return null;
        }
    }

//SQL语句
@Override
public String toString()
{
    StringBuilder sql=new StringBuilder();
    sql.append("CREAT TABLE");
    sql.append(tableName+"");
    sql.append("(");
    for(ColumnInfo column:columns.values())
    {
        sql.append("\n");
        sql.append("\t");
        sql.append(column.toString());
    }
    sql.append("\n");
    sql.append(")");
    return sql.toString();
}
}
