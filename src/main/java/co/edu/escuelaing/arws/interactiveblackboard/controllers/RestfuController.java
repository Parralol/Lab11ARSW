package co.edu.escuelaing.arws.interactiveblackboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.arws.interactiveblackboard.redis.TicketRepository;

@RestController
public class RestfuController {

    @Autowired
    TicketRepository ticketRepo;

    @GetMapping("/getticket")
    public String getTicket() {
        return "{\"ticket\":\"" +
                ticketRepo.getTicket() + "\"}";
    }
}
