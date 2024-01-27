package gersay.tours.service;

import gersay.tours.entity.Tour;
import gersay.tours.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    @Autowired
    private TourRepository repo;

    public List<Tour> getAllTours() {
        return repo.findAll();
    }

    public Tour createTour(Tour tour) {
        return repo.save(tour);
    }


}
