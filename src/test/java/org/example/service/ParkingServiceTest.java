package org.example.service;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {

    @Test
    void testEmptyParkedCars() {
        ParkingService service = new ParkingService();
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldIncreaseTotalParked() {
        ParkingService service = new ParkingService();
        service.park("ABC-1234");
        assertEquals(1, service.getTotalParked());
    }

    @Test
    void shouldIncreaseTotalParkedCaseTwoCars() {
        ParkingService service = new ParkingService();
        service.park("ABC-1234");
        service.park("ABC-4564");
        assertEquals(2, service.getTotalParked());
    }

    @Test
    void shouldIncreaseTotalUnParkedCaseTwoCars() {
        ParkingService service = new ParkingService();
        service.park("ABC-1234");
        service.park("ABC-4564");
        service.unpark("ABC-1234");
        assertEquals(1, service.getTotalParked());
    }

    @Test
    void shouldIncreaseTotalUnParkedCaseThreeCars() {
        ParkingService service = new ParkingService();
        service.park("ABC-123");
        service.park("ABC-123");
        service.park("ABC-123");
        service.unpark("ABC-123");
        assertEquals(0, service.getTotalParked());

    }

    @Test
    void shouldIncreaseTotalUnParkedCaseThreeCarsAndUppercase() {
        ParkingService service = new ParkingService();
        service.park("ABC-123");
        service.park("ABC-123");
        service.park("abc-123");
        service.unpark("ABC-123");
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldIncreaseWhenIsNull() {
        ParkingService service = new ParkingService();
        service.park(null);
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldIncreaseWhenIsEmpty() {
        ParkingService service = new ParkingService();
        service.park("");
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldIncreaseWhenHasSpaces() {
        ParkingService service = new ParkingService();
        service.park("       ");
        assertEquals(0, service.getTotalParked());
    }


    @Test
    void shouldIncreaseWhenis5() {
        ParkingService service = new ParkingService();
        service.park("5");
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldntIncreaseDigitAllowedLong() {
        ParkingService service = new ParkingService();
        service.park("ABCBSBSBSBSBSBSBSB");
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldntIncreaseDigitAllowedShort() {
        ParkingService service = new ParkingService();
        service.park("AB3");
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldIncreaseWhenIsOrNotHyphen() {
        ParkingService service = new ParkingService();
        service.park("ABC4567");
        service.park("ABC--4567");
        assertEquals(1, service.getTotalParked());
    }

    @Test
    void shouldIncreaseWhenIsNotHyphen() {
        ParkingService service = new ParkingService();
        service.park("ABC$4567");
        assertEquals(0, service.getTotalParked());
    }

    @Test
    void shouldIncreaseHyphen() {
        ParkingService service = new ParkingService();
        service.park("ABC4560");
        service.park("ABC-4569");
        service.unpark("ABC-4560");
        assertEquals(1, service.getTotalParked());
    }

}