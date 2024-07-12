package top.wmd001.action;

/**
 * Create by habit on 2024/7/11
 */
public class SelectAction extends Action {

    public static void select(int database) {
        connection.getJedis().select(database);
    }

}
