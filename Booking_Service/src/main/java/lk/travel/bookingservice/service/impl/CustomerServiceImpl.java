package lk.travel.bookingservice.service.impl;

import lk.travel.bookingservice.repo.CustomerRepo;
import lk.travel.bookingservice.service.CustomerService;
import lk.travel.customerservice.dto.CustomerDTO;
import lk.travel.customerservice.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerID())){
            throw new RuntimeException("Customer Already Exists..!!");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if(!customerRepo.existsById(customerDTO.getCustomerID())){
            throw new RuntimeException("Customer Not Exists..!!");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    @Override
    public CustomerDTO searchCustomer(String customerID) {
        if(!customerRepo.existsById(customerID)){
            throw new RuntimeException("Customer Not Exists..!!");
        }
        return mapper.map(customerRepo.findById(customerID),CustomerDTO.class);
    }

    @Override
    public CustomerDTO searchByEmailCustomer(String customerEmailAddress) {
        return mapper.map(customerRepo.findByEmail(customerEmailAddress),CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String customerID) {
        if(!customerRepo.existsById(customerID)){
            throw new RuntimeException("Customer Not Exists..!!");
        }
        customerRepo.deleteById(customerID);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
