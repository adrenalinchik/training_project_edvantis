package com.edvantis.training.parking.repository;

import com.edvantis.training.parking.models.Garage;
import com.edvantis.training.parking.models.GarageType;
import com.edvantis.training.parking.models.Reservation;

import java.util.Set;

/**
 * Created by taras.fihurnyak on 3/7/2017.
 */
public interface ReservationRepository {

    Reservation getById(Long id);

    Set<Reservation> getAll();

    void insert(Reservation garage);

    void update(int Id, Reservation garage);

    void update(Reservation garage);

    void delete(long Id);

    Set<Reservation> getAllReservationsByParking(long parkingId);

    Set<Garage> getGaragesByParkingId(long parkingId);

    Set<Reservation> getAllReservationsByGarageType(GarageType garageType);

    Set<Reservation> getAllReservations();

    Set<Garage> getGaragesByType(GarageType garageType);

    Set<Garage> getAllGarages();

    Reservation getLastReservation();

}