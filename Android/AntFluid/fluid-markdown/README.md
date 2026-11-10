# fluid-markdown

Markdown 渲染的统一封装层（对外门面模块），组装各 markwon 扩展插件，提供开箱即用的流式 Markdown 渲染能力，面向 AI 对话/聊天流式输出场景做了大量定制。

## 主要功能

- **一站式集成**：`MarkdownParserFactory` / `MarkdownParser` 自动组装插件链（core、图片、表格、代码高亮、公式、HTML 等），无需手动拼装
- **流式打印**：`PrinterMarkDownTextView` 支持逐字流式渲染（打字机效果），`StreamOutStateObserver` 观察流式状态，处理流式过程中的未闭合语法
- **初始化入口**：`AFMInitializer.init()` 注入全局 `ImageHandler`（图片加载）、`LogHandler`（日志）、`BackgroundTaskHandler`（后台任务）
- **样式体系**：`MarkdownStyles` 主题样式配置，支持渲染过程中动态更新样式并即时重绘
- **事件交互**：`ElementClickEventCallback` 统一处理链接、图片、脚注等元素点击
- **聊天场景扩展 Span**：脚注（`FootnoteSpan` 系列）、图标链接（`IconLinkSpan`）、图标（`IconSpan`）、上标图片（`SuperscriptImageSpan`）、圆角背景（`RoundedBackgroundSpan`）、透明度/下划线/缩进等定制 Span

## 引入方式

```groovy
implementation 'io.github.mingsho:fluid-markdown:1.0.0'
```

> 依赖 markwon-core（api 传递）。使用前先调用 `AFMInitializer.init(...)` 完成初始化。
