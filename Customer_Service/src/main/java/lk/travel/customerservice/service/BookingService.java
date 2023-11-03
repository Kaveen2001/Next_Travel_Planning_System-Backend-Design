package lk.travel.customerservice.service;

import lk.travel.customerservice.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO saveBooking(BookingDTO bookingDTO);
    BookingDTO updateBooking(BookingDTO bookingDTO);
    BookingDTO searchBooking(String bookingID);
    List<BookingDTO> searchBookingCustomerID(String customerID);
    void deleteBooking(String bookingID);
    List<BookingDTO> getAllBooking();
}
