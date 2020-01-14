package main;

/**
 * @Description:
 * @Auther: zhouff
 * @Date: 2020/1/14 18:10
 */
public class TestMain {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getContextClassLoader().getResource("com").getPath());
    }
}
