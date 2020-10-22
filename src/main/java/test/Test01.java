package test;

/**
 * @author liyuke
 * @date 2020-10-22 15:01
 */
//成员内部类&&局部内部类练习
public class Test01 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print(1);
        outer.method();
    }
}

class Outer {
    String s = "34324";
    int m = 2;
    int i = 0;
    class Inner {
        void print(int k) {
            System.out.println(i);
            System.out.println(Outer.this.m);
            System.out.println(k);
        }
    }

    void method() {



        Inner inner = new Inner();
        inner.print(m);
    }

}

