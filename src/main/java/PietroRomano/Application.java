package PietroRomano;


import DAO.EventsDAO;
import entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed= new EventsDAO(em);

        Event newEvent = new Event ("Concerto musicale", LocalDate.of(2024, 6, 6), "Concerto gratuito in piazza", Event.TipoEvento.PUBBLICO, 1000);
        Event event2 = new Event("Sagra delle castagne", LocalDate.of(2024, 7, 10), "Sagra delle castagne tipiche siciliane", Event.TipoEvento.PUBBLICO,5000);
        Event event3 = new Event("Workshop di cucina", LocalDate.of(2024, 8, 15), "Workshop di cucina italiana", Event.TipoEvento.PRIVATO, 20);
        Event event4 = new Event("Mostra d'arte", LocalDate.of(2024, 9, 5), "Mostra d'arte contemporanea", Event.TipoEvento.PRIVATO, 300);
        ed.save(newEvent);
        ed.save(event2);
        ed.save(event3);
        ed.save(event4);

        // Recupero degli eventi dal database per ID


        em.close();
        emf.close();

    }
}
