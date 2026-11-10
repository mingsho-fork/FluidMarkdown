# markwon-ext-tables

GFM 表格扩展，渲染管道符表格语法，并包含本项目对表格、代码块的增强样式实现。

## 主要功能

- `TablePlugin`：解析并渲染 GFM 表格（表头、对齐方式、单元格边框）
- `TableRowSpan` / `TableSpan`：表格行与单元格 Span 渲染，支持列对齐、奇偶行样式
- fluid 定制增强
  - `TableLineSpacingSpan` / `TopSpacingSpan`：表格行距与顶部间距优化
  - `TableBlockTitleSpan` / `CodeBlockTitleSpan`：表格块、代码块标题栏样式
  - `CodeBlockPlugin` / `CodeBlockLineSpacingSpan`：代码块样式与行距
  - `MarkdownAwareMovementMethod`：表格区域内的触摸/点击事件处理
  - 预览能力：`MarkDownPreviewActivity` 等调试预览 UI

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-ext-tables:1.0.0'
```

> 依赖 markwon-core 与 fluid-markdown。
