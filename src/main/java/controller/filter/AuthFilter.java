package controller.filter;

import model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        if (path.contains("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                User.Role role = user.getRole();
                if (path.contains("admin/")) {
                    if (role.equals(User.Role.ADMIN)) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        throw new AccessDeniedException(path);
                    }
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                if (path.contains("home")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
