package com.example.week5relations.Controller;


import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/vi/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getCustomers(){
        return ResponseEntity.status(200).body(customerService.getAllCustomer());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }

    @PutMapping("/Update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletedCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }
}
