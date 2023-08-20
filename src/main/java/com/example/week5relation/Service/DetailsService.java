package com.example.week5relation.Service;

import com.example.week5relation.Api.ApiException;
import com.example.week5relation.DTO.DetailsDTO;
import com.example.week5relation.Model.Customer;
import com.example.week5relation.Model.Details;
import com.example.week5relation.Repository.DetailsRepository;
import com.example.week5relation.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsService {

    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;
    public List<Details> getAllDetails(){
        return detailsRepository.findAll();
    }
    public void addDetails(DetailsDTO detailsDTO){

        Customer customer = customerRepository.findCustomerById(detailsDTO.getCustomer_id());
        if(customer==null){
            throw new ApiException("customer not found");
        }

        Details details= new Details(null, detailsDTO.getGander(), detailsDTO.getAge(),detailsDTO.getEmail(),customer);
        detailsRepository.save(details);

    }

    public void delete(Integer customer_id){
         Customer customer = customerRepository.findCustomerById(customer_id);
         Details details = customer.getDetails();
         detailsRepository.delete(details);

    }
    public void update(Integer customer_id,DetailsDTO detailsDTO){
        Customer customer = customerRepository.findCustomerById(customer_id);

        if(customer == null){
            throw new ApiException("customer not found");
        }
        Details details = customer.getDetails();

        details.setGander(detailsDTO.getGander());
        details.setAge(detailsDTO.getAge());
        details.setEmail(detailsDTO.getEmail());
        detailsRepository.save(details);

    }


}
