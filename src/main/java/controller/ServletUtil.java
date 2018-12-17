package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ServletUtil {

    public static Map<String, HttpSession> getLoggedUsers(HttpServletRequest request) {
        return (Map<String, HttpSession>) request.getServletContext().getAttribute("loggedUsers");
    }

    public static void setLoggedUsers(HttpServletRequest request, Map<String, HttpSession> loggedUsers) {
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
