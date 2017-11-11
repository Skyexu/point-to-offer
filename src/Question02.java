import java.util.Date;

/**
 * @Author: Skye
 * @Date: 19:34 2017/10/30
 * @Description: 题目：设计一个类，我们只能生成该类的一个实例
 *
 * 单例模式有以下特点：
　　1、单例类只能有一个实例。
　　2、单例类必须自己创建自己的唯一实例。
　　3、这个类对整个系统可见，即必须向整个系统提供这个实例。

举一个具体的单例模式的例子：比如教室里面的教师和学生都是需要在黑板上写字的，但是一般的情况下，教室里面应该只有一个黑板吧，它是教师和学生公用滴。
这时就要想办法保证取得的黑板是一个共享的唯一的对象。而单例模式就是解决这类问题的一个已经成型的模式。

 Spring 中每个 Bean 默认就是单例的，优点试 Spring 容器可以管理这些 Bean 的生命周期。
 注意不要使用内部类！这里为了展示方便
 */
public class Question02 {
    /**
     * 单例模式，饿汉式，线程安全
     */
    public static class Singleton{
        private final static Singleton INSTANCE = new Singleton();

        private Singleton(){

        }

        public static Singleton getInstance(){
            return INSTANCE;
        }
    }

    /**
     * 单例模式，懒汉式，线程不安全
     */
    public static class Singleton2{
        private static Singleton2 instance = null;
        private Singleton2(){

        }
        public static Singleton2 getInstance(){
            if (instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        Singleton singleton = new Singleton();
        Singleton singleton1 = new Singleton();
        Date date = new Date();
        Date date1 = new Date();

        System.out.println(singleton.getInstance() == singleton1.getInstance());
//        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
//        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
//        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
//        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
//        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }


}