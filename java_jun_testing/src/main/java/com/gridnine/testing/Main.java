package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter departureBeforeNowFilter = new DepartureBeforeNowFilter();
        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        FlightFilter excessiveGroundTimeFilter = new ExcessiveGroundTimeFilter();

        System.out.println("Original flights:");
        flights.forEach(System.out::println);

        System.out.println("\nFlights after filtering departures before now:");
        departureBeforeNowFilter.filter(flights).forEach(System.out::println);

        System.out.println("\nFlights after filtering arrivals before departures:");
        arrivalBeforeDepartureFilter.filter(flights).forEach(System.out::println);

        System.out.println("\nFlights after filtering excessive ground time:");
        excessiveGroundTimeFilter.filter(flights).forEach(System.out::println);
    }
}
