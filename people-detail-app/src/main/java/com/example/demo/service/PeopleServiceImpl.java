package com.example.demo.service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.People;
import com.example.demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    @Override
    public ResponseDto addPeople(People people) {
        if (people == null)
            throw new IllegalArgumentException("People object is null");

        People savedPeople = peopleRepository.save(people);

        ResponseDto responseDto=new ResponseDto();

        responseDto.setStatusMessage("People added successfully");
        return responseDto;
    }

    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public ResponseDto deletePeople(People people) {
        if (people == null)
            throw new IllegalArgumentException("People object is null");

        peopleRepository.delete(people);

        ResponseDto responseDto=new ResponseDto();
        responseDto.setStatusMessage("People deleted successfully");
        return responseDto;
    }
}
