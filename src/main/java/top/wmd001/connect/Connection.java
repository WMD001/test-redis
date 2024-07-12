package top.wmd001.connect;

import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Create by habit on 2024/7/11
 */
public class Connection implements AutoCloseable {

    private Jedis jedis;
    @Getter
    private ConnectConfig config;

    private static Connection instance;

    public void connect(ConnectConfig config) {
        this.config = config;

        if (config.getTimeout() != 0) {
            jedis = new Jedis(config.getHost(), config.getPort(), config.getTimeout());
        } else {
            jedis = new Jedis(config.getHost(), config.getPort());
        }


        // auth
        if (StringUtils.hasText(config.getPassword())) {
            if (StringUtils.hasText(config.getUser())) {
                jedis.auth(config.getUser(), config.getPassword());
            } else {
                jedis.auth(config.getPassword());
            }
        }

        // db
        if (config.getDatabase() != 0) {
            jedis.select(config.getDatabase());
        }

    }

    public void reconnect(ConnectConfig config) {
        jedis.close();
        connect(config);
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public void del(String key) {
        jedis.del(key);
    }


    public Jedis getJedis() {
        Assert.notNull(jedis, "The service not yet connected");
        return jedis;
    }

    @Override
    public void close() throws Exception {
        jedis.close();
    }

}
