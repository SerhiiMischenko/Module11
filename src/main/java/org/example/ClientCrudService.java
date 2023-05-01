package org.example;

import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ClientCrudService {
    private final SessionFactory sessionFactory;

    public ClientCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void createClient(String clientName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = new Client();
        client.setName(clientName);
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    public Object getClient(Long id) {
        Session session = sessionFactory.openSession();
        if(id == null) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            criteriaQuery.from(Client.class);
            Query query = session.createQuery(criteriaQuery);
            List clientList = query.getResultList();
            session.close();

            return clientList;
        }else {
            return session.get(Client.class, id);
        }
    }
    public void updateClient(Long id, String newName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        client.setName(newName);
        session.update(client);
        session.getTransaction().commit();
        session.close();
    }


    public void deleteClient(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Client.class, id));
        session.getTransaction().commit();
        session.close();
    }
}
