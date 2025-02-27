package co.edu.escuelaing.arws.interactiveblackboard.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import co.edu.escuelaing.arws.interactiveblackboard.annotations.GeneratedExcludeFromCodeCoverage;

@GeneratedExcludeFromCodeCoverage
@Component
@SuppressWarnings("unused")
public class TicketRepository {
    
    
    @Autowired
    private StringRedisTemplate template;

    // inject the template as ListOperations
    @jakarta.annotation.Resource(name = "stringRedisTemplate")
    private ListOperations<String, String> listTickets;

    private int ticketnumber;

    @Autowired
    public TicketRepository(StringRedisTemplate template){
        this.template = template;
    }

    public synchronized Integer getTicket() {
        Integer a = ticketnumber++;
        listTickets.leftPush("ticketStore", a.toString());
        return a;
    }

    public boolean checkTicket(String ticket) {
        Long isValid = listTickets.getOperations().boundListOps("ticketStore").remove(0, ticket);
        return (isValid > 0l);
    }

    private void eviction() {
        // Delete tickets after timout or include this functionality in checkticket
    }
}