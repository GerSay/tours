package gersay.tours.controller;

import gersay.tours.entity.Tour;
import gersay.tours.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private TourService service;

    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = service.getAllTours();
        return ResponseEntity.ok(tours);
    }

    @PostMapping
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour createdTour = service.createTour(tour);
        return ResponseEntity.ok(createdTour);
    }
}
