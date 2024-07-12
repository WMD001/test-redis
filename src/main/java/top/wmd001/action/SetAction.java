package top.wmd001.action;

/**
 * Create by habit on 2024/7/11
 */
public class SetAction extends Action {

    public static void set(String key, String value) {
        connection.getJedis().set(key, value);
    }

    public static void set(String key, long seconds) {
        connection.getJedis().expire(key, seconds);
    }

    public static void set(String key, String value, long seconds) {
        connection.getJedis().setex(key, seconds, value);
    }

}
