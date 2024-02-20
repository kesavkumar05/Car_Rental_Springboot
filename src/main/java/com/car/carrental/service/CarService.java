package com.car.carrental.service;



import java.util.List;

import com.car.carrental.model.Car;

public interface CarService {
    public String upsertCar(Car car);

    public String editCar(Car car);

    public List<Car> getAllCar();

    public Car getById(String id);

    public String deleteCar(String id);


}