/**
 * 【单例模式】第 1 篇
 * 枚举单例 — 面试满分答案！
 *
 * 为什么枚举单例最安全？
 * 1. 线程安全：JVM 保证枚举实例创建的唯一性和线程安全性
 * 2. 防反射：通过反射调用 Constructor.setAccessible(true) 强制创建新实例会抛异常
 * 3. 防反序列化：JDK 底层保证反序列化时不会创建新对象
 *
 * 《Effective Java》作者 Joshua Bloch 强烈推荐！
 * "单元素的枚举类型是实现单例的最佳方法"
 *
 * 面试加分点：
 * - 如果面试官问"如何防止单例被破坏"，枚举是最佳答案
 * - 可以提到反射攻击和反序列化攻击，以及枚举天然免疫
 */
public enum EnumSingleton {

    INSTANCE;

    // 可以添加实例方法
    private String name = "ConfigCenter";

    public void doSomething() {
        System.out.println("枚举单例执行任务，名称：" + name);
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
