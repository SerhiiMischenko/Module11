package org.example;

import org.example.hibernate.HibernateUtil;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


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

    public Object getTicket(Long id) {
        Session session = sessionFactory.openSession();
        if (id == null) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
            criteriaQuery.from(Ticket.class);
            Query query = session.createQuery(criteriaQuery);
            List ticketList = query.getResultList();
            session.close();

            return ticketList;
        } else {
            return session.get(Ticket.class, id);
        }
    }

    public void updateTicket(Session session, Ticket ticket) {
        session.update(ticket);
    }

    public void deleteTicket(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Ticket.class, id));
        session.getTransaction().commit();
        session.close();
    }
}

