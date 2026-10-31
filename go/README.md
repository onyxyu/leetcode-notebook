# Go

一个 Go module 管理全部题目，每题一个 package，实现与测试同目录。最低 Go 版本为 1.24，当前实现仅依赖标准库。

## 测试与调试

在仓库根目录：

```bash
go test ./go/...
go test -v ./go/problems/r0001_0050/p0001
```

进入 `go` 目录后可运行 `go test ./...`。根目录的 `go.work` 纳入了 `./go`，从根目录测试时指定 `./go/...`。

在 GoLand 中打开仓库根目录，配置 Go SDK 并启用 Go modules 支持，通过顶层 `go.work` 识别模块。从 `solution_test.go` 运行或 Debug，在实现中设置断点；题目文档位于同一窗口的 `problems` 中。

## 包与命名

第 1 题放在 `problems/r0001_0050/p0001/`，声明 `package p0001`。区间只是路径分组，不创建额外 `go.mod`。

同题不同算法使用不同函数名，例如 `twoSumBruteForce`、`twoSumHashMap`，文件名也按算法区分。当前函数仅供本题及其测试使用，不导出。提交 LeetCode 时，按题目要求调整函数名、签名和节点类型。

[题目索引](../problems/README.md) · [仓库说明](../README.md)
