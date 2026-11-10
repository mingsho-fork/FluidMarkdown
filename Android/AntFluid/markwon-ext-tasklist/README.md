# markwon-ext-tasklist

GFM 任务列表扩展，渲染 `- [ ]` / `- [x]` 待办清单语法。

## 主要功能

- `TaskListPlugin`：解析任务列表项并渲染为可绘制的复选框
- `TaskListSpan`：复选框 Span，支持已勾选/未勾选状态，可配置是否响应用户点击切换
- `TaskListDrawable`：复选框绘制样式，支持自定义颜色与尺寸

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-ext-tasklist:1.0.0'
```

> 依赖 markwon-core。
