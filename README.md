# 23种设计模式精讲

<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-blue.svg" alt="Java">
  <img src="https://img.shields.io/badge/Design%20Patterns-23-green.svg" alt="Patterns">
  <img src="https://img.shields.io/badge/License-MIT-orange.svg" alt="License">
</p>

> 用讲故事的方式学 Java 设计模式，公众号「23种设计模式精讲」专题配套代码仓库

## 📖 专题介绍

每篇文章遵循「三步走」学习法：
1. 🏪 **生活故事** — 从真实场景建立直觉
2. 💻 **代码落地** — Java 实现 + Spring/JDK 源码分析
3. 📋 **面试突击** — 高频考点 + 回答要点

## 📂 已完成

| 篇 | 模式 | 文章 |
|---|------|------|
| 01 | 单例模式（Singleton） | [《为什么系统只能有一个配置中心？》](公众号文章链接) |

## 📂 目录结构

```
java-design-patterns/
├── 01-singleton/                 # 单例模式
│   ├── src/main/java/
│   │   └── com/pattern/singleton/
│   │       ├── impl/            # 各种实现方式
│   │       │   ├── HungrySingleton.java
│   │       │   ├── LazySingletonUnsafe.java
│   │       │   ├── LazySingletonSync.java
│   │       │   ├── DoubleCheckSingleton.java
│   │       │   ├── StaticInnerSingleton.java
│   │       │   └── EnumSingleton.java
│   │       ├── jdk/             # JDK 源码
│   │       │   └── RuntimeDemo.java
│   │       ├── spring/          # Spring 源码
│   │       │   └── SpringSingleton.java
│   │       └── application/     # 业务场景
│   │           └── ConfigCenter.java
│   └── pom.xml
├── 02-factory/                  # 工厂模式（敬请期待）
├── ...
└── pom.xml                      # 父 pom
```

## 🚀 运行方式

```bash
# 克隆仓库
git clone https://github.com/YanFAN0228/java-design-patterns.git

# 进入项目
cd java-design-patterns/01-singleton

# 编译运行
mvn compile exec:java -Dexec.mainClass="com.pattern.singleton.application.ConfigCenter"
```

## 📝 配套学习

- 📰 公众号：**「你的公众号名」**
- 🔢 专题：「23种设计模式精讲」
- 💬 Issues：学习疑问、面试题讨论

## 📜 License

MIT License - 欢迎 star & fork
