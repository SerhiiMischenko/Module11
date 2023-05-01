package org.example;

import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class PlanetCrudService {
    private final SessionFactory sessionFactory;

    public PlanetCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Object getPlanet(String id) {
        Session session = sessionFactory.openSession();
        if(id == null) {
            session.get(Planet.class, "EARTH");
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Planet> criteriaQuery = criteriaBuilder.createQuery(Planet.class);
            criteriaQuery.from(Planet.class);
            Query query = session.createQuery(criteriaQuery);
            List planetList = query.getResultList();
            session.close();

            return planetList;
        }else {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Planet> criteriaQuery = criteriaBuilder.createQuery(Planet.class);
            Root<Planet> root = criteriaQuery.from(Planet.class);
            Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
            criteriaQuery.where(idPredicate);
            org.hibernate.query.Query<?> query = session.createQuery(criteriaQuery);
            Planet planet = (Planet) query.uniqueResult();
            session.close();

            return planet;
        }
    }
}
