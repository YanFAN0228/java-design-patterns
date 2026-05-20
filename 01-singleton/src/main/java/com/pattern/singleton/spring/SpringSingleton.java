/**
 * 【单例模式】第 1 篇
 * Spring 源码解析 — Bean 的作用域
 *
 * Spring 默认所有 Bean 都是单例！
 * - 整个 Spring 容器中只有一个共享实例
 * - 每次注入都是同一个对象
 *
 * Spring 为什么要用单例？
 * 1. 性能：避免频繁创建销毁对象
 * 2. 线程安全：Bean 中的无状态代码可以安全共享
 * 3. 统一管理：全局配置、数据库连接池等只需一份
 *
 * 注意：单例 Bean 中不要存放可变的实例变量（线程安全问题）
 *       需要线程隔离时，使用 @Scope("prototype") 创建新实例
 *
 * 底层实现：DefaultSingletonBeanRegistry 中的 singletonObjects Map
 */
public class SpringSingleton {

    private String name;
    private int requestCount = 0;

    // Spring 默认 scope = singleton
    // @Component 注解后，Spring 容器启动时就创建了唯一一个实例

    public SpringSingleton() {
        System.out.println("SpringSingleton Bean 被创建了（单例）");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequestCount() {
        return requestCount;
    }

    // ⚠️ 计数器的使用要注意线程安全！
    public void increment() {
        this.requestCount++;
    }
}
