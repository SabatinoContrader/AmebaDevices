package com.pCarpet.services;

import com.pCarpet.dao.UserRepository;
import com.pCarpet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

	@Service
	public class UserService {

    private UserRepository userRepository;
    //private UserAssetDAO userAssetDAO;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login (String username, String password) {
    	return this.userRepository.login(username, password);
    }

    public List<User> getAllUsers () {
        return this.userRepository.getAllUsers();
    }
    
    public User getLoggedUser (String username, String password) {
        return this.userRepository.getLoggedUser(username, password);
    }
    
    public User getUser (int id) {
        return this.userRepository.getUser(id);
    }
    /*
    public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }
    */

    public boolean insertUser (User user) {
        return this.userRepository.insertUser(user);
    }
    
    public boolean deleteUser(int idUser) {
    	return this.userRepository.deleteUser(idUser);
    }
    
    /*
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    */
    
    public boolean updateUser(HttpServletRequest request) {
    	return this.userRepository.updateUser(request);
    }
}
