package com.pCarpet.services;


import com.pCarpet.dao.AssegnaRepository;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.User;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssegnazioneService {

	private UserRepository userRepository;
    //private UserAssetDAO userAssetDAO;
    private AssegnaRepository assegnaRepository;
@Autowired
    public AssegnazioneService() {
        this.assegnaRepository = new AssegnaRepository();
    }

    
    public List<Assegnazione> getAllAssegnazioni () {
        return this.assegnaRepository.getAllAssegnazioni();
    }
//    public List<User> getAllClienti () {
//        return this.userDAO.getAllClienti();
//    }
//    
//    public List<User> getAllClientiAss(){
//    	return this.userDAO.getAllClientiAss();
//    }
    public boolean assegnaBadge(Assegnazione assegnazione)
    {
    	return this.assegnaRepository.assegnaBadge(assegnazione);
    }
//    public boolean insertUser (User user) {
//        return this.userDAO.insertUser(user);
//    }
//    
    public boolean deleteAssegnazione(int iduser,int idbadge) {
    	return this.assegnaRepository.deleteAssegnazione(iduser, idbadge);
    }
//    
//    public List<User> getAllUsersN(){
//    	return this.userAssetDAO.getAllUsersN();
//    }
//    
//    public boolean updateUser(Request request) {
//    	return this.userDAO.udpateUser(request);
//    }
}


