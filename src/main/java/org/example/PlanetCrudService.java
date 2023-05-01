package org.example;

import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PlanetCrudService {
    private final SessionFactory sessionFactory;

    public PlanetCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Object getPlanet(String id) {
        Session session = sessionFactory.openSession();
        if(id == null) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Planet> criteriaQuery = criteriaBuilder.createQuery(Planet.class);
            criteriaQuery.from(Planet.class);
            Query query = session.createQuery(criteriaQuery);
            List planetList = query.getResultList();
            session.close();

            return planetList;
        }else {
            return session.get(Planet.class, id);
        }
    }
}
