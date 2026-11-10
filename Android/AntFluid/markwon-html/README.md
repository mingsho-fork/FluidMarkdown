# markwon-html

Markdown 内嵌 HTML 片段的解析与渲染插件，让 Markdown 文档中的 HTML 标签在 TextView 中呈现对应样式。

## 主要功能

- `HtmlPlugin`：解析 Markdown 中的内联/块级 HTML，交由 `TagHandler` 渲染
- **TagHandler 体系**：可扩展的标签处理器
  - 内置处理器：标题、列表、引用、链接、图片（含 `style` 尺寸解析）、加粗、斜体、删除线、上下标（`<sub>`/`<sup>`）、下划线等
  - `TagHandlerNoOp` / `SimpleTagHandler`：简化自定义处理的基类
- 内置精简版 jsoup 解析器（`io.noties.markwon.html.jsoup`），无第三方 HTML 解析依赖
- CSS 行内样式解析（`CssInlineStyleParser`）
- fluid 定制扩展：`CustomHtmlPlugin`、`<mark>` 高亮、定义列表（`DefinitionListPlugin`）、图标链接等标签处理

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-html:1.0.0'
```

> 依赖 markwon-core 与 fluid-markdown。
