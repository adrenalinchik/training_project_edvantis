package com.edvantis.training.parking.api;

import com.edvantis.training.parking.models.Garage;
import com.edvantis.training.parking.services.GarageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by taras.fihurnyak on 5/3/2017.
 */

@RestController
@RequestMapping("/parking/api")
public class GarageEndpoind {

    private final static Logger logger = LoggerFactory.getLogger(OwnerEndpoint.class);

    private final GarageService garageService;

    @Autowired
    public GarageEndpoind(GarageService garageService) {
        this.garageService = garageService;
    }


    //Get All Garages for specific parking
    @RequestMapping(value = "/garages/parking/{parkingId}", method = GET)
    public List<Garage> getGarages(@PathVariable("parkingId") long parkingId) {
        return garageService.getAllParkingGarages(parkingId);
    }

    //Get All garages from the database
    @RequestMapping(value = "/garages", method = GET)
    public List<Garage> getAllGarages() {
        return garageService.getAllGarages();
    }
}
