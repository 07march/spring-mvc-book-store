package by.bookstore.controller;

import by.bookstore.entity.Basket;
import by.bookstore.entity.Book;
import by.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/basket")
public class BasketController {

    private final BookService bookService;

    public BasketController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView page(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("/basket/findBooks");
        Basket basket = (Basket) httpSession.getAttribute("basket");
        modelAndView.addObject("total", basket.getTotal());
        modelAndView.addObject("books", basket.getBooks());
        if (basket.isEmpty()){
            modelAndView.setViewName("redirect:/?message=basket is empty!");
        }
        return modelAndView;
    }

    @PostMapping(path = "/add")
    public ModelAndView add(int id, ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("redirect:/basket?message=Book added");
        Book byId = bookService.findById(id);
        Basket basket = (Basket) httpSession.getAttribute("basket");
        basket.add(byId);
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView delete(int id, ModelAndView modelAndView, HttpSession httpSession) {
        Basket basket = (Basket) httpSession.getAttribute("basket");
        basket.delete(id);
        modelAndView.setViewName("redirect:/basket?message=Book deleted");
        return modelAndView;
    }
}
