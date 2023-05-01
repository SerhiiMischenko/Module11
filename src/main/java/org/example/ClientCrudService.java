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
    private final SessionFactory sessionFactory;

    public ClientCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Object getClient(Long id) {
        Session session = sessionFactory.openSession();
        if(id == null) {
            session.get(Client.class, 1L);
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            criteriaQuery.from(Client.class);
            Query query = session.createQuery(criteriaQuery);
            List clientList = query.getResultList();
            session.close();

            return clientList;
        }else {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root<Client> root = criteriaQuery.from(Client.class);
            Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
            criteriaQuery.where(idPredicate);
            org.hibernate.query.Query<?> query = session.createQuery(criteriaQuery);
            Client client = (Client) query.uniqueResult();
            session.close();

            return client;
        }
    }
}
