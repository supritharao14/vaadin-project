package com.example.demo.controller;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a RestController for People entity
 * Author: Supritha Rao
 */
@RestController
@RequestMapping("/people")
public class PeopleRestController {

    @Autowired
    PeopleService peopleService;

    /**
     * This method is used to add a new People object
     * @param people
     * @return ResponseDto with status message
     */
    @PostMapping()
    public ResponseEntity<ResponseDto> addPeople(@RequestBody People people) {

        return new ResponseEntity<>(peopleService.addPeople(people), HttpStatus.OK);
    }

    /**
     * This method is used to get all People objects
     * @return List of People objects
     */
    @GetMapping
    public List<People> getAllPeople() {
        return peopleService.findAll();
    }

    /**
     * This method is used to delete a People object
     * @param people
     * @return ResponseDto with status message
     */
    @DeleteMapping
    public ResponseEntity<ResponseDto> deletePeople(People people) {
        return new ResponseEntity<>(peopleService.deletePeople(people), HttpStatus.OK);
    }
}
