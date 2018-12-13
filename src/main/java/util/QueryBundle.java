package util;

import java.util.ResourceBundle;

public class QueryBundle {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("Mysql_query");
    // класс извлекает информацию из файла Mysql_query.properties
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
