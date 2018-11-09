package com.AmebaDevices.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.dto.ListinoDTO;
import com.AmebaDevices.model.Listino;

@Repository
public interface ListinoDAO extends CrudRepository<Listino, Long> {
	public Listino findByNomeListino(String nomeListino);

}
