package ru.netology.manager;

import ru.netology.domain.TicketSearch;

import java.util.Comparator;

    public class TicketSearchByFlightTime implements Comparator<TicketSearch> {
        public int compare(TicketSearch o1, TicketSearch o2) {
            return o1.getFlightTime() - o2.getFlightTime();
        }
    }
