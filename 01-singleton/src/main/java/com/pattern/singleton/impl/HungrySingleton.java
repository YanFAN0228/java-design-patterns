/**
 * 【单例模式】第 1 篇
 * 饿汉式 — 静态常量实现
 *
 * 特点：类加载时就创建实例，线程安全，但没有延迟加载（懒加载）
 * 优点：实现简单，绝对线程安全
 * 缺点：无论是否用到，类加载时就创建，占用内存
 */
public class HungrySingleton {

    // 类加载时直接创建实例（利用类加载的线程安全性保证唯一）
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    // 私有构造函数，防止外部 new
    private HungrySingleton() {
        System.out.println("HungrySingleton 实例被创建了");
    }

    // 全局访问点
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    // 简单验证方法
    public void showMessage() {
        System.out.println("这是 HungrySingleton 的唯一实例！");
    }
}
