package top.wmd001.command;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import top.wmd001.action.*;
import top.wmd001.config.ServicePromptProvider;
import top.wmd001.connect.ConnectConfig;
import top.wmd001.connect.Connection;

import java.util.Set;

/**
 * Create by habit on 2024/7/11
 */
@Command
public class OperationCommand {

    @Command(command = "connect", description = "connect to redis server")
    public void connect(@Option(defaultValue = "127.0.0.1", description = "redis server host, default 127.0.0.1") String host,
                        @Option(defaultValue = "6379", description = "redis server port, default 6379") int port,
                        @Option(description = "redis server user") String user,
                        @Option(description = "redis server password") String password,
                        @Option(defaultValue = "0", description = "redis server database, default 0") int database,
                        @Option(defaultValue = "2000", description = "redis server timeout, default 2000") int timeout
    ) {
        ConnectConfig config = new ConnectConfig(host, port, user, password, database, timeout);
        try {
            Connection.getInstance().connect(config);
            System.out.println("connect success to: " + config.getServer());
            Action.init();
            ServicePromptProvider.setPrompt(config.getServer());
        } catch (Exception e) {
            System.out.println("connect fail: " + e.getMessage());
        }
    }

    @Command(command = "select", description = "select database")
    public void select(@Option(description = "redis server database") int database) {
        SelectAction.select(database);
        System.out.println("select database: " + database);
        String prompt = "DB"+database + "@" + Connection.getInstance().getConfig().getServer();
        ServicePromptProvider.setPrompt(prompt);
    }

    @Command(command = "list", description = "list all keys")
    public void listKeys() {
        Set<String> keys = ListAction.listKeys();
        keys.forEach(System.out::println);
    }

    @Command(command = "get", description = "get value by key")
    public void get(@Option(description = "key") String key) {
        System.out.println(GetAction.get(key));
    }

    @Command(command = "set", description = "set value by key")
    public void set(@Option(required = true, description = "key") String key,
                    @Option(required = true, description = "value") String value) {
        SetAction.set(key, value);
    }
    
}
