package com.inventorymanagementsystem.inventory.management.system.controller;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import com.inventorymanagementsystem.inventory.management.system.domain.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
public class IndexController {

    HashMap<Integer, Product> products = new HashMap<>();
    HashMap<Integer, Customer> customers = new HashMap<>();

    CustomerDAO customerDAO = new CustomerDAO();

    int prodId = 1;
    int custId = 1;

    public IndexController(){
        products.put(prodId, new Product("om14", "yes", "1", "1", "1"));
        prodId++;

        products.put(prodId, new Product("eb41", "wireless earbuds", "100", "100", "100"));
        prodId++;

        products.put(prodId, new Product("ud20", "usb drive", "1000", "400", "1"));

        customers.put(custId, new Customer(custId, "Chase", "Harrod", "123 Sesame Street", "1234567890",
                "test1@gmail.com", 1));
        custId++;
        customers.put(custId, new Customer(custId, "Brian", "Smithers", "1600 Pennsylvania Ave", "2345678901",
                "test2@gmail.com", 2));
        custId++;
        customers.put(custId, new Customer(custId, "Eline", "Gidey", "100 Hollywood Blvd", "3456789012",
                "test3@gmail.com", 3));
    }

    /**
     * Get request that loads the products page and dynamically updates the rows of the table element on the html page
     */
    @RequestMapping("/products")
    public String products(Model m){
        List<Product> rows = new ArrayList<>();

        for (Integer i: products.keySet()){
            rows.add(products.get(i));

        }
        m.addAttribute("productRows", rows);

        return "products";
    }

    /**
     * * Get request that loads the customers page and dynamically updates the rows of the table element on the html page
     * @param m
     * @return customers.html page with customers table
     */
    @RequestMapping("/customers")
    public String customers(Model m){
        List<Customer> rows = new ArrayList<>();

        for (Integer i: customers.keySet()){
            rows.add(customers.get(i));

        }
        m.addAttribute("customerRows", rows);

        return "customers";
    }

    /**
     * loads the index.html page when application is run
     * @return index.html page
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }


    /**
     * Processes a post request and binds the passed Product object to the model
     * adds the Product object as a new entry to the products HashMap/Database
     * @param prod - Product object
     * @return index.html page
     */
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product prod){

        prodId++;
        products.put(prodId, prod);

        System.out.println(products.toString());

        return "index";
    }


    /**
     * removes the product with the specified product id attribute from the HashMap/Database
     * @param id
     * @return index.html page
     */
    @GetMapping ("/removeProduct")
    public String removeProduct(@ModelAttribute("id") String id){

        System.out.println(id);
        for(int i = 1; i <= products.keySet().size(); i++){
            if(products.get(i).getId().equalsIgnoreCase(id)){
                products.remove(i);
            }
        }

        System.out.println(products.toString());

        return "index";
    }


    /**
     * replaces an existing product in the HashMap/Database
     * @param newProd
     * @return index.html page
     */
    @GetMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product newProd){
        for (int i = prodId; i <= products.keySet().size(); i++){
                if (products.get(i).getId().equalsIgnoreCase(newProd.getId())){
                    System.out.println("Old Product: " + products.get(i).toString());

                    products.replace(i, newProd);

                    System.out.println("New Product: " + products.get(i).toString());
                }
            }
        return "index";
    }



    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer cust){

        custId++;
        cust.setCustomerId(custId);
        customers.put(custId, cust);

//        customerDAO.save(cust);


        System.out.println(customers.toString());

        return "index";
    }


    /**
     * removes the product with the specified product id attribute from the HashMap/Database
     * @param id
     * @return index.html page
     */
    @GetMapping ("/removeCustomer")
    public String removeCustomer(@ModelAttribute("customerId") long id){

        System.out.println(id);
        for(int i = 1; i <= customers.keySet().size(); i++){
            if(customers.get(i).getCustomerId() == id){
                customers.remove(i);
            }
        }

        System.out.println(customers.toString());

        return "index";
    }


    /**
     * replaces an existing customer in the HashMap/Database
     * @param newCust
     * @return index.html page
     */
    @GetMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer newCust, Model m){
        for (Integer i: customers.keySet()){
            if (customers.get(i).getCustomerId() == newCust.getCustomerId()){
                System.out.println("Old Customer: " + customers.get(i).toString());

                customers.replace(i, newCust);

                System.out.println("New Customer: " + customers.get(i).toString());
            }
        }
        return "index";
    }


    /**
     * loads the home.html page when the nav link is clicked
     * @return home.html page
     */
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    /**
     * loads the login.html page when the nav link is clicked
     * @return login.html page
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * loads the index.html page when the nav link is clicked
     * @return index.html page
     */
    @RequestMapping("/index")
    public String indexFromOthers(){
        return "index";
    }

}
