package co.edu.escuelaing.arws.interactiveblackboard.endpoints;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import co.edu.escuelaing.arws.interactiveblackboard.configurator.SpringConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import co.edu.escuelaing.arws.interactiveblackboard.redis.TicketRepository;

@Component
@ServerEndpoint(value = "/bbService", configurator = SpringConfigurator.class)
@Configurable(preConstruction = true)
public class BBEndpoint {

    private static final Logger logger = Logger.getLogger(BBEndpoint.class.getName());
    static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    Session ownSession = null;
    private boolean accepted = false;

    @Autowired
    private TicketRepository ticketRepo;

    public void send(String msg) {
        try {
            for (Session session : queue) {
                if (!session.equals(this.ownSession)) {
                    session.getBasicRemote().sendText(msg);
                }
                logger.log(Level.INFO, "Sent: {0}", msg);
            }
        } catch (IOException e) {
            logger.log(Level.INFO, e.toString());
        }
    }

    @OnMessage
    public void processPoint(String message, Session session) {
        logger.log(Level.INFO, "Ticket/Point: " + message + ".Session: " + session);
        if (accepted) {
            this.send(message);
        } else {
            if (!accepted && ticketRepo.checkTicket(message)) {
                System.out.println("pto valido");
                accepted = true;
            } else {
                try {
                    System.out.println("pto NO valido");
                    ownSession.close();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @OnOpen
    public void openConnection(Session session) {
        queue.add(session);
        ownSession = session;
        logger.log(Level.INFO, "Connection opened.");
        try {
            session.getBasicRemote().sendText("Connection established.");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @OnClose
    public void closedConnection(Session session) {
        queue.remove(session);
        logger.log(Level.INFO, "Connection closed for session " + session);
    }

    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
        logger.log(Level.INFO, t.toString());
        logger.log(Level.INFO, "Connection error.");
    }
}
