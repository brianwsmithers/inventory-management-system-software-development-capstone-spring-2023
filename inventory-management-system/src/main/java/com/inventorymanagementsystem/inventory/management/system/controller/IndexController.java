package com.inventorymanagementsystem.inventory.management.system.controller;

import com.inventorymanagementsystem.inventory.management.system.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class IndexController {

    HashMap<Integer, Product> products = new HashMap<>();
    int id = 1;

    public IndexController(){
        products.put(id, new Product("om14", "yes", "1", "1", "1"));
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product prod){

        id++;
        products.put(id, prod);

        System.out.println(products.toString());

        return "index";
    }


    @GetMapping("/removeProduct")
    public String removeProduct(@ModelAttribute String id){

        System.out.println(id);
        for(int i = 1; i <= products.keySet().size(); i++){
            if(products.get(i).getId() == (id)){
                products.remove(i, products.get(id));
            }
        }

        System.out.println(products.toString());

        return "index";
    }


    //update function - replaces entire object in arraylist currently
    @GetMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product newProd){
        for (int i = 1; i <= products.keySet().size(); i++){
                if (products.get(i).getId().equalsIgnoreCase(newProd.getId())){
                    System.out.println("Old Product: " + products.get(i).toString());

                    products.replace(i, newProd);

                    System.out.println("New Product: " + products.get(i).toString());
                }
            }


        return "index";
    }

    @GetMapping("/result")
    public String getProduct(Model model, @ModelAttribute("id") String id){
        Product prod;
        for(int i = 1; i <= products.keySet().size(); i++){
            if(id.equalsIgnoreCase(products.get(i).getId())){
                prod = products.get(i);
                model.addAttribute("id", prod.getId());
                model.addAttribute("desc", prod.getDesc());
                model.addAttribute("currStock", prod.getCurrStock());
                model.addAttribute("soQty", prod.getSoQty());
                model.addAttribute("poQty", prod.getPoQty());
                break;
            }
        }


        return "result";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
