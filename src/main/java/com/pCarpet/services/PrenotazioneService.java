package com.pCarpet.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.dao.PrenotazioneRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;

@Service
public class PrenotazioneService {

	private PrenotazioneRepository prenotazioneRepository;

	
	@Autowired
	public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
		this.prenotazioneRepository = prenotazioneRepository;
	}

  
	
    public List<Prenotazione> getAllPrenotazioni () {
        return this.prenotazioneRepository.getAllPrenotazioni();
    }
    
    public Prenotazione getPrenotazione (int iduser, int idasset, String orainizio) {
        return this.prenotazioneRepository.getPrenotazione(iduser, idasset, orainizio);
    }
    

    public boolean insertPrenotazione(Prenotazione p) {
        return this.prenotazioneRepository.insertPrenotazione(p);
    }
    
    public boolean deleteUser(int iduser, int idasset, String orainizio) {
    	return this.prenotazioneRepository.deletePrenotazione(iduser, idasset, orainizio);
    }
   
    
    public boolean updatePrenotazione(HttpServletRequest request) {
    	return this.prenotazioneRepository.updatePrenotazione(request);
    }
    
    public List<Movimento> getAllUtilizzo(){
    	return this.prenotazioneRepository.getAllUtilizzo();
    }
	
}
