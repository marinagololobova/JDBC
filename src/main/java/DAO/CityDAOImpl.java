package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void addCity(City city) {
        try (Session session = HbSessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City findById(int id) {
        try(Session session = HbSessionUtil.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try(Session session = HbSessionUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City ").list();
        }
    }

    @Override
    public void updateCity(int id, City city) {
        try (Session session = HbSessionUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            city.setCity_Id(id);
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HbSessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
