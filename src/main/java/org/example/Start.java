package org.example;

import org.example.hibernate.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.Session;

public class Start {
        public static void main(String[] args) {
                TicketCrudService ticketCrudService = new TicketCrudService();
                Session session = HibernateUtil.getSessionFactory().openSession();
                Ticket createTicket = new Ticket();
                createTicket.setClient(session.load(Client.class, 18L));
                createTicket.setStartPlanet(session.load(Planet.class, "EARTH"));
                createTicket.setEndPlanet(session.load(Planet.class, "MARS"));
                ticketCrudService.createTicket(createTicket);
                session.close();

                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Ticket updateTicket = new Ticket();
                updateTicket.setId(2L);
                updateTicket.setClient(session1.load(Client.class, 4L));
                updateTicket.setStartPlanet(session1.load(Planet.class, "EARTH"));
                updateTicket.setEndPlanet(session1.load(Planet.class, "MARS"));
                session1.beginTransaction();
                ticketCrudService.updateTicket(session1, updateTicket);
                session1.getTransaction().commit();
                session1.close();

                System.out.println(ticketCrudService.getTicket(10L));

                ticketCrudService.deleteTicket(11L);

        }
}
