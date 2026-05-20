/**
 * 【单例模式】第 1 篇
 * JDK 源码解析 — java.lang.Runtime
 *
 * Runtime 类采用饿汉式单例！
 * JDK 源码：
 *   private static final Runtime currentRuntime = new Runtime();
 *   public static Runtime getRuntime() {
 *       return currentRuntime;
 *   }
 *
 * 整个 JVM 中只有一个 Runtime 实例，用于：
 * - 内存管理（gc、freeMemory、totalMemory）
 * - 进程控制（exec、exit）
 * - 钩子管理（addShutdownHook）
 */
public class RuntimeDemo {

    public static void main(String[] args) {
        // 获取 Runtime 实例
        Runtime runtime = Runtime.getRuntime();

        System.out.println("=== JDK Runtime 单例验证 ===");
        System.out.println("JVM 空闲内存: " + runtime.freeMemory() / 1024 / 1024 + " MB");
        System.out.println("JVM 总内存: " + runtime.totalMemory() / 1024 / 1024 + " MB");
        System.out.println("JVM 最大内存: " + runtime.maxMemory() / 1024 / 1024 + " MB");

        // 验证是同一个实例
        Runtime another = Runtime.getRuntime();
        System.out.println("\n两次获取的是否为同一实例: " + (runtime == another));

        // 手动触发 GC
        System.out.println("\n手动触发 GC 前空闲内存: " + runtime.freeMemory() / 1024 / 1024 + " MB");
        runtime.gc();
        System.out.println("GC 后空闲内存: " + runtime.freeMemory() / 1024 / 1024 + " MB");
    }
}
