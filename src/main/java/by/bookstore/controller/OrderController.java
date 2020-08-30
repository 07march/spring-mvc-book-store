package by.bookstore.controller;

import by.bookstore.entity.*;
import by.bookstore.service.OrderService;
import by.bookstore.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;
    private final StoreService storeService;

    public OrderController(OrderService orderService, StoreService storeService) {
        this.orderService = orderService;
        this.storeService = storeService;
    }

    @GetMapping
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/order/add");
        return modelAndView;

    }

    @GetMapping(path = "/add/delivery")
    public ModelAndView addDelivery(ModelAndView modelAndView) {
        modelAndView.setViewName("/order/addDelivery");
        return modelAndView;
    }

    @PostMapping(path = "/add/delivery")
    public ModelAndView addDelivery(String address, ModelAndView modelAndView, HttpSession httpSession) {
        Basket basket = (Basket) httpSession.getAttribute("basket");
        User user = (User) httpSession.getAttribute("user");
        Order order = new Order(true,
                new BigDecimal(basket.getTotal()),
                basket.getBooks().toArray(new Book[0]), user, Order.Status.ACTIVE, new Address(address));
        orderService.add(order);
        basket.clear();
        modelAndView.setViewName("redirect:/?message=order is created!");
        return modelAndView;
    }

    @GetMapping(path = "/add/pickup")
    public ModelAndView addPickup(ModelAndView modelAndView) {
        Store[] allStores = storeService.findAll();
        modelAndView.addObject("stores", allStores);
        modelAndView.setViewName("/order/addPickup");
        return modelAndView;
    }

    @PostMapping(path = "/add/pickup")
    public ModelAndView addPickup(String name, ModelAndView modelAndView, HttpSession httpSession) {
        Store[] allStores = storeService.findAll();
        Store str = null;
        for (Store allStore : allStores) {
            if (allStore.getName().equals(name)) {
                str = allStore;
            }
        }
        modelAndView.addObject("stores", allStores);
        Basket basket = (Basket) httpSession.getAttribute("basket");
        User user = (User) httpSession.getAttribute("user");
        Order order = new Order(str, new BigDecimal(basket.getTotal()),
                basket.getBooks().toArray(new Book[0]), user, Order.Status.ACTIVE);
        if (order.getStore().getName() == null) {
            modelAndView.setViewName("/order/addPickup");
            return modelAndView;
        }
        orderService.add(order);
        basket.clear();
        modelAndView.setViewName("redirect:/?message=order is created!");
        return modelAndView;
    }
}
