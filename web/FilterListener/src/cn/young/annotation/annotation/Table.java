package cn.young.annotation.annotation;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;

import java.lang.annotation.Target;

//仅允许注解在类上
@Target({ElementType.TYPE})
//生效的生命周期：SOURCE（源码） < ClASS（字节码，默认值） < RUNTIME（运行）
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    //自定义注解的属性值，不需要{}
    String tableName();
    //数组默认值
    String[] author() default {"a", "b"};
}
