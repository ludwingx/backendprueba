package posCarRental.service;

import org.springframework.stereotype.Service;
import posCarRental.dto.BookACarDto;
import posCarRental.dto.CarDto;
import posCarRental.dto.CarDtoListDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.entity.Car;

import java.io.IOException;
import java.util.List;

@Service
public interface ICarService {

    boolean posCar(CarDto carDto) throws Exception;

    List<CarDto> findAllCars();

    CarDto getByCarId(Long id);

    boolean updateByCarId(Long cardId, CarDto carDto) throws Exception;

    boolean deleteByCarId(Long id);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
