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
    public static  String
    read(String filename) throws IOException{
        //Throw exception by lines;
        //使用以String或File对象作为文件名的FileInputReader.，并使用缓冲提高速度。
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
        //获取当前类的绝对路径
        String path = BufferedInputFile.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        String FileName="test.txt";
//        String filePath = root+File.separator+"experiment"+File.separator+FileName;
        String filePath = path+FileName;
        System.out.println(BufferedInputFile.read(filePath));
    }
}
