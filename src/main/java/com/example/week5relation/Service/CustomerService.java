package com.example.week5relation.Service;

import com.example.week5relation.Api.ApiException;
import com.example.week5relation.Model.Customer;
import com.example.week5relation.Repository.DetailsRepository;
import com.example.week5relation.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void updateCustomer(Integer id,Customer customer){
        Customer customer1 = customerRepository.findCustomerById(id);
        if (customer1==null){
            throw new ApiException("id not found");
        }
        customer1.setName(customer.getName());
        customerRepository.save(customer1);
    }
    public void  deleteCustomer(Integer id){
        Customer customer= customerRepository.findCustomerById(id);
        if (customer == null){
            throw new ApiException("id not found");
        }

        detailsRepository.deleteById(id);
        customerRepository.delete(customer);
    }
}
