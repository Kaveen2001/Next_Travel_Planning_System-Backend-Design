package lk.travel.hotelservice.service;

import lk.travel.hotelservice.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);
    HotelDTO updateHotel(HotelDTO hotelDTO);
    HotelDTO searchHotel(String hotelID);
    void deleteHotel(String hotelID);
    List<HotelDTO> getAllHotel();
}
