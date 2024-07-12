package top.wmd001.action;

import java.util.Set;

/**
 * Create by habit on 2024/7/11
 */
public class ListAction extends Action {
    public static Set<String> listKeys() {
        return connection.getJedis().keys("*");
    }
}
