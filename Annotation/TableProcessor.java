package Annotation;

//注解处理器
public class TableProcessor implements IProcessor {
    @Override
    public String process(String url) throws Exception {
        //List<File> classFiles = Scanner.getClassFiles(url);
        StringBuilder sql = new StringBuilder();
            Class<?> clazz = Class.forName(url);
            TableInfo table = new TableInfo();
            table=table.parse(clazz);
            if (table != null) {
                sql.append(table.toString());
            }
        return sql.toString();
    }
}
