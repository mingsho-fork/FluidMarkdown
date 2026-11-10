# markwon-core

Markwon 渲染引擎的核心模块，基于 [commonmark](https://github.com/atlassian/commonmark-java) 将 Markdown 解析为 AST 并渲染成 Android `TextView` 的 Span 样式。

## 主要功能

- **Markwon 引擎**：`Markwon` / `Markwon.Builder` 构建，`MarkwonPlugin` 插件化架构，可自由扩展解析与渲染行为
- **CorePlugin**：标题、粗体/斜体、有序/无序列表、引用、行内代码、代码块、分隔线、链接等基础语法渲染
- **MarkwonTheme**：统一的 Markdown 主题样式管理（字号、颜色、间距等），支持动态更新
- **SpanFactory 体系**：每种语法节点对应可替换的 Span 工厂，便于定制样式
- 提供渲染所需的公共基础类与工具（`CoreProps`、Span 对象池等）

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-core:1.0.0'
```

> 其余扩展模块均依赖本模块（`api project(':markwon-core')`）。
