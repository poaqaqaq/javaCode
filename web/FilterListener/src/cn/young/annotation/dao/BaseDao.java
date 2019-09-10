package cn.young.annotation.dao;

import java.lang.reflect.InvocationTargetException;

import cn.young.annotation.annotation.Column;
import cn.young.annotation.annotation.Id;
import cn.young.annotation.annotation.Table;
import cn.young.annotation.entity.MateDataAnnotation;
import cn.young.filter.util.QueryRunnerDaoUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BaseDao<T> {
    //声明存放的类都是泛型类！
    private MateDataAnnotation<T> mateDataAnnotation;
    //因为静态static是一开始便会加载到内存中，而泛型是在运行时才能确认（编译时会擦除），所以static不能使用泛型
    private static HashMap<String, MateDataAnnotation> classes = new HashMap<>();

    public BaseDao() {
        String simpleName = this.getClass().getSimpleName();
        if ((mateDataAnnotation = classes.get(simpleName)) == null) {
            setMateDataAnnotation(simpleName);
        }
    }

    public <K> T findById(K id) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ");
        sb.append(mateDataAnnotation.getTableName());
        sb.append(" where ");
        sb.append(mateDataAnnotation.getIdName());
        sb.append("= ?");
        try {
            return QueryRunnerDaoUtil.getQueryRunner().query(sb.toString(), new ResultSetHandler<T>() {
                @Override
                public T handle(ResultSet resultSet) throws SQLException {
                    HashMap<String, String> fieldAttribute = mateDataAnnotation.getFieldAttribute();
                    try {
                        T t = mateDataAnnotation.getClazz().newInstance();
                        if (resultSet.next()) {
                            Set<Map.Entry<String, String>> entries = fieldAttribute.entrySet();
                            for (Map.Entry<String, String> entry : entries) {
                                BeanUtils.copyProperty(t, entry.getValue(), resultSet.getObject(entry.getKey()));
                            }
                        }
                        return t;
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<T> getList() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ");
        sb.append(mateDataAnnotation.getTableName());
        try {
            return QueryRunnerDaoUtil.getQueryRunner().query(sb.toString(), new ResultSetHandler<List<T>>() {
                @Override
                public List<T> handle(ResultSet resultSet) throws SQLException {
                    HashMap<String, String> fieldAttribute = mateDataAnnotation.getFieldAttribute();
                    List<T> list = new ArrayList<>();
                    try {
                        while (resultSet.next()) {
                            T t = mateDataAnnotation.getClazz().newInstance();
                            Set<Map.Entry<String, String>> entries = fieldAttribute.entrySet();
                            for (Map.Entry<String, String> entry : entries) {
                                BeanUtils.copyProperty(t, entry.getValue(), resultSet.getObject(entry.getKey()));
                            }
                            list.add(t);
                        }
                        return list;
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setMateDataAnnotation(String simpleName) {
        //getSuperclass   返回直接继承的父类（由于编译擦除，没有显示泛型参数）
        //getGenericSuperclass  返回直接继承的父类（包含泛型参数）
        //Type是所有类型的超类，普通类型，特殊类型
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        //获取实际的泛型数组
        Type[] types = parameterizedType.getActualTypeArguments();
        //获取泛型数组的第一个值
        Class<T> clazz = (Class<T>) types[0];

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.tableName();
        Field[] fields = clazz.getDeclaredFields();
        String idName = "";
        HashMap<String, String> map = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                idName = field.getName();
            }

            Column column = field.getAnnotation(Column.class);
            String columnName;
            if (column != null) {
                columnName = column.value();
            } else {
                columnName = field.getName();
            }
            //设置字段与类属性名
            map.put(columnName, field.getName());
        }
        mateDataAnnotation = new MateDataAnnotation<>();
        //封装
        mateDataAnnotation.setClazz(clazz);
        mateDataAnnotation.setTableName(tableName);
        mateDataAnnotation.setIdName(idName);
        mateDataAnnotation.setFieldAttribute(map);
        classes.put(simpleName, mateDataAnnotation);
    }
}
