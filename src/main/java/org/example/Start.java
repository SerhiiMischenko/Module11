package org.example;

import org.example.hibernate.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Ticket;
import org.hibernate.Session;
import java.util.Set;

public class Start {
        public static void main(String[] args) {
                TicketCrudService ticketCrudService = new TicketCrudService();
                Session session = HibernateUtil.getSessionFactory().openSession();
                Client client = session.get(Client.class, 18L);
                Set<Ticket> tickets = client.getTickets();
                Ticket ticket = tickets.stream()
                        .filter(t -> t.getId() == 29)
                        .findFirst()
                        .orElse(null);
                ticketCrudService.createTicket(ticket);
                ticketCrudService.updateTicket(session, ticket);
                assert ticket != null;
                System.out.println(ticketCrudService.getTicket(ticket.getId()));
                ticketCrudService.deleteTicket(ticket.getId());
                session.close();
        }
}
