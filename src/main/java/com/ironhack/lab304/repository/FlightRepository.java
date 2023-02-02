package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByScoreGreaterThan(int i);
}
