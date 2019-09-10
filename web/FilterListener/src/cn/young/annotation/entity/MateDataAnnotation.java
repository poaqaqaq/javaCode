package cn.young.annotation.entity;

import java.util.HashMap;

public class MateDataAnnotation<T> {
    private Class<T> clazz;
    private String tableName;
    private String idName;
    private HashMap<String, String> fieldAttribute = new HashMap<>();

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public HashMap<String, String> getFieldAttribute() {
        return fieldAttribute;
    }

    public void setFieldAttribute(HashMap<String, String> fieldAttribute) {
        this.fieldAttribute = fieldAttribute;
    }
}
