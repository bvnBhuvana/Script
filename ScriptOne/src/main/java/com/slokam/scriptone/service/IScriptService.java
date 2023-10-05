package com.slokam.scriptone.service;


import java.util.List;

import com.slokam.scriptone.dto.ScriptDTO;
import com.slokam.scriptone.exception.UserInputException;

public interface IScriptService {

	public ScriptDTO savescript(ScriptDTO scriptdTO) throws UserInputException, Exception;
	
	public ScriptDTO getbyId(Long id);
	
	public List<ScriptDTO> getall();
	
	public ScriptDTO deletebyId();


}
