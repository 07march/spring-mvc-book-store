package by.bookstore.controller;

import by.bookstore.entity.Author;
import by.bookstore.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {

    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/author/add");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addPost(@Valid Author author, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("/author/add");
            return modelAndView;
        }
        authorService.add(author);
        modelAndView.setViewName("redirect:/?message=author added successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(ModelAndView modelAndView) {
        modelAndView.setViewName("/author/delete");
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView deletePost(int id, ModelAndView modelAndView) {
        authorService.delete(id);
        modelAndView.setViewName("redirect:/?message=author deleted!");
        return modelAndView;
    }

    @GetMapping(path = "/update")
    public ModelAndView update(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/author/update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView updatePost(String name, int id, ModelAndView modelAndView) {
        authorService.updateAuthorById(name, id);
        modelAndView.setViewName("redirect:/?message=author updated!");
        return modelAndView;
    }

    @GetMapping(path = "/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("/author/findAll");
        Author[] all = authorService.findAll();
        if (all.length == 0) {
            modelAndView.addObject("message", "authors not found!");
        } else {
            modelAndView.addObject("all", all);
            modelAndView.addObject("message", "all authors:");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findByName")
    public ModelAndView findByName(String name, ModelAndView modelAndView) {
        modelAndView.setViewName("/author/findByName");
        Author byName = authorService.findByName(name);
        if (byName != null) {
            modelAndView.addObject("author", byName);
            modelAndView.addObject("message", "this author: " + name);
        } else {
            modelAndView.setViewName("redirect:/?message=this author not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findById")
    public ModelAndView findById(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/author/findById");
        Author byId = authorService.findById(id);
        if (byId != null) {
            modelAndView.addObject("author", byId);
            modelAndView.addObject("message", "this author: " + byId.getName());
        } else {
            modelAndView.setViewName("redirect:/?message=this author not registered!");
        }
        return modelAndView;
    }
}
