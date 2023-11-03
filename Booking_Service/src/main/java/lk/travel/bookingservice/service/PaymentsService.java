package lk.travel.bookingservice.service;

import lk.travel.bookingservice.dto.PaymentsDTO;

import java.util.List;

public interface PaymentsService {
    PaymentsDTO savePayment(PaymentsDTO paymentsDTO);
    PaymentsDTO updatePayment(PaymentsDTO paymentsDTO);
    PaymentsDTO searchPayment(String cardNo);
    void deletePayment(String cardNo);
    List<PaymentsDTO> getAllPayments();
}
