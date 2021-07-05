package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TicketSearch implements Comparable<TicketSearch> {
    private int id;
    private int price;
    private String arrivalAirport;
    private String departureAirport;
    private int flightTime;


    @Override
    public int compareTo(TicketSearch anotherTicket) {
        return price - anotherTicket.price;
    }
}
