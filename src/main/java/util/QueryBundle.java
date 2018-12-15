package util;

import java.util.Locale;
import java.util.ResourceBundle;

public class QueryBundle {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("mySql_query");
    // класс извлекает информацию из файла Mysql_query.properties
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
