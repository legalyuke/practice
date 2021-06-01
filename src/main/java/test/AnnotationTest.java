package test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author liyuke
 * @date 2021-04-01 21:38
 */
public class AnnotationTest {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface LabelTest {
        int id() default -1;

        String name() default "";
    }

    @LabelTest(id = 1, name = "123")
    void test1() {

    }

    static String test(String s){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        AnnotationTest annotationTest = new AnnotationTest();
//        char[][] arr = new char[][]{
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'},
//                {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1'}
//        };
//        for (char[] chars : arr) {
//            for (char aChar : chars) {
//                System.out.println(aChar);
//            }
//        }
//        String s = new String("test");
//
//        System.out.println(arr);
//        System.out.println(annotationTest);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("");
//        System.out.println(stringBuilder);
//        int[] x = new int[10];
//        for (int a : x) {
//            System.out.println(a);
//        }
        test(null);
    }

}
