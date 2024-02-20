package com.car.carrental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.carrental.model.Car;

public interface CarRepository extends JpaRepository<Car, String>  {

    boolean existsById(String id);

    void deleteById(String id);

    Optional<Car> findById(String id);
    
}
