package com.example.exbank.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    public ArrayList <Customers> customerss=new ArrayList<>();
    //read
    @GetMapping("/get")
    public ArrayList<Customers> getCustomerss(){
        return customerss;
    }
    //Create-post
    @PostMapping("/add")
    public String addCustomers(@RequestBody Customers customers) {;
        customerss.add(customers);
       return "customer added";
    }
    @PutMapping("\"/update/{index}\"")
    public String updateTask(@PathVariable int index, @RequestBody Customers customers) {
        customerss.set(index, customers);
        return "updated customer";
    }
    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        customerss.remove(index);
        return "customer deleted";
    }
    @PostMapping("/customers/{index}/deposit")
    public void depositMoney(@PathVariable int index, @RequestBody double amount){
        Customers savedCustomer = customerss.get(index);
        double newBalance = savedCustomer.getBalance() + amount;
        savedCustomer.setBalance(newBalance);
    }
    @PostMapping("/customers/{id}/withdraw")
    public void withdrawMoney(@PathVariable int id, @RequestBody double amount) throws Exception {
        Customers savedCustomer = customerss.get(id);
        double newBalance = savedCustomer.getBalance() - amount;
        if (newBalance < 0) {
            System.out.println("Insufficient balance.");
        }         savedCustomer.setBalance(newBalance);     } }

//    public String depositMoney(int customerId, double amount) {
//        for (Customers customer : customerss) {
//            if (customerss.getUsername == customerId) {
//                customer.setBalance(customer.getBalance() + amount);
//                break;             }         }     }
//    // withdraw the given amount of money from the customer with the given ID     // if there is not enough balance, the method should throw an error (or return a message)
//    public String withdrawMoney(int customerId, double amount) throws Exception {
//        for (Customers customer : customerss) {
//            if (customerss.getId == customerId) {
//                if (customer.getBalance() < amount) {
//                    System.out.println("Not enough balance!");                 }
//                customer.setBalance(customer.getBalance() - amount);
//                break;             }         }
//        return null;



