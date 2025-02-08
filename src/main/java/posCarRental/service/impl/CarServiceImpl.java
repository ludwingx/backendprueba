package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import posCarRental.dto.CarDto;
import posCarRental.dto.CarDtoListDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.entity.Brand;
import posCarRental.entity.Car;
import posCarRental.entity.Fuel;
import posCarRental.entity.Transmission;
import posCarRental.exception.CarNotFoundException;

import posCarRental.repository.*;
import posCarRental.service.ICarService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private IBrandRepository brandRepository;

    @Autowired
    private IFuelRepository fuelRepository;

    @Autowired
    private ITransmissionRepository transmissionRepository;

    @Override
    public boolean posCar(CarDto carDto) throws IOException{
        try {
            Car car = new Car();
            car.setName(carDto.getName());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setDescription(carDto.getDescription());
            car.setImage(carDto.getImage().getBytes());

            Brand brand = brandRepository.findById(carDto.getBrandId()).orElseThrow();
            Fuel fuel = fuelRepository.findById(carDto.getFuelId()).orElseThrow();
            Transmission transmission = transmissionRepository.findById(carDto.getTransmissionId()).orElseThrow();

            car.setBrand(brand);
            car.setFuel(fuel);
            car.setTransmission(transmission);

            carRepository.save(car);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    /*
    @Override
    public boolean createCar(CarDto carDto) throws Exception {
        try {
            Brand brand = brandRepository.findById(carDto.getBrandId()).orElseThrow();
            Fuel fuel = fuelRepository.findById(carDto.getFuelId()).orElseThrow();
            Transmission transmission = transmissionRepository.findById(carDto.getTransmissionId()).orElseThrow();
            Car car = Car.builder()
                    .name(carDto.getName())
                    .color(carDto.getColor())
                    .price(carDto.getPrice())
                    .year(carDto.getYear())
                    .description(carDto.getDescription())
                    .image(carDto.getImage().getBytes())
                    .brand(brand)
                    .fuel(fuel)
                    .transmission(transmission)
                    .build();
            carRepository.save(car);
            return true;
            }
        catch (Exception e){
            return false;
        }
    }

     */

    @Override
    public List<CarDto> findAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }


    @Override
    public CarDto getByCarId(Long id) {
        Optional<Car> carId =  carRepository.findById(id);
        if (carId.isPresent()) {
            return carId.get().getCarDto();
        }
        return null;
    }

    @Override
    public boolean updateByCarId(Long cardId, CarDto carDto) throws Exception {
            Optional<Car> optionalCarDto = carRepository.findById(cardId);
            Optional<Brand> optionalBrandDto = brandRepository.findById(carDto.getBrandId());
            Optional<Fuel> optionalFuelDto = fuelRepository.findById(carDto.getFuelId());
            Optional<Transmission> optionalTransmissionDto = transmissionRepository.findById(carDto.getTransmissionId());
            if (optionalCarDto.isPresent()) {
                Car existingCar = optionalCarDto.get();
                if (carDto.getImage() != null) {
                    existingCar.setImage(carDto.getImage().getBytes());
                }
                existingCar.setName(carDto.getName());
                existingCar.setYear(carDto.getYear());
                existingCar.setColor(carDto.getColor());
                existingCar.setPrice(carDto.getPrice());
                existingCar.setDescription(carDto.getDescription());
                existingCar.setBrand(optionalBrandDto.get());
                existingCar.setFuel(optionalFuelDto.get());
                existingCar.setTransmission(optionalTransmissionDto.get());
                carRepository.save(existingCar);
                return true;
            } else {
            return false;
            }

    }


    @Override
    public boolean deleteByCarId(Long id) throws CarNotFoundException {
        try {
            Car carId = carRepository.findById(id).orElseThrow(()-> new CarNotFoundException(id));
            carRepository.deleteById(carId.getId());
            return true;
        }catch (CarNotFoundException e){
            return false;
        }
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        Brand brand = new Brand();
        Fuel fuel = new Fuel();
        Transmission transmission = new Transmission();
        //car.setBrand(searchCarDto.getBrand());
        //car.setType(searchCarDto.getType());
        //car.setTransmission(searchCarDto.getTransmission());
        car.setBrand(brand);
        car.setFuel(fuel);
        car.setTransmission(transmission);
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("fuel", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample = Example.of(car, exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;
    }
}
