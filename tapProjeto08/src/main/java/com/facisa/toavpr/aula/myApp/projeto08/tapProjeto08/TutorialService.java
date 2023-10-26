package com.facisa.toavpr.aula.myApp.projeto08.tapProjeto08;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TutorialDTO getById(long id){
//		ModelMapper modelMapper = new ModelMapper();
//		TypeMap<Tutorial, TutorialDTO> typeMap = modelMapper.createTypeMap(Tutorial.class, 
//				TutorialDTO.class);
//		typeMap.addMappings(mapper -> {
//		    mapper.map(src -> src.getType(), 
//		    		TutorialDTO::setTipo);
//		});
		return modelMapper.map(this.tutorialRepository.getReferenceById(id), 
				TutorialDTO.class);

	}
	
	//https://stackoverflow.com/questions/47929674/modelmapper-mapping-list-of-entites-to-list-of-dto-objects
	
	
	public List<TutorialDTO> getAll(){
		
		Type listType = new TypeToken<List<TutorialDTO>>(){}.getType();
		List<TutorialDTO> tutorialDtoList = modelMapper.map(this.tutorialRepository.
				findAll(),listType);
		
		//List<TutorialDTO> tutorialDtoList2 = Arrays.asList
		//(modelMapper.map(this.tutorialRepository.findAll(), TutorialDTO[].class));
		
		return tutorialDtoList;

	}

}
