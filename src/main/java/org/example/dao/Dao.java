package org.example.dao;

import org.example.model.People;

import java.util.List;

public interface Dao {

    void createPeopleTable();
    void savePeople(String name,String lastName,int age);
    void updatePeople();
    void removePeopleByName(String name);
    List<People> getPeopleWithNameAndAge(int age, String name);
    List<People>getAllPeople();

}
