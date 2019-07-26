package cn.young.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

public class WebUtil {
    static {
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
    }

    @Deprecated
    public static <T> T copyToBeanOld(HttpServletRequest request, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);
                BeanUtils.copyProperty(t, name, value);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T copyToBeanNew(HttpServletRequest request, Class<T> T) {
        T t = null;
        try {
            t = T.newInstance();
            Map<String, String[]> map = request.getParameterMap();
            BeanUtils.populate(t, map);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return t;
    }
}
