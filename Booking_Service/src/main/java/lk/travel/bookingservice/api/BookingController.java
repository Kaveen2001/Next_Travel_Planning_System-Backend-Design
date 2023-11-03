package lk.travel.bookingservice.api;

import lk.travel.customerservice.dto.BookingDTO;
import lk.travel.customerservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity(bookingService.saveBooking(bookingDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity(bookingService.updateBooking(bookingDTO), HttpStatus.OK);
    }



    @GetMapping(path = "search", params = "bookingID")
    public ResponseEntity<BookingDTO> searchBooking(@RequestParam String bookingID) {
        return new ResponseEntity(bookingService.searchBooking(bookingID), HttpStatus.OK);
    }
    @GetMapping(path = "search/customer", params = "customerID")
    public ResponseEntity<BookingDTO> searchBookingCustomerID(@RequestParam String customerID) {
        return new ResponseEntity(bookingService.searchBookingCustomerID(customerID), HttpStatus.OK);
    }


    @DeleteMapping(params = "bookingID")
    public ResponseEntity<BookingDTO> deleteBooking(@RequestParam String bookingID) {
        bookingService.deleteBooking(bookingID);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBooking() {
        return new ResponseEntity(bookingService.getAllBooking(), HttpStatus.OK);
    }
}
