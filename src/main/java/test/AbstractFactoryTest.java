package test;

/**
 * @author liyuke
 * @date 2020-12-22 17:21
 */
public interface AbstractFactoryTest {

    String testMethod(String s1, String s2);

    static void test1(String x) {

    }

    ;

    default void test2() {

    }


    int x = 1;
}
