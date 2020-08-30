package by.bookstore.controller;

import by.bookstore.entity.Basket;
import by.bookstore.entity.Book;
import by.bookstore.entity.User;
import by.bookstore.service.BookService;
import by.bookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    public final UserService userService;
    private final BookService bookService;

    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/add");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @GetMapping(path = "/logout")
    public ModelAndView logout(HttpSession httpSession, ModelAndView modelAndView) {
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView add(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/user/add");
            return modelAndView;
        }
        userService.add(user);
        modelAndView.setViewName("redirect:/?message=user added successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView auth(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("/user/auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView auth(String email, String password, HttpSession httpSession, ModelAndView modelAndView) {
        User byEmail = userService.findByEmail(email);
        modelAndView.addObject("user", new User());
        if (byEmail == null) {
            modelAndView.setViewName("/user/auth");
            modelAndView.addObject("message", "User not found");
        } else {
            if (byEmail.getPassword().equals(password)) {
                httpSession.setAttribute("user", byEmail);
                httpSession.setAttribute("basket", new Basket());
                modelAndView.setViewName("redirect:/");
            } else {
                modelAndView.setViewName("/user/auth");
                modelAndView.addObject("message", "Wrong password");
            }
        }
        return modelAndView;
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(String email, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/delete");
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView deletePost(String email, HttpSession httpSession, ModelAndView modelAndView) {
        userService.delete(email);
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/?message=user deleted!");
        return modelAndView;
    }

    @GetMapping(path = "/findByEmail")
    public ModelAndView findByEmail(String email, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/findByEmail");
        User byEmail = userService.findByEmail(email);
        if (byEmail != null) {
            modelAndView.addObject("user", byEmail);
            modelAndView.addObject("message", "this user: " + byEmail.getFirstName());
        } else {
            modelAndView.setViewName("redirect:/?message=this user not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findById")
    public ModelAndView findById(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/findById");
        User byId = userService.findById(id);
        if (byId != null) {
            modelAndView.addObject("user", byId);
            modelAndView.addObject("message", "this user: " + byId.getFirstName());
        } else {
            modelAndView.setViewName("redirect:/?message=this user not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/updateFirstName")
    public ModelAndView updateFirstName(String email, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/updateFirstName");
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    @PostMapping(path = "/updateFirstName")
    public ModelAndView updateFirstName(String email, String newFirstName, ModelAndView modelAndView) {
        userService.updateFirstName(newFirstName, email);
        modelAndView.setViewName("redirect:/?message=firstname updated!");
        return modelAndView;
    }

    @GetMapping(path = "/updateLastName")
    public ModelAndView updateLastName(String email, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/updateLastName");
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    @PostMapping(path = "/updateLastName")
    public ModelAndView updateLastName(String email, String newLastName, ModelAndView modelAndView) {
        userService.updateLastName(newLastName, email);
        modelAndView.setViewName("redirect:/?message=lastname updated!");
        return modelAndView;
    }

    @GetMapping(path = "/updatePassword")
    public ModelAndView updatePassword(String email, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/updatePassword");
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    @PostMapping(path = "/updatePassword")
    public ModelAndView updatePassword(String email, String newPassword, ModelAndView modelAndView) {
        userService.updatePassword(newPassword, email);
        modelAndView.setViewName("redirect:/?message=password updated!");
        return modelAndView;
    }

    @GetMapping(path = "/findBookById")
    public ModelAndView findAllBooks(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/findBookById");
        Book byId = bookService.findById(id);
        if (byId != null) {
            modelAndView.addObject("book", byId);
        } else {
            modelAndView.setViewName("redirect:/?message=this book not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findAllBooks")
    public ModelAndView findAllBooks(ModelAndView modelAndView){
        modelAndView.setViewName("/user/findAllBooksByUser");
        Book[] all = bookService.findAll();
        if (all.length == 0) {
            modelAndView.addObject("message", "book not found!");
        } else {
            modelAndView.addObject("all", all);
            modelAndView.addObject("message", "all books:");
        }
        return modelAndView;
    }
}
