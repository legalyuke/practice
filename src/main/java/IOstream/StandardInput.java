package IOstream;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liyuke
 * @date 2021-03-29 20:44
 */
public class StandardInput {
    enum Shard {
        TEST1(0, "系统错误"),
        TEST2(200, "成功"),
        TEST3(500, "服务器错误");

        private int code;
        private String message;

        Shard(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public int getCode() {
            return code;
        }
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//        String s;
//        while ((s = stdin.readLine()) != null && s.length() != 0) {
//            System.out.println(s);
//        }
        for (Shard s : Shard.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.print(s.compareTo(Shard.TEST2) + " ");
            System.out.print(s.equals(Shard.TEST2) + " ");
            System.out.println(s == Shard.TEST2);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println(s.getMessage());
            System.out.println("------------------------------------");
        }
        Shard shard = Shard.TEST1;
        switch (shard) {
            case TEST1:
                shard = Shard.TEST2;
                System.out.println("case1");
//                break;
            case TEST2:
                shard = Shard.TEST3;
                System.out.println("case2");
//                break;
            case TEST3:
                shard = shard.TEST1;
                System.out.println("case3");
//                break;
        }

    }

}
