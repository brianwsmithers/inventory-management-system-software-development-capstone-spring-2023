package com.inventorymanagementsystem.inventory.management.system.controller;


import com.inventorymanagementsystem.inventory.management.system.controllers.SupplierController;
import com.inventorymanagementsystem.inventory.management.system.data.*;
import com.inventorymanagementsystem.inventory.management.system.domain.*;

import com.inventorymanagementsystem.inventory.management.system.services.CustomerService;
import com.inventorymanagementsystem.inventory.management.system.services.OrderService;
import com.inventorymanagementsystem.inventory.management.system.services.StaffService;
import com.inventorymanagementsystem.inventory.management.system.services.SupplierService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import java.util.function.Function;

/**
 * @author Chase Harrod
 * Date: 5/2/2023
 * Class: IndexController
 * Decription: Handles all front end inputs with HTML UI and processes requests to Add/Delete/Update
 * entries in OracleDB
 */
@Controller
public class IndexController {

    HashMap<Integer, Product> products = new HashMap<>();


    CustomerDAO cDAO = new CustomerDAO();

    List<Customer> customers = cDAO.getAll();

    StaffDAO sDAO = new StaffDAO();

    List<Staff> staffList = sDAO.getAll();

    SupplierService supplierService = new SupplierService(new SupplierDAO(new SupplierRepository() {
        @Override
        public void flush() {

        }

        @Override
        public <S extends Supplier> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Supplier> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Supplier> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Supplier getOne(Long aLong) {
            return null;
        }

        @Override
        public Supplier getById(Long aLong) {
            return null;
        }

        @Override
        public Supplier getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Supplier> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Supplier> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends Supplier> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<Supplier> findAll() {
            return null;
        }

        @Override
        public List<Supplier> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Supplier> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Supplier> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Supplier entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Supplier> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Supplier> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<Supplier> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Supplier> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Supplier> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Supplier> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Supplier> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Supplier, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    }));

    List<Supplier> suppliers = supplierService.getAll();

    OrderDAO oDAO = new OrderDAO();

    List<Order> orders = oDAO.getAll();

    int prodId = 1;


    public IndexController(){
        products.put(prodId, new Product("om14", "yes", "1", "1", "1"));
        prodId++;

        products.put(prodId, new Product("eb41", "wireless earbuds", "100", "100", "100"));
        prodId++;

        products.put(prodId, new Product("ud20", "usb drive", "1000", "400", "1"));



    }


    /**
     * Get request that loads the products page and dynamically updates the rows of the table element on the html page
     */
    @RequestMapping("/products")
    public String loadProductsPage(Model m){
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
    public String loadCustomersPage(Model m){
        customers = cDAO.getAll();
        List<Customer> rows = new ArrayList<>();

        for (Customer c: customers){
            rows.add(c);

        }
        m.addAttribute("customerRows", rows);

        return "customers";
    }

    /**
     * * Get request that loads the staff page and dynamically updates the rows of the table element on the html page
     * @param m
     * @return staff.html page with customers table
     */
    @RequestMapping("/staff")
    public String loadStaffPage(Model m){
        staffList = sDAO.getAll();
        List<Staff> rows = new ArrayList<>();

        for (Staff s: staffList){
            rows.add(s);

        }
        m.addAttribute("staffRows", rows);

        return "staff";
    }

    /**
     * * Get request that loads the suppliers page and dynamically updates the rows of the table element on the html page
     * @param m
     * @return suppliers.html page with customers table
     */
    @RequestMapping("/suppliers")
    public String loadSupplierPage(Model m){
        suppliers = supplierService.getAll();
        List<Supplier> rows = new ArrayList<>();

        for (Supplier s: suppliers){
            rows.add(s);

        }
        m.addAttribute("supplierRows", rows);

        return "suppliers";
    }

    /**
     * * Get request that loads the orders page and dynamically updates the rows of the table element on the html page
     * @param m
     * @return orders.html page with customers table
     */
    @RequestMapping("/orders")
    public String loadOrderPage(Model m){
        orders = oDAO.getAll();
        List<Order> rows = new ArrayList<>();

        for (Order o: orders){
            rows.add(o);

        }
        m.addAttribute("orderRows", rows);

        return "orders";
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


    /**
     * Processes a post request and binds the passed Customer object to the model
     * adds the Customer object as a new entry to the customers table
     * @param cust
     * @return
     */
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer cust){

        cDAO.save(cust);

        return "index";
    }



    /**
     * removes the customer with the specified customer id attribute from the customers table
     * @param id
     * @return index.html page
     */
    @GetMapping ("/removeCustomer")
    public String removeCustomer(@ModelAttribute("customerId") long id){

        for(Customer c: customers){
            if(c.getCustomerId() == id){
                cDAO.delete(c);
            }
        }

        return "index";
    }


    /**
     * replaces an existing customer in the customers table
     * @param newCust
     * @return index.html page
     */
    @GetMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer newCust, Model m){

        cDAO.update(newCust);
        return "index";
    }








    /**
     * Processes a post request and binds the passed Staff object to the model
     * adds the Staff object as a new entry to the staff table
     * @param staffMem
     * @return index.html
     */
    @PostMapping("/addStaff")
    public String addStaff(@ModelAttribute Staff staffMem){

       sDAO.save(staffMem);

        return "index";
    }



    /**
     * removes the staff member with the specified staff id attribute from the staff table
     * @param id
     * @return index.html page
     */
    @GetMapping ("/removeStaff")
    public String removeStaff(@ModelAttribute("staffId") long id){

        for(Staff s: staffList){
            if(s.getStaffId() == id){
                sDAO.delete(s);
            }
        }

        return "index";
    }


    /**
     * replaces an existing staff member in the staff table
     * @param newStaff
     * @return index.html page
     */
    @GetMapping("/updateStaff")
    public String updateStaff(@ModelAttribute Staff newStaff, Model m){
        sDAO.update(newStaff);
        return "index";
    }


    /**
     * Processes a post request and binds the passed Supplier object to the model
     * adds the Supplier object as a new entry to the suppliers table
     * @param supplier
     * @return index.html
     */
    @PostMapping("/addSupplier")
    public String addSupplier(@ModelAttribute Supplier supplier){

        supplierService.saveSupplier(supplier);

        return "index";
    }


    /**
     * removes the supplier with the specified staff id attribute from the suppliers table
     * @param id
     * @return index.html page
     */
    @GetMapping("/removeSupplier")
    public String deleteSupplier(@ModelAttribute("supplierID") long id){

        supplierService.deleteById(String.valueOf(id));

        return "index";
    }


    /**
     * replaces an existing Supplier entry in the suppliers table
     * @param newSupplier
     * @return index.html page
     */
    @GetMapping("/updateSupplier")
    public String updateSupplier(@ModelAttribute Supplier newSupplier, Model m){
        supplierService.updateSupplier(newSupplier);
        return "index";
    }

    /**
     * Processes a post request and binds the passed Order object to the model
     * adds the Order object as a new entry to the orders table
     * @param newOrder
     * @return index.html
     */
    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute Order newOrder){
        oDAO.save(newOrder);
        return "index";
    }

    /**
     * removes the staff member with the specified staff id attribute from the order table
     * @param id
     * @return index.html page
     */
    @GetMapping("/removeOrder")
    public String deleteOrder(@ModelAttribute("order_ID") int id){

        for(Order o: orders){
            if(o.getOrder_ID() == id){
                oDAO.delete(o);
            }
        }

        return "index";
    }


    /**
     * replaces an existing Order entry in the orders table
     * @param newOrder
     * @return index.html page
     */
    @GetMapping("/updateOrder")
    public String updateOrder(@ModelAttribute Order newOrder, Model m){
        oDAO.update(newOrder);
        return "index";
    }


    /**
     * gets a Staff entry from the staff table with the passed id
     * adds attributes from the specified Staff entry to the model which is the displayed on the returned html page
     * @param staffId
     * @param m
     * @return staffResult.html
     */
    @GetMapping("/staffResult")
    public String getStaffFromLink(@RequestParam(value = "staffId") int staffId, Model m){

        for(Staff s: staffList){
            if(s.getStaffId() == staffId){
                m.addAttribute("staffId", staffId);
                m.addAttribute("fName", s.getFirstName());
                m.addAttribute("lName", s.getLastName());
                m.addAttribute("address", s.getAddress());
                m.addAttribute("phone", s.getPhone());
                m.addAttribute("email", s.getEmail());
                m.addAttribute("username", s.getUsername());
            }
        }
        return "staffResult";
    }


    /**
     * gets a Customer entry from the customers table with the passed id
     * adds attributes from the specified Customer entry to the model which is the displayed on the returned html page
     * @param custId
     * @param m
     * @return customerResult.html
     */
    @GetMapping("/customerResult")
    public String getCustomerFromLink(@RequestParam(value = "customerId") int custId, Model m){

        for(Customer c: customers){
            if(c.getCustomerId() == custId){
                m.addAttribute("customerId", custId);
                m.addAttribute("fName", c.getFirstName());
                m.addAttribute("lName", c.getLastName());
                m.addAttribute("address", c.getAddress());
                m.addAttribute("phone", c.getPhone());
                m.addAttribute("email", c.getEmail());
                m.addAttribute("staffId", c.getStaffID());
            }
        }

        return "customerResult";
    }

    /**
     * gets a Supplier entry from the suppliers table with the passed id
     * adds attributes from the specified Supplier entry to the model which is the displayed on the returned html page
     * @param supplierId
     * @param m
     * @return staffResult.html
     */
    @GetMapping("/supplierResult")
    public String getSupplierFromLink(@RequestParam(value = "supplierID") int supplierId, Model m){

        for(Supplier s: suppliers){
            if(s.getSupplierID() == supplierId){
                m.addAttribute("supplierId", supplierId);
                m.addAttribute("supplierName", s.getSupplierName());
                m.addAttribute("address", s.getAddress());
                m.addAttribute("phone", s.getPhone());
                m.addAttribute("fax", s.getFax());
                m.addAttribute("email", s.getEmail());
                m.addAttribute("details", s.getSupplierDetails());
            }
        }
        return "supplierResult";
    }

    /**
     * gets a Order entry from the orders table with the passed id
     * adds attributes from the specified Order entry to the model which is the displayed on the returned html page
     * @param orderId
     * @param m
     * @return staffResult.html
     */
    @GetMapping("/orderResult")
    public String getOrderFromLink(@RequestParam(value = "order_ID") int orderId, Model m){

        for(Order o: orders){
            if(o.getOrder_ID() == orderId){
                m.addAttribute("supplierId", orderId);
                m.addAttribute("date_Of_Order", o.getDate_Of_Order());
                m.addAttribute("orderDetails", o.getOrder_Details());
                m.addAttribute("customerID", o.getCustomerID());
            }
        }
        return "orderResult";
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