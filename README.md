# LeetCode Notebook

本地算法知识库，保存 LeetCode 题目、解析和实现。题目按每 50 个题号分组，Java、Python、Go 分别管理代码、依赖和测试。

## 内容入口

- [题目与题号区间](problems/README.md)
- [Java 工程](java/README.md)
- [Python 工程](python/README.md)
- [Go 工程](go/README.md)
- [AI 协作约定](AGENTS.md)：根据题目链接准备题面、图片、代码骨架和测试。

## 目录结构

```text
leetcode-notebook/
├── problems/       # 题号区间 → 单题 → 题面、解析及 assets 图片目录
├── java/           # Maven 工程
├── python/         # uv 项目
├── go/             # Go module
├── go.work         # Go 工作区，纳入 ./go
└── AGENTS.md       # AI 准备题目的流程与维护规则
```

## 环境与运行

需要 JDK 21、Maven 3.9+、Python 3.12+、uv 和 Go 1.24+。Python 默认版本在 [python/.python-version](python/.python-version) 中固定为 3.14，依赖版本由 [uv.lock](python/uv.lock) 锁定。

在仓库根目录运行：

```bash
# Java
mvn -f java/pom.xml test

# Python：首次运行会同步项目虚拟环境和依赖
uv sync --directory python --locked
uv run --directory python --locked pytest

# Go：顶层工作区只包含 go/ 模块
go test ./go/...
```

按当前学习阶段配置所需语言即可。单题测试和调试方式见各语言目录的 README。

## 在 IDE 中打开

Java 使用 IntelliJ IDEA，Python 使用 PyCharm，Go 使用 GoLand。都可以打开仓库根目录，在同一窗口阅读 Markdown 和调试当前语言代码；工程关联、解释器和运行目录按对应语言 README 配置。
