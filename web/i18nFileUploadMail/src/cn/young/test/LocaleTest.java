package cn.young.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {
    @Test
    public void testLocale1() {
        //获取默认语言Locale
//        Locale locale = Locale.getDefault();
        //获取美国语言Locale
        Locale locale = Locale.US;
        //获取国家简称，用英文显示
        System.out.println(locale.getCountry());
        //获取完整国家名，用默认语言显示，这里是中文
        System.out.println(locale.getDisplayCountry());
        //获取语言简称，用英文显示
        System.out.println(locale.getLanguage());
        //获取完整语言，用默认语言显示，这里是中文
        System.out.println(locale.getDisplayLanguage());
    }

    @Test
    public void testPropertiesLocale() {
//        Locale locale = Locale.getDefault();
        Locale locale = Locale.CHINA;
        //第一个参数：包名+基础名，完整文件名为 基础名+_+getLanguage+_+getCountry，例如中文文件名为：msg_zh_CN.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("cn.young.msg", locale);
        System.out.println(resourceBundle.getClass().getResource("/").getPath());
        System.out.println(resourceBundle.getString("userName"));
    }

    @Test
    public void testPropertiesLocaleDefault() {
        Locale locale = Locale.getDefault();
        //如果找不到对应的语言包，将使用默认的语言包，即不加限定国家的语言包，例如：msg.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("cn.young.msg", locale);
        System.out.println(resourceBundle.getString("password"));
    }

    @Test
    public void testSay() {
        String[] a = {"1", "2", "3"};
        if (a[3] != null) {
            System.out.println("ddd");
        }
    }
}
