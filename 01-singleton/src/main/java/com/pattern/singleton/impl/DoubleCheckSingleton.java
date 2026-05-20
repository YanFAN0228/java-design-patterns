/**
 * 【单例模式】第 1 篇
 * 双重检查锁（Double Check Lock）— 推荐写法
 *
 * 为什么需要 volatile？
 * - new LazySingleton() 实际上分解为 3 步：
 *   1. 分配内存
 *   2. 调用构造函数初始化
 *   3. 将引用赋值给 INSTANCE
 * - JVM 可能指令重排序，导致顺序变为 1 -> 3 -> 2
 * - 此时线程 B 看到 INSTANCE != null，但对象还未初始化完成！
 * - volatile 禁止指令重排序（通过内存屏障），保证对象完全初始化后才可见
 *
 * 为什么需要两次 if (INSTANCE == null)？
 * - 第一次：避免不必要的同步，大幅提升并发性能
 * - 第二次：防止多个线程同时通过第一次检查后，重复创建实例
 */
public class DoubleCheckSingleton {

    // volatile 关键字：防止指令重排序 + 保证可见性
    private static volatile DoubleCheckSingleton INSTANCE;

    private DoubleCheckSingleton() {
        System.out.println("DoubleCheckSingleton 实例被创建了");
    }

    public static DoubleCheckSingleton getInstance() {
        // 第一次检查：大多数情况下 INSTANCE 已有值，直接返回，避免抢锁
        if (INSTANCE == null) {
            synchronized (DoubleCheckSingleton.class) {
                // 第二次检查：防止多个线程同时通过第一次检查后重复创建
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
