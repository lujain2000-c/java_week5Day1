package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.DTO.DetailsDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.Details;
import com.example.week5relations.Repository.CustomerRepository;
import com.example.week5relations.Repository.DetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
@RequiredArgsConstructor

public class DetailsService {
    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;

    public Details getDetails(Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        if(customer == null){
            throw new ApiException("not found");
        }

        return detailsRepository.findDetailsById(id);
    }
    public void addDetails(DetailsDTO detailsDTO){
        Customer customer = customerRepository.findCustomerById(detailsDTO.getCustomer_id());
        if(customer == null){
            throw new ApiException("not found");
        }
        Details details = new Details(null,detailsDTO.getAge(),detailsDTO.getEmail(),customer);

        detailsRepository.save(details);
    }


    public void updateDetails( DetailsDTO detailsDTO){
        Customer customer = customerRepository.findCustomerById(detailsDTO.getCustomer_id());
        if(customer == null) {
            throw new ApiException("not found");
        }

       Details details = detailsRepository.findDetailsById(customer.getId());
        details.setAge(detailsDTO.getAge());
        details.setEmail(detailsDTO.getEmail());
        detailsRepository.save(details);


    }

    public void deleteDetails(Integer customerId ){
        Customer customer = customerRepository.findCustomerById(customerId);
        if(customer == null) {
            throw new ApiException("not found");
        }
        Details details = detailsRepository.findDetailsById(customer.getId());
        detailsRepository.delete(details);

    }
}

