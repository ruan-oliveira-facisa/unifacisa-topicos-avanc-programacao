package com.facisa.toavpr.aula.myApp.projeto08.tapProjeto08;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
	
	CarMapper INSTANCE = Mappers.getMapper(CarMapper.class); 
	 
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car);
    
    List<CarDTO> listCarToListCarDTO(List<Car> cars);

}
