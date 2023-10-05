package com.slokam.scriptone.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.scriptone.dao.IScriptDAO;
import com.slokam.scriptone.dto.ScriptDTO;
import com.slokam.scriptone.entity.Script;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.UserInputException;
import com.slokam.scriptone.service.IScriptService;

@Service

public class ScriptServiceImpl implements IScriptService {

	@Autowired
	private IScriptDAO scriptdao;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public ScriptDTO savescript(ScriptDTO scriptdTO) throws  Exception {

		if(scriptdTO == null || scriptdTO.getName() == null || scriptdTO.getName().trim().length()==0 )
			
			throw new UserInputException("There is no data found in scriptdto");

	
		Script script = modelmapper.map(scriptdTO, Script.class);
		
		if(script == null )
			throw new ApplicationException("There is no data found in script");
		
		scriptdao.save(script);
		
		scriptdTO.setId(script.getId());
		return scriptdTO;
	}

	@Override
	public ScriptDTO getbyId(Long id) {
		
	Optional<Script> scriptopt =	scriptdao.findById(id);
	ScriptDTO scriptdto = null;
	if(scriptopt.isPresent())
	{
		Script script = scriptopt.get();
		scriptdto =	modelmapper.map(script, ScriptDTO.class);
		
	}
		return scriptdto;
	}

	@Override
	public List<ScriptDTO> getall() {
		
		List<Script> listScript = scriptdao.findAll();
		List<ScriptDTO> listScriptDto = new ArrayList<>();
		
		for(Script script : listScript)
		{
		 ScriptDTO scriptdto =	modelmapper.map(script, ScriptDTO.class);
		 listScriptDto.add(scriptdto);
			
		}
		return listScriptDto;
	}

	@Override
	public ScriptDTO deletebyId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
