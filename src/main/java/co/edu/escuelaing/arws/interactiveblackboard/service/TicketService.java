package co.edu.escuelaing.arws.interactiveblackboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.arws.interactiveblackboard.redis.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean checkTicket(String ticket) {
        return ticketRepository.checkTicket(ticket);
    }
    
    public synchronized Integer getTicket() {
        return ticketRepository.getTicket();
    }
}
