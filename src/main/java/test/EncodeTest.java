package test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.UnsupportedEncodingException;

/**
 * 编码
 * @author liyuke
 * @date 2021-07-07 15:48
 */
public class EncodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "张三";
        String x = new String(s.getBytes("GBK"), "ISO-8859-1");
        String y = new String(x.getBytes("ISO-8859-1"), "GBK");
        System.out.println("x:" + x);
        System.out.println("y:" + y);
    }

}
