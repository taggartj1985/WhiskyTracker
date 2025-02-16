package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public ResponseEntity  getWhiskies(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="distillery", required = false) String distillery,
            @RequestParam(name="age", required = false) Integer age,
            @RequestParam(name="region", required = false) String region)
    {
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }

        if(distillery != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(distillery, age), HttpStatus.OK);
        }

        if(region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }


        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }



    //            @RequestParam(name="distillery", required = false) String distillery,
//            @RequestParam(name="age", required = false) Integer age,
//            @RequestParam(name="region", required = false) String region

//        if(distillery != null && age != null){
//            return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndWhiskyAge(distillery, age), HttpStatus.OK);
//        }
//
//        if(region != null){
//            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
//        }




}
