package lk.travel.hotelservice.api;


import lk.travel.hotelservice.dto.GuideDTO;
import lk.travel.hotelservice.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/guide")
public class GuideController {
    @Autowired
    GuideService guideService;

    @PostMapping("/saveGuide")
    public ResponseEntity<GuideDTO> saveGuide(@RequestBody GuideDTO guideDTO) {
        return ResponseEntity.ok(guideService.saveGuide(guideDTO));
    }

    @PutMapping("/updateGuide")
    public ResponseEntity<GuideDTO> updateGuide(@RequestBody GuideDTO guideDTO) {
        return ResponseEntity.ok(guideService.saveGuide(guideDTO));
    }

    @GetMapping(path = "search", params = "guideID")
    public ResponseEntity<GuideDTO> searchGuide(@RequestParam String guideID) {
        return ResponseEntity.ok(guideService.searchGuide(guideID));
    }

    @DeleteMapping(path = "deleteGuide/{guideID}")
    public ResponseEntity<GuideDTO> deleteGuide(@PathVariable("guideID") String guideID) {
        guideService.deleteGuide(guideID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getAllGuides")
    public ResponseEntity<List<GuideDTO>> getAllGuide() {
        return ResponseEntity.ok(guideService.getAllGuide());
    }
}
