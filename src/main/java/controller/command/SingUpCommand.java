package controller.command;

import service.*;
import validators.EmailValidator;
import validators.StringValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingUpCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

        Map<String, String> fieldsMap = new ConcurrentHashMap<>();
        if (request.getParameter("login") == null) {
            return "/singup.jsp";
        }
        fieldsMap.put("login", request.getParameter("login"));
        fieldsMap.put("pass", request.getParameter("pass"));
        fieldsMap.put("repeatpass", request.getParameter("repeatpass"));
        fieldsMap.put("ukrname", request.getParameter("ukrname"));
        fieldsMap.put("engname", request.getParameter("engname"));
        fieldsMap.put("email", request.getParameter("email"));

        Map<String, String> uncorectMap = validate(fieldsMap);

        if (uncorectMap.isEmpty()) {
            userService.create(fieldsMap.get("login"),
                    fieldsMap.get("pass"),
                    fieldsMap.get("ukrname"),
                    fieldsMap.get("engname"),
                    fieldsMap.get("email"));
            return "redirect: login";
        } else {
            request.setAttribute("incorrectMap", uncorectMap);
            return "/singup.jsp";
        }
    }

    public Map<String, String> validate(Map<String, String> fieldsMap) {
        Map<String, String> uncorectMap = new ConcurrentHashMap<>();
        if (!StringValidator.validate(fieldsMap.get("login"))) {
            uncorectMap.put("login", "Login is mandatory");
        }
        if (!StringValidator.validate(fieldsMap.get("pass"))) {
            uncorectMap.put("pass", "Password is mandatory");
        } else {
            if (!fieldsMap.get("pass").equals(fieldsMap.get("repeatpass"))) {
                uncorectMap.put("repeatpass", "incorrect repeat password");
            }
        }
        if (!StringValidator.validate(fieldsMap.get("ukrname"))) {
            uncorectMap.put("ukrname", "First Ukrainian Name is mandatory");
        }
        if (!StringValidator.validate(fieldsMap.get("engname"))) {
            uncorectMap.put("engname", "First English Name is mandatory");
        }
        if (!EmailValidator.validate(fieldsMap.get("email"))) {
            uncorectMap.put("email", "Email must be a well-formed address");
        }
        return uncorectMap;
    }
}

