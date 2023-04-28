package org.example;

import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientCrudService {
    private SessionFactory sessionFactory;

    public ClientCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Client> getClientList() {
        Session session = sessionFactory.openSession();
        session.get(Client.class, 1L);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        Query query = session.createQuery(criteriaQuery);
        List<Client> clientList = query.getResultList();
        session.close();

        return clientList;
    }
}
