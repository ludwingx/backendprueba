package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import posCarRental.dto.BookACarDto;
import posCarRental.dto.CarDtoListDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.entity.BookACar;
import posCarRental.entity.Car;
import posCarRental.entity.User;
import posCarRental.entity.enums.BookCarStatus;
import posCarRental.repository.IBookACarRepository;
import posCarRental.repository.ICarRepository;
import posCarRental.repository.IUserRepository;
import posCarRental.service.IBookACarService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class BookACarServiceImpl implements IBookACarService {

    @Autowired
    private ICarRepository carRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBookACarRepository bookACarRepository;

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookACarDto.getCarId());
        Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());
        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Car existingCar = optionalCar.get();
            BookACar bookACar = new BookACar();
            bookACar.setUser(optionalUser.get());
            bookACar.setCar(existingCar);
            bookACar.setBookCarStatus(BookCarStatus.PENDING);
            long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
            long days = TimeUnit.MICROSECONDS.toDays(diffInMilliSeconds);
            bookACar.setDays(days);
            bookACar.setPrice(existingCar.getPrice() * days);
            bookACarRepository.save(bookACar);
            return true;
        }
        return false;
    }

    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    @Override
    public List<BookACarDto> findAllBookings() {
        return bookACarRepository.findAll().stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    @Override
    public boolean changeBookingStatus(Long bookingId, String status) {
        Optional<BookACar> optionalBookACar = bookACarRepository.findById(bookingId);
        if (optionalBookACar.isPresent()) {
            BookACar existinBookACar = optionalBookACar.get();
            if (Objects.equals(status, "APPROVE") ) {
                existinBookACar.setBookCarStatus(BookCarStatus.APPROVED);
            }else {
                existinBookACar.setBookCarStatus(BookCarStatus.REJECTED);
            }
            bookACarRepository.save(existinBookACar);
            return true;
        }
        return false;
    }

}
