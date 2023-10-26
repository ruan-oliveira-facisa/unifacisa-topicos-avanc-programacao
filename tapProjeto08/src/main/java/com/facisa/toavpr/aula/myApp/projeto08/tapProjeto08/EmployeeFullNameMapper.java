package com.facisa.toavpr.aula.myApp.projeto08.tapProjeto08;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeFullNameMapper {

	EmployeeFullNameMapper INSTANCE = Mappers.getMapper(EmployeeFullNameMapper.class);

	List<EmployeeFullNameDTO> map(List<Employee> employees);
	
	//Set<EmployeeDTO> map(Set<Employee> employees);
	// Map<String, EmployeeDTO> map(Map<String, Employee> idEmployeeMap);

	default EmployeeFullNameDTO map(Employee employee) {
		EmployeeFullNameDTO employeeInfoDTO = new EmployeeFullNameDTO();
		employeeInfoDTO.setFullName(employee.getFirstName() + " " + employee.getLastName());

		return employeeInfoDTO;
	}

}
