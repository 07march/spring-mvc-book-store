package by.bookstore.controller;

import by.bookstore.entity.City;
import by.bookstore.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/city")
public class CityController {

    public final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/city/add");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addPost(@Valid City city, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("/city/add");
            return modelAndView;
        }
        cityService.add(city);
        modelAndView.setViewName("redirect:/?message=city added successfully!");
        return modelAndView;
    }

    @PostMapping(path = "/deleteById")
    public ModelAndView deletePost(int id, ModelAndView modelAndView) {
        cityService.delete(id);
        modelAndView.setViewName("redirect:/?message=city is deleted!");
        return modelAndView;
    }

    @GetMapping(path = "/deleteByName")
    public ModelAndView deleteByName(ModelAndView modelAndView) {
        modelAndView.setViewName("/city/deleteByName");
        return modelAndView;
    }

    @PostMapping(path = "/deleteByName")
    public ModelAndView deleteByNamePost(String name, ModelAndView modelAndView) {
        City byName = cityService.findByName(name);
        if (byName == null) {
            modelAndView.addObject("message", "city not found!");
        } else {
            cityService.delete(name);
            modelAndView.addObject("message", "city is deleted!");
        }
        modelAndView.setViewName("/city/deleteByName");
        return modelAndView;
    }

    @GetMapping(path = "/update")
    public ModelAndView update(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/city/update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView updatePost(String name, int id, ModelAndView modelAndView) {
        cityService.update(name, id);
        modelAndView.setViewName("redirect:/?message=city is updated!");
        return modelAndView;
    }

    @GetMapping(path = "/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("/city/findAll");
        City[] all = cityService.findAll();
        if (all.length == 0) {
            modelAndView.addObject("message", "cities not found!");
        } else {
            modelAndView.addObject("all", all);
            modelAndView.addObject("message", "all cities:");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findByName")
    public ModelAndView findByName(String name, ModelAndView modelAndView) {
        modelAndView.setViewName("/city/findByName");
        City byName = cityService.findByName(name);
        if (byName != null) {
            modelAndView.addObject("city", byName);
            modelAndView.addObject("message", "this city: " + byName.getName());
        } else {
            modelAndView.setViewName("redirect:/?message=this city not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findById")
    public ModelAndView findById(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/city/findById");
        City byId = cityService.findById(id);
        if (byId != null) {
            modelAndView.addObject("city", byId);
            modelAndView.addObject("message", "this city: " + byId.getName());
        } else {
            modelAndView.setViewName("redirect:/?message=this city not registered!");
        }
        return modelAndView;
    }
}
