package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterTest {
    @Test
    void testDepartureBeforeNowFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new DepartureBeforeNowFilter();
        List<Flight> result = filter.filter(flights);
        assertTrue(result.stream().allMatch(flight -> flight.getSegments().stream().allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))));
    }

    @Test
    void testArrivalBeforeDepartureFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> result = filter.filter(flights);
        assertTrue(result.stream().allMatch(flight -> flight.getSegments().stream().allMatch(segment -> !segment.getArrivalDate().isBefore(segment.getDepartureDate()))));
    }

    @Test
    void testExcessiveGroundTimeFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new ExcessiveGroundTimeFilter();
        List<Flight> result = filter.filter(flights);
        assertTrue(result.stream().allMatch(flight -> {
            List<Segment> segments = flight.getSegments();
            long totalGroundTime = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                totalGroundTime += arrival.until(nextDeparture, ChronoUnit.MINUTES);
            }
            return totalGroundTime <= 120;
        }));
    }
}
