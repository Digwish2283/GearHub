package com.sheryians.ecommerce.controller;

import com.sheryians.ecommerce.Global.GlobalData;
import com.sheryians.ecommerce.service.CategoryService;
import com.sheryians.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("cartCount" , GlobalData.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount" , GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shop(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProductByCategory(id));
        model.addAttribute("cartCount" , GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getProductById((long) id).get());
        model.addAttribute("cartCount" , GlobalData.cart.size());
        return "viewProduct";
    }

}
