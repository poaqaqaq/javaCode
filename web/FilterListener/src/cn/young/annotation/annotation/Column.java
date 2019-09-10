package cn.young.annotation.annotation;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//TYPE,     类
//FIELD,     字段
//METHOD,  方法
//PARAMETER,   参数
//CONSTRUCTOR, 构造器
// LOCAL_VARIABLE  局部变量
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //如果属性名为value，且只声明了这个属性，则使用时可不写属性名value
    String value();

    //设置属性默认值为String，则使用此注解时可不必声明此属性
    String type() default "String";
}
