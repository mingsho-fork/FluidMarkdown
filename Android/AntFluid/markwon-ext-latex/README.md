# markwon-ext-latex

LaTeX 数学公式渲染扩展，基于 [JLatexMath](https://github.com/noties/jlatexmath-android) 在 TextView 中渲染数学公式。

## 主要功能

- `JLatexMathPlugin`：支持块级公式（`$$...$$`）与行内公式（`$...$`）两种语法
- 块级公式通过 `JLatexAsyncDrawable` 异步渲染，不阻塞主线程；行内公式通过 `JLatexInlineAsyncDrawableSpan` 嵌入文本流
- `JLatexMathTheme`：公式颜色、字号、内边距等样式配置
- 行内公式解析依赖 markwon-inline-parser 的内联处理器扩展（`JLatexMathInlineProcessor`）

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-ext-latex:1.0.0'
```

> 依赖 markwon-core 与 markwon-inline-parser。
