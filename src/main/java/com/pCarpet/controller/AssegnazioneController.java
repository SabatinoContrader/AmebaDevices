package com.pCarpet.controller;


import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;
import com.pCarpet.services.AssegnazioneService;
import com.pCarpet.services.BadgeService;
import com.pCarpet.services.UserService;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Assegnazione")
public class AssegnazioneController {
    private AssegnazioneService assegnazioneService;
    private BadgeService badgeService;
    private UserService userService;
    private List<User> listUsers;
    private List<Badge> listBadges;
    private List<Assegnazione> listAssegnazioni;

	

	@Autowired
	public AssegnazioneController(UserService userService) {
		this.userService = userService;
		this.assegnazioneService= new AssegnazioneService();
		this.badgeService = new BadgeService();
	}

	
	
	@RequestMapping(value = "/homeAssegnazione", method = RequestMethod.GET)
	public String AsseBad(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		
		if (scelta.equals("assegnazioneManagement")) {
			this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
    	this.listUsers = this.userService.getAllUsers();
    	this.listBadges = this.badgeService.getAllBadgesN();
        request.setAttribute("visualAssegnazioni", listAssegnazioni);
        request.setAttribute("visualUsers", listUsers);
        request.setAttribute("visualBadges", listBadges);
			return "homeAssegnazione";}
		else if (scelta.equals("indietro"))
			return "homeCustomers";
		else if (scelta.equals("rimuovi"))
		{
			int id3=Integer.parseInt(request.getParameter("idUser"));
        	request.setAttribute("id1", id3);
        	int id4=Integer.parseInt(request.getParameter("idBadge"));
        	request.setAttribute("id2", id4);
        	
        	this.assegnazioneService.deleteAssegnazione(id3,id4);
        	
        	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
        	this.listUsers = this.userService.getAllUsers();
        	this.listBadges = this.badgeService.getAllBadgesN();
            request.setAttribute("visualAssegnazioni", listAssegnazioni);
            request.setAttribute("visualUsers", listUsers);
            request.setAttribute("visualBadges", listBadges);
            return "homeAssegnazione";
		}
		else
			return "";
	}
	
	@RequestMapping(value = "/homeAssegnazione", method = RequestMethod.POST)
	public String Asse(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		if (scelta.equals("insert")) {
			int id1=Integer.parseInt(request.getParameter("user"));
        	request.setAttribute("id1", id1);
        	int id2=Integer.parseInt(request.getParameter("badge"));
        	request.setAttribute("id2", id2);
        	request.setAttribute("id", this.assegnazioneService.assegnaBadge(new Assegnazione(id1,id2,LocalDate.now().toString())));
        	this.listAssegnazioni = this.assegnazioneService.getAllAssegnazioni();
        	this.listUsers = this.userService.getAllUsers();
        	this.listBadges = this.badgeService.getAllBadgesN();
            request.setAttribute("visualAssegnazioni", listAssegnazioni);
            request.setAttribute("visualUsers", listUsers);
            request.setAttribute("visualBadges", listBadges);
        	return "homeAssegnazione";
	}
		return "";
}}