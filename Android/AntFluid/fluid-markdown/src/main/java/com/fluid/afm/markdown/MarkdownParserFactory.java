package com.fluid.afm.markdown;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fluid.afm.markdown.span.LinkClickSpan;
import com.fluid.afm.markdown.text.AfmTextPlugin;
import com.fluid.afm.markdown.widget.PrinterMarkDownTextView;
import com.fluid.afm.styles.MarkdownStyles;

import org.commonmark.node.Link;

import java.util.ArrayList;
import java.util.List;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.movement.MovementMethodPlugin;

public class MarkdownParserFactory {
    public static final String TAG = "MarkdownPluginsCreator";

    public static MarkdownParser create(Context context, PrinterMarkDownTextView textView) {
        return create(context, textView, MarkdownStyles.getDefaultStyles(), null);
    }

    public static void bindMarkdownParser(Context context, PrinterMarkDownTextView textView, MarkdownStyles styles, ElementClickEventCallback callback) {
        create(context, textView, styles, callback);
    }

    public static MarkdownParser create(Context context, PrinterMarkDownTextView textView, MarkdownStyles styles, ElementClickEventCallback callback) {
        return create(context, textView, styles, callback, null);
    }

    public static MarkdownParser create(Context context, PrinterMarkDownTextView textView, MarkdownStyles styles,
                                        ElementClickEventCallback callback, List<? extends MarkwonPlugin> extensionPlugins) {
        ArrayList<MarkwonPlugin> finalPlugins = getDefaultPlugins(context, textView, callback);
        if (extensionPlugins != null) {
            finalPlugins.addAll(extensionPlugins);
        }
        return new MarkdownParser(context, finalPlugins, textView, styles);
    }

    public static ArrayList<MarkwonPlugin> getDefaultPlugins(Context context, PrinterMarkDownTextView textView, ElementClickEventCallback callback) {
        ArrayList<MarkwonPlugin> plugins = new ArrayList<>();
        plugins.add(linkPlugin(callback));
        plugins.add(printStreamPlugin(context, callback));
        plugins.add(MovementMethodPlugin.link());
        return plugins;
    }

    public static AbstractMarkwonPlugin linkPlugin(ElementClickEventCallback callback) {
        return new AbstractMarkwonPlugin() {
            @Override
            public void configureSpansFactory(@NonNull MarkwonSpansFactory.Builder builder) {
                builder.setFactory(Link.class, new SpanFactory() {
                    @Nullable
                    @Override
                    public Object getSpans(@NonNull MarkwonConfiguration configuration, @NonNull RenderProps props) {
                        return new LinkClickSpan(CoreProps.LINK_DESTINATION.require(props), props, configuration.theme(), callback);
                    }
                });
            }
        };
    }

    public static AbstractMarkwonPlugin printStreamPlugin(Context context, ElementClickEventCallback linkClickedCallback) {
        return new AfmTextPlugin(context).setCustomClickListener(linkClickedCallback);
    }
}
