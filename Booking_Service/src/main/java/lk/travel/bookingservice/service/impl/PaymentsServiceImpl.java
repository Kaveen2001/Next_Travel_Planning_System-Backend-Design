package lk.travel.bookingservice.service.impl;

import lk.travel.bookingservice.dto.PaymentsDTO;
import lk.travel.bookingservice.entity.Payments;
import lk.travel.bookingservice.repo.PaymentsRepo;
import lk.travel.bookingservice.service.PaymentsService;
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
public class PaymentsServiceImpl implements PaymentsService {

    private final PaymentsRepo paymentsRepo;
    private final ModelMapper modelMapper;

    @Override
    public PaymentsDTO savePayment(PaymentsDTO paymentsDTO) {
        if(paymentsRepo.existsById(paymentsDTO.getCardNo())){
            throw new RuntimeException("Payment Already Exists..!!");
        }
        paymentsRepo.save(modelMapper.map(paymentsDTO, Payments.class));
        return paymentsDTO;
    }

    @Override
    public PaymentsDTO updatePayment(PaymentsDTO paymentsDTO) {
        if(!paymentsRepo.existsById(paymentsDTO.getCardNo())){
            throw new RuntimeException("Payment Not Exists..!!");
        }
        paymentsRepo.save(modelMapper.map(paymentsDTO, Payments.class));
        return paymentsDTO;
    }

    @Override
    public PaymentsDTO searchPayment(String cardNo) {
        if(!paymentsRepo.existsById(cardNo)){
            throw new RuntimeException("Payment Not Exists..!!");
        }
        return modelMapper.map(paymentsRepo.findById(cardNo),PaymentsDTO.class);
    }

    @Override
    public void deletePayment(String cardNo) {
        if(!paymentsRepo.existsById(cardNo)){
            throw new RuntimeException("Payment Not Exists..!!");
        }
        paymentsRepo.deleteById(cardNo);
    }

    @Override
    public List<PaymentsDTO> getAllPayments() {
        return modelMapper.map(paymentsRepo.findAll(),new TypeToken<List<PaymentsDTO>>(){}.getType());
    }
}
