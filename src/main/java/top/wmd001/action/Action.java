package top.wmd001.action;

import top.wmd001.connect.Connection;

/**
 * Create by habit on 2024/7/11
 */
public class Action {

    protected static Connection connection;

    public static void init() {
        connection = Connection.getInstance();
    }

}
