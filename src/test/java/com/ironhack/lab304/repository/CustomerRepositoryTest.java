package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Aircraft;
import com.ironhack.lab304.model.Customer;
import com.ironhack.lab304.model.CustomerStatus;
import com.ironhack.lab304.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    private Customer testCustomer;
    private Aircraft testAircraft;
    private Flight testFlight;
    @Autowired
    CustomerRepository customerRepository;
    AircraftRepository aircraftRepository;
    FlightRepository flightRepository;
    @BeforeEach
    void setUp() {

        testCustomer = new Customer("Franco Abel", CustomerStatus.SILVER);
        testAircraft = new Aircraft("Boeing 777", 400);
        testFlight = new Flight("DL-35", 1500L, "Airbus A300");


    }

    @AfterEach
    void tearDown() {

        customerRepository.deleteById(testCustomer.getId());
    }

    @Test
    public void createCustomer_validCustomer_addedToDatabase() {


        Customer customer = new Customer("Jose", CustomerStatus.GOLD);
        customerRepository.save(testCustomer);
        Optional<Customer> foundCustomer = customerRepository.findById(testCustomer.getId());
        assertTrue(foundCustomer.isPresent());
        assertEquals(testCustomer.getName(), foundCustomer.get().getName());
        assertEquals(testCustomer.getStatus(), foundCustomer.get().getStatus());


        Aircraft aircraft = new Aircraft("Boeing 777", 400);
        aircraftRepository.save(testAircraft);
        Optional<Aircraft> foundAircraft = aircraftRepository.findById(testAircraft.getModel());
        assertTrue(foundAircraft.isPresent());
        assertEquals("%Boeing%", foundAircraft.get().getModel());


        Flight flight = new Flight("DL-35", 1500L, "Airbus A300");
        flightRepository.save(testFlight);
        Optional<Flight> foundFlight = flightRepository.findById(testFlight.getNumber());
        assertTrue(foundFlight.isPresent());
        assertEquals(testFlight.getNumber(), foundFlight.get().getNumber());
        assertEquals("DL-35", flightRepository.findByScoreGreaterThan(500));


    }

}