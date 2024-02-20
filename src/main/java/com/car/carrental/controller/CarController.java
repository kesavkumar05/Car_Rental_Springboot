package com.car.carrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.car.carrental.model.Car;
import com.car.carrental.service.CarService;

import java.util.List;


@RestController
public class CarController {
     @Autowired
    private CarService carService;

    @PostMapping("/saveCar")
    public ResponseEntity<String> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.upsertCar(car), HttpStatus.ACCEPTED);
    }

    @PostMapping("/editCar")
    public ResponseEntity<String> editCar(@RequestBody Car car,@RequestParam(name="id") String id){
        car.setCarId(id);
        return new ResponseEntity<>(carService.upsertCar(car), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCars")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCar(),HttpStatus.OK);
    }

    @GetMapping("/getCar")
    public ResponseEntity<Car> getByID(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(carService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(carService.deleteCar(id),HttpStatus.OK);
    }
    
}
