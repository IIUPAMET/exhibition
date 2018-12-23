package controller.filter;

import model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class AdminAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();

        User user = (User) request.getSession().getAttribute("user");
        if ( User.Role.ADMIN.name().equals(user.getRole().name())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            throw new AccessDeniedException(path);
        }
    }

    @Override
    public void destroy() {

    }
}
