package com.car.carrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.carrental.model.Car;
import com.car.carrental.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepo;

    @Override
    public String upsertCar(Car car) {
        carRepo.save(car);
        return "Success";
    }

    @Override
    public String editCar(Car car) {
        carRepo.save(car);
        return "Success";
    }

    @Override
    public List<Car> getAllCar() {
        return carRepo.findAll();
    }

    @Override
    public Car getById(String id) {
        Optional<Car> findById = carRepo.findById(id);

        if(findById.isPresent())
            return findById.get();
        else
            return null;
    }

    @Override
    public String deleteCar(String id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
            return "Deleted Successfully";
        } else{
            return "No record found";
        }
    }
}
