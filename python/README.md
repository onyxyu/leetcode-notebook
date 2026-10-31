# Python

使用 `src` 布局、uv 虚拟环境和 pytest。支持 Python 3.12+，`.python-version` 指定的默认开发版本为 3.14。

## 安装与测试

在仓库根目录：

```bash
uv sync --directory python --locked
uv run --directory python --locked pytest
uv run --directory python --locked pytest tests/r0001_0050/p0001/test_two_sum.py
```

`uv sync` 创建 `python/.venv` 并以开发模式安装本项目，测试从 `leetcode_solutions` 包导入实现。依赖在 `pyproject.toml` 中声明，版本由 `uv.lock` 锁定；调整依赖后用 `uv lock --directory python` 更新锁文件。

`--directory python` 同时切换工作目录，保证 pytest 使用这里的配置与测试路径。

若希望复用当前终端的 Python（例如 Miniforge 环境中的解释器），首次同步时显式指定：

```bash
uv sync --directory python --python "$(command -v python3)" --locked
```

解释器需满足项目的版本要求，本机路径不写入共享配置。

## PyCharm

1. 打开仓库根目录，保留 `problems` 和 `python` 在同一窗口。
2. 识别或配置 `python/pyproject.toml` 对应的子工程，选择 `python/.venv/bin/python` 作为解释器。
3. 若源码未被正确识别，将 `python/src` 标记为 Sources Root；运行时仍使用 `uv sync` 安装的包。
4. 在 pytest 运行配置中将工作目录设为 `python`，选择当前题目测试文件。从测试入口运行或 Debug。

克隆到其他机器后，用 uv 重建虚拟环境。

## 目录约定

- 实现：`src/leetcode_solutions/r0001_0050/p0001_two_sum/`。
- 测试：`tests/r0001_0050/p0001/test_two_sum.py`。
- 同题的不同解法用不同模块，各模块提供一致的函数签名。
- 普通源码包包含 `__init__.py`；测试用 pytest 的 importlib 模式发现，不要求与源码包逐层同名。

提交 LeetCode 时，按题目要求将函数改为 `Solution` 中的方法，并保留平台要求的签名。

[题目索引](../problems/README.md) · [仓库说明](../README.md)
