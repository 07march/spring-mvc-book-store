package by.bookstore.controller;

import by.bookstore.entity.Role;
import by.bookstore.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public ModelAndView index(String message, HttpSession httpSession, ModelAndView modelAndView) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            modelAndView.setViewName("index");
            return modelAndView;
        }

        if (user.getRole().equals(Role.USER)) {
            modelAndView.setViewName("/user/index");
        } else if (user.getRole().equals(Role.ADMIN)) {
            modelAndView.setViewName("/admin/index");
        }

        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
