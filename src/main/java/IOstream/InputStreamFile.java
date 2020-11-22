package IOstream;

import java.io.*;

/**
 * 字符流文件读取
 * @author liyuke
 * @date 2020-11-12 14:42
 */
public class InputStreamFile {
    /**
     * 以字符为单位读取文件内容，一次读一个字节
     * @param filename
     * @return
     * @throws IOException
     */
    public static  String read(String filename,String charsetName) throws IOException{

        File file = new File(filename);
        Reader reader = null;
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file),charsetName);
            return getString(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("读取文件失败");
        }
    }


    public static  String read(String filename) throws IOException{

        File file = new File(filename);
        Reader reader = null;
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            return getString(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("读取文件失败");
        }
    }


    private static String getString(Reader reader) throws IOException {
        int tempChar;
        StringBuilder stringBuilder = new StringBuilder();
        while ((tempChar = reader.read()) != -1) {
            // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
            // 但如果这两个字符分开显示时，会换两次行。
            // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
            if (((char) tempChar) != '\r') {
                System.out.println(tempChar);
                stringBuilder.append((char)tempChar);
            }
        }
        reader.close();
        return stringBuilder.toString();
    }
}
