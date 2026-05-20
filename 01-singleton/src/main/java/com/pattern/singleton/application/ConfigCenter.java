/**
 * 【单例模式】第 1 篇
 * 业务场景实战 — 配置中心（ConfigCenter）
 *
 * 故事背景：
 * 某电商平台的双十一事故——两台服务器部署了两个配置中心，
 * 导致同一商品对不同用户显示不同价格。
 *
 * 解决方案：配置中心必须全局唯一，所有服务器共享同一份配置。
 *
 * 实际生产中的配置中心选型：
 * - Apollo（携程开源）：分布式配置中心，完整单例集群方案
 * - Nacos（阿里开源）：服务发现 + 配置管理，支持单机部署
 * - Spring Cloud Config：Spring 生态的配置中心
 *
 * 本示例展示一个简化版的配置中心单例实现。
 */
public class ConfigCenter {

    // 双重检查锁实现
    private static volatile ConfigCenter INSTANCE;

    // 模拟配置数据
    private String dbUrl;
    private String redisHost;
    private int maxConnections;

    // 私有构造，外部无法 new
    private ConfigCenter() {
        // 模拟从配置文件或远程配置中心加载配置
        this.dbUrl = "jdbc:mysql://localhost:3306/shop";
        this.redisHost = "127.0.0.1:6379";
        this.maxConnections = 100;
        System.out.println("ConfigCenter 初始化完成，连接到配置中心...");
    }

    public static ConfigCenter getInstance() {
        if (INSTANCE == null) {
            synchronized (ConfigCenter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConfigCenter();
                }
            }
        }
        return INSTANCE;
    }

    // 配置热更新（模拟）
    public void reloadConfig() {
        System.out.println("从远程配置中心重新加载配置...");
        this.dbUrl = "jdbc:mysql://prod-db:3306/shop";
        this.redisHost = "prod-redis:6379";
        this.maxConnections = 500;
        System.out.println("配置已更新！");
    }

    // 打印当前配置
    public void printConfig() {
        System.out.println("\n=== 当前配置 ===");
        System.out.println("数据库: " + dbUrl);
        System.out.println("Redis: " + redisHost);
        System.out.println("最大连接数: " + maxConnections);
    }

    public static void main(String[] args) {
        // 演示多线程场景下获取同一个实例
        ConfigCenter c1 = ConfigCenter.getInstance();
        ConfigCenter c2 = ConfigCenter.getInstance();
        ConfigCenter c3 = ConfigCenter.getInstance();

        System.out.println("c1 == c2: " + (c1 == c2));
        System.out.println("c2 == c3: " + (c2 == c3));

        c1.printConfig();

        System.out.println("\n模拟配置更新:");
        c1.reloadConfig();
        c2.printConfig();  // c2 和 c1 是同一实例，所以配置也更新了
    }
}
