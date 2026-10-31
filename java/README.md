# Java

使用 JDK 21 与 JUnit 5，一个 Maven 工程管理全部题目。每题一个包，同题的不同算法使用不同类名。

## 运行与调试

在仓库根目录：

```bash
mvn -f java/pom.xml test
mvn -f java/pom.xml -Dtest=TwoSumTest test
```

在 IntelliJ IDEA 中打开仓库根目录，用 Maven 工具窗口的 Link Maven Projects 关联 `java/pom.xml`，设置 JDK 21 并完成同步。从 `TwoSumTest` 运行或 Debug，在实现中打断点。

题目 Markdown 位于顶层 `problems/`，可与代码分屏查看。

## 包与依赖边界

- 实现：`src/main/java/leetcode/r0001_0050/p0001/`。
- 测试：`src/test/java/leetcode/r0001_0050/p0001/`。
- 算法需要的共享类型，按需增加到 `src/main/java/leetcode/common/`。
- 测试专用构造器和断言工具，按需增加到 `src/test/java/leetcode/support/`。

测试可以依赖 main，main 不依赖 test。题号区间不创建 Maven module，也不单独维护 POM。

提交 LeetCode 时，移除包声明并按题目要求调整类名、方法签名和节点类型。

[题目索引](../problems/README.md) · [仓库说明](../README.md)
