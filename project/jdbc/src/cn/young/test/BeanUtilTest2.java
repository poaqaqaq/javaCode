package cn.young.test;

import cn.young.entity.Basic;
import cn.young.entity.Employee;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class BeanUtilTest2 {
    @Test
    public void convertUtil() {
        String name = "cn_content";
        String age = "2";
        String sex = "2019-07-16 18:12:33";
        String date = "2019-07-16 18:12:33";
        Employee employee = new Employee();
        try {
            BeanUtils.copyProperty(employee, "name", name);
            BeanUtils.copyProperty(employee, "age", age);
            BeanUtils.copyProperty(employee, "sex", sex);
            //date类型不能自动类型转换，需要先注册转型器，可以注册多个转换器
//            ConvertUtils.register(new Converter() {
//                @Override
//                public Object convert(Class aClass, Object o) {
//                    System.out.println(date);
//                    Date date = null;
//                    //判断当是Date，而且值不为空时再进行转换
//                    if (aClass == Date.class && o != null && !"".equals(o.toString().trim())) {
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        try {
//                            date = simpleDateFormat.parse(o.toString());
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    return date;
//                }
//            }, Date.class);

            //lambda写法，但是作用域会有变化：普通写法时，外面的date，里面可以直接覆盖（互不影响）
            // 当lambda时，外面的date，里面不可覆盖！
//            ConvertUtils.register((aClass, o) -> {
////                System.out.println(date);
            //此处如果用Date date将会提示变量已存在！
//                Date date1 = null;
//                //判断当是Date，而且值不为空时再进行转换
//                if (aClass == Date.class && o != null && !"".equals(o.toString().trim())) {
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    try {
//                        date1 = simpleDateFormat.parse(o.toString());
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return date1;
//            }, Date.class);

            //使用自带的日期转换器，DateLocale，但是不支持：2019-07-16 18:12:33，这种Date类型的转换
//            ConvertUtils.register(new DateLocaleConverter(),Date.class);
            BeanUtils.copyProperty(employee, "date", date);
            System.out.println(employee);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
