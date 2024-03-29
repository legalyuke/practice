package IOstream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文 件 名:  BufferedInputFile.java
 * 版    权:
 * 描    述:  通过缓冲输入文件
 * 创建人  :  legalyuke
 * 创建时间:  2020/10/14 22:27
 */
public class BufferedInputFile {

    public static  String  read(String filename) throws IOException{
        //Throw exception by lines;
        //使用以String或File对象作为文件名的FileInputReader.，并使用缓冲提高速度。
        System.out.println(new FileReader(filename));
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine())!=null){
            sb.append(s+"\n");
        }
        in.close();
        return sb.toString();
    }
}
class test{
    public static void main(String[] args) throws IOException{
        String root = System.getProperty("user.dir");
//        Integer.bitCount();
        //获取当前类的绝对路径
        String path = BufferedInputFile.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        String FileName="test.txt";
//        String filePath = root+File.separator+"experiment"+File.separator+FileName;
        String filePath = path+FileName;
        String s = InputStreamFile.read(filePath,"GBK");
//        String s = BufferedInputFile.read(filePath);
        String s1 = new String(s.getBytes("GBK"),"UTF-8");
//        String s2 = new String(s.getBytes("GBK"),"GBK");
        String s3 = "字符编码测试";
        System.out.println(s);
        System.out.println(s1);
//        System.out.println(s2);
        System.out.println(s3);
    }
}

