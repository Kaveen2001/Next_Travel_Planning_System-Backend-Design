package lk.travel.hotelservice.service.impl;

import lk.travel.hotelservice.dto.HotelDTO;
import lk.travel.hotelservice.entity.Hotel;
import lk.travel.hotelservice.repo.HotelRepo;
import lk.travel.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

private final HotelRepo hotelRepo;
private final ModelMapper modelMapper;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        if(hotelRepo.existsById(hotelDTO.getHotelID())){
            throw new RuntimeException("Hotel Already Exists...!!");
        }
        hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
        return hotelDTO;
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        if(!hotelRepo.existsById(hotelDTO.getHotelID())){
            throw new RuntimeException("Hotel Not Exists...!!");
        }
        hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
        return hotelDTO;
    }

    @Override
    public HotelDTO searchHotel(String hotelID) {
        if(!hotelRepo.existsById(hotelID)){
            throw new RuntimeException("Hotel Not Exists...!!");
        }
        return modelMapper.map(hotelRepo.findById(hotelID),HotelDTO.class);
    }

    @Override
    public void deleteHotel(String hotelID) {
        if(!hotelRepo.existsById(hotelID)){
            throw new RuntimeException("Hotel Not Exists...!!");
        }
        hotelRepo.deleteById(hotelID);
    }

    @Override
    public List<HotelDTO> getAllHotel() {
        return modelMapper.map(hotelRepo.findAll(),new TypeToken<List<HotelDTO>>(){}.getType());
    }
}
