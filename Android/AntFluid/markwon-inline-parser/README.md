# markwon-inline-parser

自定义 Markdown 内联元素解析插件，基于 commonmark 的内联解析机制实现，可注册自定义的分隔符与内联处理器。

## 主要功能

- `MarkwonInlineParserPlugin`：以插件形式替换默认的内联解析流程
- 内置完整的内联处理器：反引号代码、强调、链接、图片、自动链接、HTML 内联、实体转义、换行等
- `StaggeredDelimiterProcessor`：支持多种分隔符的交错处理
- fluid 定制扩展：`OiintInlineProcessor`（`oiint` 数学积分符号的内联解析支持）

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-inline-parser:1.0.0'
```

> 依赖 markwon-core；markwon-ext-latex 依赖本模块实现行内公式解析。
