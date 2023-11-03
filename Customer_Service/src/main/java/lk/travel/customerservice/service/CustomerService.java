package lk.travel.customerservice.service;

import lk.travel.customerservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO searchCustomer(String customerID);
    CustomerDTO searchByEmailCustomer(String customerEmailAddress);
    void deleteCustomer(String customerID);
    List<CustomerDTO> getAllCustomer();
}
