# markwon-syntax-highlight

代码块语法高亮插件，基于 [Prism4j](https://github.com/noties/Prism4j) 对 fenced code block 进行语法着色。

## 主要功能

- `SyntaxHighlightPlugin`：拦截代码块节点，对代码内容做语法高亮
- `Prism4jSyntaxHighlight`：Prism4j 语法高亮实现，可配置语言定义来源
- 内置主题：`Prism4jThemeDefault`（默认亮色）、`Prism4jThemeDarkula`（暗色 Darkula 配色），也可实现 `Prism4jTheme` 自定义
- `BaseCodeGrammar`：代码语法文法定制入口

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-syntax-highlight:1.0.0'
```

> 注意：当前 `libs/` 目录下的 prism4j jar 通过 `fileTree` 引入，不会体现在发布的 POM 依赖中，使用方需自行补充 prism4j 依赖。
