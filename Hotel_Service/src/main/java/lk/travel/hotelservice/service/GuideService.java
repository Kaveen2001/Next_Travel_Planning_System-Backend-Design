package lk.travel.hotelservice.service;



import lk.travel.hotelservice.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO);
    GuideDTO updateGuide(GuideDTO guideDTO);
    GuideDTO searchGuide(String guideID);
    void deleteGuide(String guideID);
    List<GuideDTO> getAllGuide();
}
