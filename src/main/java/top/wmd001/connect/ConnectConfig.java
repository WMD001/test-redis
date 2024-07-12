package top.wmd001.connect;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create by habit on 2024/7/11
 */

@Data
@AllArgsConstructor
public class ConnectConfig {

    private String host;
    private int port;
    private String user;
    private String password;
    private int database;
    private int timeout;

    public String getServer() {
        return host + ":" + port;
    }

}
