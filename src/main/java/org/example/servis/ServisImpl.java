package org.example.servis;

import org.example.dao.Dao;
import org.example.dao.DaoImpl;
import org.example.model.People;

import java.util.List;

public class ServisImpl implements Servis {
    Dao dao = new DaoImpl();

    @Override
    public void createPeopleTable() {
        dao.createPeopleTable();
    }

    @Override
    public void savePeople(String name, String lastName, int age) {
        dao.savePeople(name, lastName, age);
    }

    @Override
    public void updatePeople() {
        dao.updatePeople();
    }

    @Override
    public void removePeopleByName(String name) {
        dao.removePeopleByName(name);
    }

    @Override
    public List<People> getPeopleWithNameAndAge(int age, String name) {
        return dao.getPeopleWithNameAndAge(age, name);
    }

    @Override
    public List<People> getAllPeople() {
        return dao.getAllPeople();
    }
}
