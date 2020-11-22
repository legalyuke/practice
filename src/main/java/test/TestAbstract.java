package test;

/**
 * 静态内部类测试
 * 抽象类测试
 * 字类访问限定修饰符测试
 * @author liyuke
 * @date 2020-11-03 22:17
 */
public  abstract class TestAbstract {
     abstract void testMethod();
     protected final static class testStaticClass{
           static void printx(){
               System.out.println("test");
          }
     }
     void test(){
          testStaticClass.printx();
     }

}
 class TestClass extends TestAbstract{
      @Override
      void testMethod() {
           do {
                break;
           }while (true);

           testStaticClass.printx();
      }
 }
 class TestStaticInnerClass{
     TestClass testClass = new TestClass();
     void test(){
          testClass.testMethod();
          TestClass.testStaticClass.printx();
          TestAbstract.testStaticClass.printx();
     }

 }
