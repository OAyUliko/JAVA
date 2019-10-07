package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指明哪些属性需要映射成数据表中的字段
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Column {
    public String fieldName() default "";//字段名
    public boolean nullable() default false;
    public int length() default -1;//字段长度
}
