package com.example.demo.service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.People;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface PeopleService {

    ResponseDto addPeople(People people);

    List<People> findAll();

    ResponseDto deletePeople(People people);
}
