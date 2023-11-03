package lk.travel.bookingservice.service.impl;


import lk.travel.bookingservice.repo.BookingRepo;
import lk.travel.bookingservice.service.BookingService;
import lk.travel.customerservice.dto.BookingDTO;
import lk.travel.customerservice.entity.Booking;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;
    private final ModelMapper mapper;

    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        if (bookingRepo.existsById(bookingDTO.getBookingID())) {
            throw new RuntimeException("Booking Already Exist..!");
        }
        bookingRepo.save(mapper.map(bookingDTO, Booking.class));
        return bookingDTO;
    }

    @Override
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        Optional<Booking> byId = bookingRepo.findById(bookingDTO.getBookingID());
        if (byId.isEmpty()) {
            throw new RuntimeException("Booking Not Exist..!");
        } else if (getBookingHours(byId.get().getBookingDate(), byId.get().getBookingTime()) > 48) {
            throw new RuntimeException("Time over more than 48hour, You can't Change your detail");
        }
        bookingRepo.save(mapper.map(bookingDTO, Booking.class));
        return bookingDTO;
    }

    @Override
    public BookingDTO searchBooking(String bookingID) {
        Optional<Booking> byId = bookingRepo.findById(bookingID);
        if (byId.isEmpty()) {
            throw new RuntimeException("Booking NotExist..!");
        }
        return mapper.map(byId.get(), BookingDTO.class);
    }

    @Override
    public List<BookingDTO> searchBookingCustomerID(String customerID) {
        return mapper.map(bookingRepo.findByCustomerCustomerID(customerID),  new TypeToken<List<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void deleteBooking(String bookingID) {
        Optional<Booking> byId = bookingRepo.findById(bookingID);
        if (byId.isEmpty()) {
            throw new RuntimeException("Booking Not Exist..!");
        } else if (getBookingHours(byId.get().getBookingDate(), byId.get().getBookingTime()) > 48) {
            throw new RuntimeException("Time over more than 48hour, You can't Change your detail");
        }
        bookingRepo.deleteById(bookingID);
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return mapper.map(bookingRepo.findAll(), new TypeToken<List<BookingDTO>>() {
        }.getType());
    }

    private long getBookingHours(LocalDate date, LocalTime time) {
        return Duration.between(LocalDateTime.of(date, time), LocalDateTime.now()).toHours();
    }
}
