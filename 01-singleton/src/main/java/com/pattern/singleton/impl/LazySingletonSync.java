/**
 * 【单例模式】第 1 篇
 * 懒汉式（线程安全版）— synchronized 方法
 *
 * 优点：线程安全
 * 缺点：性能差，每次调用 getInstance() 都要抢锁，高并发下是瓶颈
 *
 * 面试加分：可以引出"双重检查锁"作为改进方案
 */
public class LazySingletonSync {

    private static LazySingletonSync INSTANCE;

    private LazySingletonSync() {
        System.out.println("LazySingletonSync 实例被创建了");
    }

    // synchronized 加在方法上，粒度粗，性能差
    public static synchronized LazySingletonSync getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingletonSync();
        }
        return INSTANCE;
    }
}
