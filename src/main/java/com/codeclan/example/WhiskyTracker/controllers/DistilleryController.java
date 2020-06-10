package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public ResponseEntity<List<Distillery>> findDistillery(
            @RequestParam(name="region", required = false) String region,
            @RequestParam(name="whiskyAge", required = false) Integer age
    ){
        if (region != null){
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        if (age != null){
            return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(age), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }


}


//    @GetMapping("/raids")
//    public ResponseEntity<List<Raid>> findByRaidsFilterByLocation(
//            @RequestParam(name="location", required = false) String location,
//            @RequestParam(name= "loot", required = false) Integer loot
//    ){
//        if (location != null){
//            return new ResponseEntity<>(raidRepository.findByLocation(location), HttpStatus.OK);
//        }
//        if (loot != null){
//            return new ResponseEntity<>(raidRepository.findByLoot(loot), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
//    }