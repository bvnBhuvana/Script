package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Scene;



@Repository
public interface ISceneDAO extends JpaRepository<Scene, Long>{

}
