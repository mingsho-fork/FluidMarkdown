package com.fluid.markdown;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;

import com.fluid.afm.MarkdownAwareMovementMethod;
import com.fluid.afm.R;
import com.fluid.afm.func.IImageClickCallback;
import com.fluid.afm.markdown.ElementClickEventCallback;
import com.fluid.afm.markdown.code.CodeBlockPlugin;
import com.fluid.afm.markdown.html.CustomHtmlPlugin;
import com.fluid.afm.markdown.html.HtmlMarkTagHandler;
import com.fluid.afm.markdown.html.HtmlParaTagHandler;
import com.fluid.afm.markdown.html.HtmlSpanTagHandler;
import com.fluid.afm.markdown.icon.IconSpanHandler;
import com.fluid.afm.markdown.iconlink.IconLinkSpanHandler;
import com.fluid.afm.markdown.list.DefinitionListPlugin;
import com.fluid.afm.markdown.widget.PrinterMarkDownTextView;
import com.fluid.afm.network.ImageLoaderSchemeHandler;
import com.fluid.afm.utils.MDLogger;
import com.fluid.afm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.ext.tasklist.TaskListPlugin;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.DefaultDownScalingMediaDecoder;
import io.noties.markwon.image.ImagesPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParser;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import io.noties.markwon.movement.MovementMethodPlugin;
import io.noties.markwon.syntax.SyntaxHighlightPlugin;

public final class SampleMarkdownPlugins {
    private static final String TAG = "SampleMarkdownPlugins";

    private SampleMarkdownPlugins() {
    }

    public static List<MarkwonPlugin> create(Context context, PrinterMarkDownTextView textView,
                                      ElementClickEventCallback callback) {
        List<MarkwonPlugin> plugins = new ArrayList<>();
        plugins.add(imagePlugin(context, callback));
        plugins.add(htmlPlugin(context, textView, callback));
        plugins.add(MovementMethodPlugin.create(MarkdownAwareMovementMethod.create()));
        plugins.add(createJLatexMathPlugin(context));
        plugins.add(SyntaxHighlightPlugin.createDefault());
        plugins.add(StrikethroughPlugin.create());
        plugins.add(TaskListPlugin.create(context));
        plugins.add(DefinitionListPlugin.create());
        plugins.add(TablePlugin.create(context));
        plugins.add(CodeBlockPlugin.create(context, true));
        plugins.add(MarkwonInlineParserPlugin.create(MarkwonInlineParser.factoryBuilder()));
        return plugins;
    }

    private static ImagesPlugin imagePlugin(Context context, ElementClickEventCallback callback) {
        IImageClickCallback imageClickCallback = (url, description) -> {
            if (callback != null) {
                callback.onImageClicked(url, description);
            }
        };
        return ImagesPlugin.create(imageClickCallback)
                .addSchemeHandler(ImageLoaderSchemeHandler.create(context))
                .addMediaDecoder(DefaultDownScalingMediaDecoder.create(
                        Utils.getScreenWidth(context) - 2 * Utils.dpToPx(context, 16f), 0))
                .placeholderProvider(new ImagesPlugin.PlaceholderProvider() {
                    @Nullable
                    @Override
                    public Drawable providePlaceholder(@NonNull AsyncDrawable drawable) {
                        return AppCompatResources.getDrawable(context, R.drawable.default_placeholderdefault);
                    }
                });
    }

    private static AbstractMarkwonPlugin htmlPlugin(Context context, TextView textView,
                                                     ElementClickEventCallback callback) {
        return CustomHtmlPlugin.create()
                .addHandler(new HtmlSpanTagHandler(context, callback))
                .addHandler(new HtmlMarkTagHandler())
                .addHandler(new HtmlParaTagHandler(context))
                .addHandler(new IconLinkSpanHandler(textView, callback))
                .addHandler(new IconSpanHandler(textView));
    }

    private static AbstractMarkwonPlugin createJLatexMathPlugin(Context context) {
        JLatexMathPlugin.init(context);
        float size = Utils.dpToPx(context, 16f);
        JLatexMathPlugin.BuilderConfigure configure = builder -> {
            builder.blocksEnabled(true);
            builder.inlinesEnabled(true);
            builder.blocksLegacy(true);
            builder.errorHandler(new JLatexMathPlugin.ErrorHandler() {
                @Nullable
                @Override
                public Drawable handleError(@NonNull String latex, @NonNull Throwable error) {
                    MDLogger.e(TAG, "latex error:" + latex, error);
                    return null;
                }
            });
        };
        return JLatexMathPlugin.create(size, configure);
    }
}
