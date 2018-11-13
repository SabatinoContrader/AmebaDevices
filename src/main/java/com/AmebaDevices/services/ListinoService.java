package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.ListinoConverter;
import com.AmebaDevices.dao.ListinoDAO;
import com.AmebaDevices.dto.ListinoDTO;
import com.AmebaDevices.model.Listino;

@Service
public class ListinoService {
	
	private ListinoDAO listinoDAO;
	@Autowired
	public ListinoService (ListinoDAO listinoDAO) {
		this.listinoDAO = listinoDAO;
	}
	
	public ListinoDTO insert(ListinoDTO listinoDTO) { 		// ListinoDTO1 è il return al Controller, ListinoDTO2 è quello che il controller passa
		Listino listino = ListinoConverter.convertToListino(listinoDTO);
		listinoDAO.save(listino);
		return ListinoConverter.convertToDTO(listinoDAO.save(listino));
	}
	
	public ListinoDTO edit(ListinoDTO listinoDTO) {
		Listino listino = ListinoConverter.convertToListino(listinoDTO);
		listinoDAO.save(listino);
		return ListinoConverter.convertToDTO(listinoDAO.save(listino));
	}
	
	public ListinoDTO findByNomeListino(String nomeListino) {
		return ListinoConverter.convertToDTO(listinoDAO.findByNomeListino(nomeListino));
	}
	
	public List<ListinoDTO> readAll(){
		List<Listino> listini = (List<Listino>) listinoDAO.findAll();
		List<ListinoDTO> listiniDTO = new ArrayList<>();
		listini.forEach(l -> listiniDTO.add(ListinoConverter.convertToDTO(l)));
		return listiniDTO;
	}
	
	public ListinoDTO findById(long idListino) {
		ListinoDTO listino= ListinoConverter.convertToDTO(listinoDAO.findOne(idListino));
		return listino;
	}
	
	public void delete(Listino listino) {
		listinoDAO.delete(listino);
	}


}
