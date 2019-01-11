package controller.filter;

import controller.command.BuyTicketCommand;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.text.MessageFormat;

public class AdminAccessFilter implements Filter {
    public static final Logger LOG = Logger.getLogger(AdminAccessFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();

        User user = (User) request.getSession().getAttribute("user");
        LOG.debug(MessageFormat.format("User ''{0}'' tries to get Admin page", user.getLogin()));
        if ( User.Role.ADMIN.name().equals(user.getRole().name())) {
            LOG.debug(MessageFormat.format("User ''{0}'' success get Admin page", user.getLogin()));
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            throw new AccessDeniedException(path);
        }
    }

    @Override
    public void destroy() {

    }
}
