package com.company.demo.sevice;

import com.company.demo.dao.CarDao;
import com.company.demo.model.Car;
import com.company.demo.viewmodel.CarViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ServiceLayer {
    private CarDao carDao;

    @Autowired
    public ServiceLayer(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    public CarViewModel saveCar(CarViewModel carViewModel){

        Car c = new Car();
        c.setCarMake(carViewModel.getCarMake());
        c.setColor(carViewModel.getCarColor());

        c = carDao.addCar(c);

        carViewModel.setId(c.getId());

        return carViewModel;
    }

    public CarViewModel findCar(int id) {
        Car car = carDao.getCarMake(id);

        return buildCarViewModel(car);
    }


    private CarViewModel buildCarViewModel( Car car) {



        CarViewModel carViewModel = new CarViewModel();

        carViewModel.setId(car.getId());
        carViewModel.setCarMake(car.getCarMake());
        carViewModel.setCarColor(car.getColor());

        return carViewModel;

    }

    public List<CarViewModel> findAllCars(){

        List<Car> carList = carDao.getAllCars();
        List<CarViewModel> cvm = new ArrayList<>();

        for(Car car : carList){
            CarViewModel viewModel = buildCarViewModel(car);
            cvm.add(viewModel);

        }
        return cvm;
    }
}
