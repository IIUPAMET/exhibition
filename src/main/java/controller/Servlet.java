package controller;


import controller.command.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/exhib/*")
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();


    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new ConcurrentHashMap<String, HttpSession>());

        commands.put("home", new HomePageCommand());
        commands.put("admin/createexhibition", new CreateExhibitionPageCommand());
        commands.put("admin/create", new CreateExhibitionCommand());
        commands.put("index", new IndexPageCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("singup", new SingUpCommand());
        commands.put("user/user", new UserPageCommand());

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Command command = getCommand(request);
        String page = null;
        try {
            page = command.execute(request);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (page.contains("redirect: ")) {
            response.sendRedirect(request.getContextPath()+"/exhib/" + page.replaceAll("redirect: ", ""));
        } else {
            request.getRequestDispatcher(page).forward(request,response);
        }
    }

    private Command getCommand(HttpServletRequest request){
        String path = request.getRequestURI();
        path = path.replaceAll(".*/exhib/" , "");

        return commands.getOrDefault(path, (r)-> "/index.jsp");
    }
}
