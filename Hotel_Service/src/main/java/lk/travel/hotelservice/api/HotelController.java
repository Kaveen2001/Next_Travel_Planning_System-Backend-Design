package lk.travel.hotelservice.api;

import lk.travel.hotelservice.dto.GuideDTO;
import lk.travel.hotelservice.dto.HotelDTO;
import lk.travel.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/saveHotel")
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity(hotelService.saveHotel(hotelDTO), HttpStatus.OK);
    }

    @PutMapping("/updateHotel")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity(hotelService.updateHotel(hotelDTO), HttpStatus.OK);
    }

    @PutMapping(path = "image", params = "hotelID", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HotelDTO> updateImageHotel(@RequestPart byte[] image, @RequestParam String hotelID) {
        HotelDTO hotelDTO = hotelService.searchHotel(hotelID);
        hotelDTO.setHotelImage(image);
        return new ResponseEntity(hotelService.updateHotel(hotelDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search", params = "hotelID")
    public ResponseEntity<HotelDTO> searchHotel(@RequestParam String hotelID) {
        return new ResponseEntity(hotelService.searchHotel(hotelID), HttpStatus.OK);
    }

    @DeleteMapping(path = "deleteHotel/{hotelID}")
    public ResponseEntity<GuideDTO> deleteHotel(@PathVariable("hotelID") String hotelID) {
        hotelService.deleteHotel(hotelID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<HotelDTO>> getAllHotel() {
        return new ResponseEntity(hotelService.getAllHotel(), HttpStatus.OK);
    }
}
