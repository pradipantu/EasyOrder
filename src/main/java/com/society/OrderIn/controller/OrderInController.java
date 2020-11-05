package com.society.OrderIn.controller;

import com.society.OrderIn.model.Customer;
import com.society.OrderIn.service.CustomerService;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
public class OrderInController {
    private Logger log= LoggerFactory.getLogger(OrderInController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    ProducerTemplate producerTemplate;

    @RequestMapping(value = "/")
    public void startCamel() {
        producerTemplate.sendBody("direct:firstRoute", "Calling via Spring Boot Rest Controller");
    }

    @GetMapping("getForm")
    public String getForm() {
        return "employeeFrom.jsp";
    }

    @PostMapping(path = "/postorder",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Customer> postOrder(@RequestBody Customer customer){
        log.info("Post Order request : {}",customer);
        return new ResponseEntity<>(customerService.addOrders(customer), HttpStatus.CREATED);
    }
    @GetMapping(path = "/getorder",consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<Customer>> getOrder(@RequestBody Customer customer){
        log.info("Get Order Request : {}",customer);
        List<Customer> list=customerService.getAllOrders();
        log.info("Get Order Response :{}",list);
        return new ResponseEntity<>(list,HttpStatus.OK);

    }

    @GetMapping(path = "/getorderby/{id}",produces = "application/json")
    public Optional<Customer> getOrderById(@PathVariable("id") int id){
        log.info("Get Order Details for id : {}",id);
        return customerService.getOrders(id);
       
    }
    @PutMapping(path = "/updateOrder",consumes = "application/json",produces = "application/json")
    public Customer updateOrder(@RequestBody Customer customer)
    {
        log.info("Updating Order : {}",customer);
        return customerService.updateOrder(customer);
    }
    @DeleteMapping(path = "/deleteOrder",consumes = "application/json",produces = "application/json")
    public Customer deleteOrder(@RequestBody Customer customer)
    {
        log.info("Delete Order : {}",customer);
        return customerService.deleteOrder(customer);
    }
}
