package org.example;

import org.hibernate.SessionFactory;

public class PlanetCrudService {
    private SessionFactory sessionFactory;

    public PlanetCrudService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


}
