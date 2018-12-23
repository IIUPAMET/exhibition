package controller;


import controller.command.*;
import di.CommandModule;
import service.ExhibitionService;
import service.ExhibitionSeviceImpl;
import service.UserService;
import service.UserServiceImpl;

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

        commands.put("home",  CommandModule.getInstance().getHomePageCommand());
        commands.put("admin/createexhibition", CommandModule.getInstance().getCreateExhibitionPageCommand());
        commands.put("admin/create", CommandModule.getInstance().getCreateExhibitionCommand());
        commands.put("index", CommandModule.getInstance().getIndexPageCommand());
        commands.put("login",  CommandModule.getInstance().getLoginCommand());
        commands.put("logout", CommandModule.getInstance().getLogOutCommand());
        commands.put("singup",  CommandModule.getInstance().getSingUpCommand());
        commands.put("user/user", CommandModule.getInstance().getUserPageCommand());
        commands.put("user/addwish",  CommandModule.getInstance().getAddWishCommand());

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
