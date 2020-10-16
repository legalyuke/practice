package IOstream;

import java.io.IOException;
import java.io.StringReader;

/**
 * 文 件 名:  MemoryInput.java
 * 版    权:
 * 描    述: 从内存输入
 * 创建人  :  legalyuke
 * 创建时间:  2020/10/16 22:50
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException{
        String path = BufferedInputFile.class.getClassLoader().getResource("").getPath();
        String FileName="test.txt";
        String filePath = path+FileName;

        StringReader in = new StringReader(BufferedInputFile.read(filePath));
        int c;
        while ((c = in.read())!=-1){
            System.out.println((char)c);
        }
    }

}
