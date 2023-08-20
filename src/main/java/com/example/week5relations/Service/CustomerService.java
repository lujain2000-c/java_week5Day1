package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
       return customerRepository.findAll();
    }


    public void addCustomer(Customer customer){

                customerRepository.save(customer);
    }

    public void updateCustomer(Integer id,Customer customer){
        Customer customer1 = customerRepository.findCustomerById(id);

        if(customer1 == null){
            throw new ApiException("not found");
        }

        customer1.setName(customer.getName());
        customerRepository.save(customer1);

    }

    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findCustomerById(id);

        if(customer == null){
            throw new ApiException("not found");
        }
        customerRepository.delete(customer);
    }
}
