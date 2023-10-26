package com.facisa.toavpr.aula.myApp.projeto08.tapProjeto08;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class TutorialController {
	
	@Autowired
	private TutorialService tutorialService;
	
	@GetMapping("/tutorial/{id}")
	public ResponseEntity<TutorialDTO> getTutorialById(@PathVariable long id) {

		try {
			TutorialDTO t = tutorialService.getById(id);
			return new ResponseEntity<>(t, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tutorial")
	public ResponseEntity<List<TutorialDTO>> getAllTutorial() {
		try {
			return new ResponseEntity<>(tutorialService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/car")
	public ResponseEntity<CarDTO> getCar() {

		try {
			Car car = new Car();
			car.setMake("dasda");
			car.setNumberOfSeats(30);
			CarDTO carDto = CarMapper.INSTANCE.carToCarDto(car);
			return new ResponseEntity<>(carDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/car2")
	public ResponseEntity<List<CarDTO>> getAllCars() {

		try {
			List<Car> cars = new ArrayList<Car>();
			Car car = new Car();
			car.setMake("dasda");
			car.setNumberOfSeats(30);
			cars.add(car);
			
			car = new Car();
			car.setMake("ffff");
			car.setNumberOfSeats(40);
			cars.add(car);
			
			car = new Car();
			car.setMake("tttt");
			car.setNumberOfSeats(50);
			cars.add(car);
			
			List<CarDTO> listsCarsDto = CarMapper.INSTANCE.listCarToListCarDTO(cars);
			return new ResponseEntity<>(listsCarsDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeFullNameDTO>> getEmployee() {

		try {
			
			List<Employee> listEmployee = new ArrayList<Employee>();
			
			Employee employee = new Employee();
			employee.setFirstName("Ruan");
			employee.setLastName("Oliveira");
			listEmployee.add(employee);
			
			employee = new Employee();
			employee.setFirstName("Pedro");
			employee.setLastName("Castro");
			listEmployee.add(employee);
			
			employee = new Employee();
			employee.setFirstName("Maria");
			employee.setLastName("Ribeiro");
			listEmployee.add(employee);
			
			List<EmployeeFullNameDTO> listEmployeeFullNameDTO = EmployeeFullNameMapper.INSTANCE.map(listEmployee);
			return new ResponseEntity<>(listEmployeeFullNameDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
