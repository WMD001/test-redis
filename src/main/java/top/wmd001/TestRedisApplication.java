package top.wmd001;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.command.annotation.EnableCommand;

@CommandScan(basePackages = "top.wmd001.command")
@SpringBootApplication
public class TestRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRedisApplication.class, args);
    }

//    @Bean
//    public Terminal terminal() throws Exception {
//        return TerminalBuilder.builder()
//                .jansi(true) // Enable Jansi
//                .system(true)
//                .build();
//    }

}
