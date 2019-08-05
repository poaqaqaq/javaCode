package cn.DataSoucePage.test;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy() {
        int l = 5;
        long totalCount = 17;
        //将l或者totalCount转换浮点型数据做处理，即可得到正确的结果！
        double d = totalCount /(double)l;
        double ceil = Math.ceil(d);
        System.out.println((int)ceil);
    }
}
