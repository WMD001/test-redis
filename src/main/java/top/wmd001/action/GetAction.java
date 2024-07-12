package top.wmd001.action;

/**
 * Create by habit on 2024/7/11
 */
public class GetAction extends Action {

    public static Object get(String key) {
        Object value = connection.getJedis().get(key);
        if (value != null) {
            return value;
        } else {
            return "key not found";
        }
    }
}
