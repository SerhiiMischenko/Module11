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

    public void createPlanet(String id, String planetName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(planetName);
        session.save(planet);
        session.getTransaction().commit();
        session.close();
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
    public void updatePlanet(String id, String newName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        planet.setName(newName);
        session.update(planet);
        session.getTransaction().commit();
        session.close();
    }
    public void deletePlanet(String id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Planet.class, id));
        session.getTransaction().commit();
        session.close();
    }
}
