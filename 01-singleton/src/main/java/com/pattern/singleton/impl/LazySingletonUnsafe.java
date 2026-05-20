/**
 * 【单例模式】第 1 篇
 * 懒汉式（线程不安全版）— 反面教材
 *
 * ⚠️ 面试千万别说这个写法！
 *
 * 问题分析：
 * - 线程 A 执行到 INSTANCE = new LazySingletonUnsafe() 时
 * - 线程 B 也同时通过了 if (INSTANCE == null) 的检查
 * - 两个线程都 new 了一个新对象，违背了单例原则
 *
 * 适用场景：单线程环境（但实际几乎不用）
 */
public class LazySingletonUnsafe {

    private static LazySingletonUnsafe INSTANCE;

    private LazySingletonUnsafe() {
        System.out.println("LazySingletonUnsafe 实例被创建了");
    }

    public static LazySingletonUnsafe getInstance() {
        // ⚠️ 线程A和线程B可能同时通过这里！
        if (INSTANCE == null) {
            // ⚠️ 这里发生了指令重排序的风险
            INSTANCE = new LazySingletonUnsafe();
            // new 操作分解为：
            // 1. 分配内存
            // 2. 调用构造函数
            // 3. 将引用赋值给 INSTANCE
            // 线程B可能在步骤2之前看到非null的INSTANCE（半初始化对象）
        }
        return INSTANCE;
    }
}
