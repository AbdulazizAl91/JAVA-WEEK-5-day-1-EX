package com.example.week5relation.Controller;

import com.example.week5relation.Api.ApiResponse;
import com.example.week5relation.Model.Customer;
import com.example.week5relation.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getAllCustomer(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }
}
