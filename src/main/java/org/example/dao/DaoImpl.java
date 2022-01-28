package org.example.dao;

import org.example.model.People;
import org.example.util.Util;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class DaoImpl implements Dao {
    @Override
    public void createPeopleTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created...");
    }

    @Override
    public void savePeople(String name, String lastName, int age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        People people = new People(name, lastName, age);
        session.save(people);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully added...");
    }

    @Override
    public List<People> getAllPeople() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        List<People> people = session.createQuery("from People ").getResultList();
        session.getTransaction().commit();
        System.out.println("Found : " + people.size()+" people");
        return people;
    }

    @Override
    public List<People> getPeopleWithNameAndAge(int age, String name) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        List<People> peopleList = session.createQuery("from People").getResultList();
        session.getTransaction().commit();
        List<People> people;
        people = peopleList.stream().filter((s) -> s.getName().equals(name)).filter((n) -> n.getAge() > age).toList();
        session.close();
        return people;
    }

    @Override
    public void updatePeople() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Query query=session.createQuery("update People set age=18 where name='Aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated...");
    }

    @Override
    public void removePeopleByName(String name) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("Delete from People where name='Aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Successfully deleted...");
        session.close();
    }
}
