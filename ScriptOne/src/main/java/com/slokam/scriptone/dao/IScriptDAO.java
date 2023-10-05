package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Script;


@Repository
public interface IScriptDAO extends JpaRepository<Script, Long>{

	
}
