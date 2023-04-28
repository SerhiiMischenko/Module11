package org.example;

import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientCrudService {
    private SessionFactory sessionFactory;

    public ClientCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Client getClientById(long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(idPredicate);
        Query query = session.createQuery(criteriaQuery);
        Client client = (Client) ((org.hibernate.query.Query<?>) query).uniqueResult();
        session.close();

        return client;
    }
}
