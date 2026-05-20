/**
 * 【单例模式】第 1 篇
 * 静态内部类 — 推荐写法（简单优雅）
 *
 * 核心原理：JVM 类加载机制天然保证线程安全
 * - 静态内部类不会随外部类加载而加载
 * - 只有调用 getInstance() 时，SingletonHolder 才会被加载
 * - JVM 底层保证类加载的线程安全性（类加载过程有锁保护）
 *
 * 优点：懒加载（需要时才创建）+ 线程安全 + 性能高（无需 synchronized）
 * 缺点：无明显缺点，是目前最推荐的实现方式之一
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {
        System.out.println("StaticInnerSingleton 实例被创建了");
    }

    // 静态内部类：外部类加载时不会加载，只有调用 getInstance 时才加载
    private static class SingletonHolder {
        // JVM 保证类加载的线程安全性，这里创建实例
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
