# markwon-image

Markdown 图片加载与渲染插件，提供图片的异步加载、解码与占位展示。

## 主要功能

- `ImagesPlugin`：渲染 `![alt](url)` 图片节点，基于 `AsyncDrawable` 异步加载并自适应占位尺寸
- **SchemeHandler 体系**：按协议分发加载
  - `NetworkSchemeHandler`：http/https 网络图片
  - `FileSchemeHandler`：本地文件
  - `DataUriSchemeHandler`：Base64 data URI 图片
- `MediaDecoder`：图片解码，支持 `DefaultDownScalingMediaDecoder` 按屏幕尺寸降采样，避免大图 OOM
- fluid 定制扩展
  - `ImageLoaderSchemeHandler`：对接业务方自定义图片加载器（`AFMInitializer` 注入的 `ImageHandler`）
  - `CircleDrawable`：圆形/圆角图片裁剪

## 引入方式

```groovy
implementation 'io.github.mingsho:markwon-image:1.0.0'
```

> 依赖 markwon-core。
