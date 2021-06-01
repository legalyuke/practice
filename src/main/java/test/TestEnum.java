package test;


/**
 * Enum 提供的一些功能
 * @author liyuke
 * @date 2020-11-03 22:44
 */
enum TestEnumClass {
    GROUND(32,"2312"),
    CRAWLING(32,"2312"),
    HANGING(32,"2312");
    private int code;
    private String message;
    public void setCode(int code){
        this.code = code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    private TestEnumClass(int code, String message){
        this.code = code;
        this.message = message;
    }
}
public class TestEnum{
    public static void main(String[] args) {
        for(TestEnumClass t : TestEnumClass.values()){
            System.out.println(t + " ordinal: " + t.ordinal());
            System.out.println(t.compareTo(TestEnumClass.CRAWLING)+"");
            System.out.println(t.equals(TestEnumClass.CRAWLING)+"");
            System.out.println(t == TestEnumClass.CRAWLING);
            System.out.println(t.getDeclaringClass());
            System.out.println(t.name());
            System.out.println("----------------------");
        }
        for(String s : "HANGING CRAWLING GROUND".split(" ")){
            TestEnumClass testEnumClass = Enum.valueOf(TestEnumClass.class,s);
            System.out.println(testEnumClass);

        }
    }
}
