package by.bookstore.controller;

import by.bookstore.entity.*;
import by.bookstore.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private final BookService bookService;
    private final CityService cityService;
    private final StoreService storeService;
    private final AuthorService authorService;
    private final AddressService addressService;

    public AdminController(AddressService addressService, AuthorService authorService, BookService bookService, CityService cityService, StoreService storeService, UserService userService) {
        this.addressService = addressService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.cityService = cityService;
        this.storeService = storeService;
    }

    @GetMapping
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin");
        return modelAndView;
    }

    @GetMapping(path = "/updateAddress")
    public ModelAndView updateAddress(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/updateAddress");
        Address[] allAddresses = addressService.findAll();
        if (allAddresses.length == 0) {
            modelAndView.addObject("message", "no addresses in memory!");
        } else {
            modelAndView.addObject("authors", allAddresses);
        }
        return modelAndView;
    }

    @GetMapping(path = "/updateAuthor")
    public ModelAndView updateAuthor(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/updateAuthor");
        Author[] allAuthors = authorService.findAll();
        if (allAuthors.length == 0) {
            modelAndView.addObject("message", "no authors in memory!");
        } else {
            modelAndView.addObject("authors", allAuthors);
        }
        return modelAndView;
    }

    @GetMapping(path = "/updateBookPrice")
    public ModelAndView updateBookPrice(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/updateBookPrice");
        Book[] allBooks = bookService.findAll();
        if (allBooks.length == 0) {
            modelAndView.addObject("message", "no books in memory!");
        } else {
            modelAndView.addObject("books", allBooks);
        }
        return modelAndView;
    }

    @GetMapping(path = "/updateBookTitle")
    public ModelAndView updateBookTitle(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/updateBookTitle");
        Book[] allBooks = bookService.findAll();
        if (allBooks.length == 0) {
            modelAndView.addObject("message", "no books in memory!");
        } else {
            modelAndView.addObject("books", allBooks);
        }
        return modelAndView;
    }

    @GetMapping(path = "/updateCity")
    public ModelAndView updateCity(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/updateCity");
        City[] allCities = cityService.findAll();
        if (allCities.length == 0) {
            modelAndView.addObject("message", "no cities in memory!");
        } else {
            modelAndView.addObject("cities", allCities);
        }
        return modelAndView;
    }

    @GetMapping(path = "/updateStore")
    public ModelAndView updateStore(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/updateStore");
        Store[] allStores = storeService.findAll();
        if (allStores.length == 0) {
            modelAndView.addObject("message", "no stores in memory!");
        } else {
            modelAndView.addObject("stores", allStores);
        }
        return modelAndView;
    }

    @GetMapping(path = "/findBookById")
    public ModelAndView findAllBooks(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/findBookById");
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
        modelAndView.setViewName("/admin/findAllBooks");
        Book[] allBooks = bookService.findAll();
        if (allBooks.length == 0) {
            modelAndView.addObject("message", "no books in memory!");
        } else {
            modelAndView.addObject("books", allBooks);
            modelAndView.addObject("message", "All books in memory: ");
        }
        return modelAndView;
    }
}
