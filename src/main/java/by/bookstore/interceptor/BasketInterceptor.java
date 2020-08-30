package by.bookstore.interceptor;

import by.bookstore.entity.Role;
import by.bookstore.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasketInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/");
            return false;
        }
        if (!user.getRole().equals(Role.USER) & !user.getRole().equals(Role.ADMIN)) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}

