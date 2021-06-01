package IOstream;

import java.io.File;
import java.util.Arrays;

/**
 * @author liyuke
 * @date 2021-03-25 21:00
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:/tool/");
        System.out.println(Arrays.toString(file.list()));
    }
    void test1(){

    }

}
