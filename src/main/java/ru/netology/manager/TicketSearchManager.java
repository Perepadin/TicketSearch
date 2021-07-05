package ru.netology.manager;

import ru.netology.domain.TicketSearch;
import ru.netology.repository.TicketSearchRepository;

import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;


public class TicketSearchManager {
    private TicketSearchRepository ticketSearchRepository = new TicketSearchRepository();

    public TicketSearchManager(TicketSearchRepository repository) {
        this.ticketSearchRepository = repository;
    }

    public void add(TicketSearch item) {
        ticketSearchRepository.save(item);
    }

    public TicketSearch[] findAll(String from, String to) {
        TicketSearch[] result = new TicketSearch[0];
        for (TicketSearch ticketSearch : ticketSearchRepository.findAll()) {
            if (ticketSearch.getArrivalAirport().equalsIgnoreCase(from) & ticketSearch.getDepartureAirport().equalsIgnoreCase(to)) {
                TicketSearch[] tmp = new TicketSearch[result.length + 1];
                arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticketSearch;
                result = tmp;
            }
        }
        sort(result);
        return result;
    }
}
