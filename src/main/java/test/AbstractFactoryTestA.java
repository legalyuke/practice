package test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author liyuke
 * @date 2020-12-22 17:27
 */
public class AbstractFactoryTestA implements AbstractFactoryTest {
    @Override
    public String testMethod(String s1, String s2) {
        return "A";
    }

    public static void main(String[] args) {
//        int x = 1 ^ 2;
//        String s = "df";
//        System.out.println(x);

        IntBuffer intBuffer = IntBuffer.allocate(100);
        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        intBuffer.flip();
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        for (int i = 0; i < 3; i++) {
            System.out.println("value[" + i + "]:" + intBuffer.get());
        }
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        intBuffer.rewind();
        System.out.println("rewind--------------------------------");
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        System.out.println(intBuffer.get());
        intBuffer.mark();
        System.out.println(intBuffer.get());
        intBuffer.reset();
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        System.out.println(intBuffer.get());
//        System.out.println("mark:"+intBuffer.mark());
        intBuffer.clear();
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        intBuffer.put(new int[]{1, 2, 4, 5});
        System.out.println("position:" + intBuffer.position());
        System.out.println("limit:" + intBuffer.limit());
        System.out.println("capacity:" + intBuffer.capacity());
        int sum = Stream.builder().add(new Integer[]{1, 2, 4, 5, 6}).build().mapToInt(x -> (int) x).reduce(0, Integer::sum);

//        intBuffer.compact();
//        System.out.println("compact buffer--------------------------");
//        System.out.println("position:"+intBuffer.position());
//        System.out.println("limit:"+intBuffer.limit());
//        System.out.println("capacity:"+intBuffer.capacity());
    }
}
