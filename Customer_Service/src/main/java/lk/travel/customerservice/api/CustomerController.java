package lk.travel.customerservice.api;

import lk.travel.customerservice.dto.CustomerDTO;
import lk.travel.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

   private final CustomerService customerService;
   /*private final PasswordEncoder passwordEncoder;*/

    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        /*customerDTO.setCustomer(passwordEncoder.encode(customerDTO.getPwd()));*/
        System.out.println("Customer Name : "+customerDTO.getCustomerName());
        return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/updateCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        /*customerDTO.setPwd(passwordEncoder.encode(customerDTO.getPwd()));*/
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search/{customerID}")
    public ResponseEntity<CustomerDTO> searchCustomer(@PathVariable("customerID") String customerID) {
        return new ResponseEntity<>(customerService.searchCustomer(customerID), HttpStatus.OK);
    }
    @GetMapping(path = "search/email")
    public ResponseEntity<CustomerDTO> searchEmailCustomer(@RequestParam String customerEmail) {
        return new ResponseEntity<>(customerService.searchByEmailCustomer(customerEmail), HttpStatus.OK);
    }

    @DeleteMapping(path = "deleteCustomer/{customerID}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("customerID") String customerID) {
        customerService.deleteCustomer(customerID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
}
