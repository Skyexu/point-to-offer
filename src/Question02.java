import java.util.Date;

/**
 * @Author: Skye
 * @Date: 19:34 2017/10/30
 * @Description: 题目：设计一个类，我们只能生成该类的一个实例
 *
 * TODO：理解不够，后续还需要学习
 *
 * 单例模式有以下特点：
　　1、单例类只能有一个实例。
　　2、单例类必须自己创建自己的唯一实例。
　　3、这个类对整个系统可见，即必须向整个系统提供这个实例。

举一个具体的单例模式的例子：比如教室里面的教师和学生都是需要在黑板上写字的，但是一般的情况下，教室里面应该只有一个黑板吧，它是教师和学生公用滴。
这时就要想办法保证取得的黑板是一个共享的唯一的对象。而单例模式就是解决这类问题的一个已经成型的模式。

 Spring 中每个 Bean 默认就是单例的，优点试 Spring 容器可以管理这些 Bean 的生命周期。
 注意不要使用内部类！这里为了展示方便



饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了，
而懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例。

 参考：http://blog.csdn.net/jason0539/article/details/23297037/
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
    /**
     * 单例模式，懒汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3{
        private static Singleton3 instance = null;
        private Singleton3(){

        }
        public static synchronized Singleton3 getInstance(){
            if (instance == null){
                instance = new Singleton3();
            }
            return instance;
        }
    }
    /**
     * 单例模式，懒汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;
        static {
            instance = new Singleton4();
        }
        private Singleton4() {
        }
        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，使用静态内部类，线程安全【推荐】
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        private Singleton5() {
        }
        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     *
     * 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊
     */
    public enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {

        }
    }

    public static class Singleton7{
            private volatile static Singleton7 singleton;
            private Singleton7(){}
            public static Singleton7 getSingleton(){
                if (singleton == null){
                    synchronized (Singleton.class){
                        if (singleton == null){
                            singleton = new Singleton7();
                        }

                    }
                }
                return singleton;
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