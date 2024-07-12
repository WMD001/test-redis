package top.wmd001.config;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * Create by habit on 2024/7/11
 */
@Component
public class ServicePromptProvider implements PromptProvider {

    public static String prompt = "test-redis";

    public static void setPrompt(String prompt) {
        ServicePromptProvider.prompt = prompt;
    }

    @Override
    public AttributedString getPrompt() {
        return new AttributedString(prompt + "> ");
    }
}
