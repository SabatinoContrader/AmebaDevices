package com.AmebaDevices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.BuildingConverter;
import com.AmebaDevices.converter.FloorConverter;
import com.AmebaDevices.converter.ItemTypeConverter;
import com.AmebaDevices.converter.PrezzoConverter;
import com.AmebaDevices.dao.PrezzoDAO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.dto.PrezzoDTO;
import com.AmebaDevices.model.Building;

@Service
public class PrezzoService {
	private PrezzoDAO prezzoDao;
	@Autowired
	public PrezzoService(PrezzoDAO prezzoDao) {
		this.prezzoDao=prezzoDao;
	}
	
	public PrezzoDTO insert(PrezzoDTO f) {
		return PrezzoConverter.convertToDto(prezzoDao.save(PrezzoConverter.convertToFloor(f)));
	}
	

}
