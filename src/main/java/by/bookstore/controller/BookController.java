package by.bookstore.controller;

import by.bookstore.entity.Author;
import by.bookstore.entity.Book;
import by.bookstore.service.AuthorService;
import by.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/book/add");
        Author[] all = authorService.findAll();
        modelAndView.addObject("author", all);
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView add(@Valid Book book, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()){
            Author[] all = authorService.findAll();
            modelAndView.addObject("author", all);
            modelAndView.setViewName("/book/add");
            return modelAndView;
        }
        String name = book.getAuthor().getName();
        Author byName = authorService.findByName(name);
        book.setAuthor(byName);
        bookService.add(book);
        modelAndView.setViewName("redirect:/?message=book added successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/deleteById")
    public ModelAndView deleteById(ModelAndView modelAndView) {
        modelAndView.setViewName("/book/deleteById");
        return modelAndView;
    }

    @PostMapping(path = "/deleteById")
    public ModelAndView deleteById(int id, ModelAndView modelAndView) {
        bookService.delete(id);
        modelAndView.setViewName("redirect:/?message=book deleted successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/updateTitle")
    public ModelAndView updateTitle(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/book/updateTitle");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(path = "/updateTitle")
    public ModelAndView updateTitle(String title, int id, ModelAndView modelAndView) {
        bookService.updateTitle(title, id);
        modelAndView.setViewName("redirect:/?message=book title updated successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/updatePrice")
    public ModelAndView updatePrice(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/book/updatePrice");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(path = "/updatePrice")
    public ModelAndView updatePrice(BigDecimal price, int id, ModelAndView modelAndView) {
        bookService.updatePrice(price, id);
        modelAndView.setViewName("redirect:/?message=book price updated successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/findById")
    public ModelAndView findById(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/book/findById");
        Book byId = bookService.findById(id);
        if (byId != null) {
            modelAndView.addObject("book", byId);
        } else {
            modelAndView.setViewName("redirect:/?message=this book not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findAllByPrice")
    public ModelAndView findAllByPrice(BigDecimal price, ModelAndView modelAndView) {
        modelAndView.setViewName("/book/findAllByPrice");
        Book[] allByPrice = bookService.findAllByPrice(price);
        if (allByPrice.length == 0) {
            modelAndView.addObject("message", "empty! enter price:");
        } else {
            modelAndView.addObject("allByPrice", allByPrice);
        }
        return modelAndView;
    }

    @GetMapping(path = "/findByAuthorName")
    public ModelAndView findByAuthorName(String name, ModelAndView modelAndView) {
        modelAndView.setViewName("/book/findByAuthorName");
        Book[] byAuthorName = bookService.findByAuthorName(name);
        if (byAuthorName == null) {
            modelAndView.addObject("message", "empty! enter name:");
        } else {
            modelAndView.addObject("byAuthorName", byAuthorName);
        }
        return modelAndView;
    }

    @GetMapping(path = "/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("/book/findAll");
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
