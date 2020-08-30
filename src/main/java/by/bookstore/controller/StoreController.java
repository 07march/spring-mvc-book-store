package by.bookstore.controller;

import by.bookstore.entity.Address;
import by.bookstore.entity.City;
import by.bookstore.entity.Store;
import by.bookstore.service.AddressService;
import by.bookstore.service.CityService;
import by.bookstore.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/store")
public class StoreController {

    private final StoreService storeService;
    private final AddressService addressService;
    private final CityService cityService;

    public StoreController(StoreService storeService, AddressService addressService, CityService cityService) {
        this.storeService = storeService;
        this.addressService = addressService;
        this.cityService = cityService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/store/add");
        Address[] all = addressService.findAll();
        City[] all1 = cityService.findAll();
        modelAndView.addObject("addresses", all);
        modelAndView.addObject("city", all1);
        modelAndView.addObject("store", new Store());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView add(@Valid Store store, int addressId, int cityId, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()){
            Address[] all = addressService.findAll();
            City[] all1 = cityService.findAll();
            modelAndView.addObject("addresses", all);
            modelAndView.addObject("city", all1);
            modelAndView.setViewName("/store/add");
            return modelAndView;
        }
        Address address = new Address();
        address.setId(addressId);

        City city = new City();
        city.setId(cityId);

        store.setAddress(address);
        store.setCity(city);
        storeService.add(store);
        modelAndView.setViewName("redirect:/?message=store added successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(ModelAndView modelAndView) {
        modelAndView.setViewName("/store/delete");
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView deletePost(int id, ModelAndView modelAndView) {
        storeService.delete(id);
        modelAndView.setViewName("redirect:/?message=store is deleted!");
        return modelAndView;
    }

    @GetMapping(path = "/update")
    public ModelAndView update(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/store/update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView updatePost(String name, int id, ModelAndView modelAndView) {
        storeService.update(name, id);
        modelAndView.setViewName("redirect:/?message=store is updated!");
        return modelAndView;
    }

    @GetMapping(path = "/findByName")
    public ModelAndView findByName(String name, ModelAndView modelAndView) {
        modelAndView.setViewName("/store/findByName");
        Store byName = storeService.findByName(name);
        if (byName != null) {
            modelAndView.addObject("store", byName);
            modelAndView.addObject("message", "this store: " + byName.getName());
        } else {
            modelAndView.setViewName("redirect:/?message=this store not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("/store/findAll");
        Store[] all = storeService.findAll();
        if (all.length == 0) {
            modelAndView.addObject("message", "stores not found!");
        } else {
            modelAndView.addObject("all", all);
            modelAndView.addObject("message", "all stores:");
        }
        return modelAndView;
    }
}
