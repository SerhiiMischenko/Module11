package org.example;

import org.example.hibernate.HibernateUtil;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TicketCrudService {
    private final SessionFactory sessionFactory;

    public TicketCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void createTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(ticket);
        session.getTransaction().commit();
        session.close();
    }

    public Ticket getTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        ticket = session.get(Ticket.class, ticket.getId());
        return ticket;
    }

    public void updateTicket(Session session, Ticket ticket) {
        session.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(ticket);
        session.getTransaction().commit();
        session.close();
    }
}

