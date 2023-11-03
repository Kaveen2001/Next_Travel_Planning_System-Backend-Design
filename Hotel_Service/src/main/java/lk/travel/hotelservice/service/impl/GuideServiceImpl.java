package lk.travel.hotelservice.service.impl;

import lk.travel.hotelservice.dto.GuideDTO;
import lk.travel.hotelservice.entity.Guide;
import lk.travel.hotelservice.repo.GuideRepo;
import lk.travel.hotelservice.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

    private final GuideRepo guideRepo;
    private final ModelMapper modelMapper;

    @Override
    public GuideDTO saveGuide(GuideDTO guideDTO) {
        if (guideRepo.existsById(guideDTO.getGuideID())) {
            throw new RuntimeException("Guide Already Exist...!!");
        }
        guideRepo.save(modelMapper.map(guideDTO, Guide.class));
        return guideDTO;
    }

    @Override
    public GuideDTO updateGuide(GuideDTO guideDTO) {
        if (!guideRepo.existsById(guideDTO.getGuideID())) {
            throw new RuntimeException("Guide Not Exist...!!");
        }
        guideRepo.save(modelMapper.map(guideDTO, Guide.class));
        return guideDTO;
    }

    @Override
    public GuideDTO searchGuide(String guideID) {
        if (!guideRepo.existsById(guideID)) {
            throw new RuntimeException("Guide Not Exist...!!");
        }
        return modelMapper.map(guideRepo.findById(guideID), GuideDTO.class);
    }

    @Override
    public void deleteGuide(String guideID) {
        if (!guideRepo.existsById(guideID)) {
            throw new RuntimeException("Guide Not Exist...!!");
        }
        guideRepo.deleteById(guideID);
    }

    @Override
    public List<GuideDTO> getAllGuide() {
        return modelMapper.map(guideRepo.findAll(), new TypeToken<List<GuideDTO>>() {
        }.getType());
    }
}
