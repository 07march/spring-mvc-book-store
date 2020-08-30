package by.bookstore.controller;

import by.bookstore.entity.Address;
import by.bookstore.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/address")
public class AddressController {

    public final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/address/address");
        modelAndView.addObject("address", new Address());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addPost(@Valid Address address, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/address/address");
            return modelAndView;
        }
        addressService.add(address);
        modelAndView.setViewName("redirect:/?message=address added successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(ModelAndView modelAndView) {
        modelAndView.setViewName("/address/delete");
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView deletePost(String address, ModelAndView modelAndView) {
        addressService.delete(address);
        modelAndView.setViewName("redirect:/?message=address deleted!");
        return modelAndView;
    }

    @GetMapping(path = "/update")
    public ModelAndView update(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/address/update");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView updatePost(int id, String address, ModelAndView modelAndView) {
        addressService.updateAddressById(address, id);
        modelAndView.setViewName("redirect:/?message=address updated!");
        return modelAndView;
    }

    @GetMapping(path = "/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("/address/findAllAddresses");
        Address[] all = addressService.findAll();
        if (all.length == 0) {
            modelAndView.addObject("message", "addresses not found!");
        } else {
            modelAndView.addObject("all", all);
            modelAndView.addObject("message", "all addresses:");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findById")
    public ModelAndView findById(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/address/findAddressById");
        Address byId = addressService.findById(id);
        if (byId != null) {
            modelAndView.addObject("address", byId);
            modelAndView.addObject("message", "this address: " + byId.getName());
        } else {
            modelAndView.setViewName("redirect:/?message=this address not registered!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/findByName")
    public ModelAndView findByName(String name, ModelAndView modelAndView) {
        modelAndView.setViewName("/address/findAddressByName");
        Address byName = addressService.findByName(name);
        if (byName != null) {
            modelAndView.addObject("address", byName);
            modelAndView.addObject("message", "this address: " + name);
        } else {
            modelAndView.setViewName("redirect:/?message=this address not registered!");
        }
        return modelAndView;
    }
}
