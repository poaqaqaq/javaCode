package cn.young.annotation.annotation;
import	java.lang.annotation.ElementType;
import	java.lang.annotation.Target;
import	java.lang.annotation.RetentionPolicy;
import	java.lang.annotation.Retention;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
}
