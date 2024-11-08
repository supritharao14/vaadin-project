package com.example.demo.repository;

import com.example.demo.entity.People;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PeopleRepository {

static List<People> peopleList = new ArrayList<>();

    public People save(People people) {

        Random random = new Random();
        System.out.println("people.getId() = " + people.getId());
        if (people.getId() == 0) {
            people.setId(random.nextInt(1, 100000));
            peopleList.add(people);
        }
        System.out.println("people.getId() = " + people.getId());

        return people;
    }

    public List<People> findAll() {
        peopleList.add(new People(1, "John", "Doe", "jon@gail.com"));
        peopleList.add(new People(2,"sup","rao","sup@gmail.com"));
        return peopleList;
    }

    public void delete(People people) {
        peopleList.remove(people);
    }
}
