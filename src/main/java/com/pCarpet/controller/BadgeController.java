package com.pCarpet.controller;

import com.pCarpet.model.Badge;
import com.pCarpet.services.BadgeService;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
@RequestMapping("/Badge")
public class BadgeController {

	private BadgeService badgeService;
    private List<Badge> listBadges;
	private  Badge l;
	private List<Badge> x;
 

	
	@Autowired
	public BadgeController(BadgeService badgeService) {
		this.badgeService = badgeService;
	}
	
	@RequestMapping(value = "/HomeBadge", method = RequestMethod.GET)
	public String getBadges(HttpServletRequest request, Model model ) {
		List<Badge> badges = badgeService.getAllBadges();
		model.addAttribute("badges", badges);

		String scelta= request.getParameter("scelta");
		
		if(scelta != null) {
			switch(scelta) {
			case "badgemanagement":
				return "badgeManagement";
			case "insert":
//				users = userService.getAllUsers();
//				model.addAttribute("users", users);
				return "addBadge";
				
			case "update":
				//model.addAttribute("badge",badgeService.getBadge(Integer.parseInt(request.getParameter("idbadge"))));
//				users = userService.getAllUsers();
//				model.addAttribute("users", users);
				return "modificaBadge";
			case "delete":
				
				badgeService.deleteBadge(Integer.parseInt((request.getParameter("id"))));
				badges = badgeService.getAllBadges();
				model.addAttribute("badges", badges);
				return "badgeManagement";
			case "indietro":
				return "homeCustomers";
			case "indietrobadgemanagement":
				return "badgeManagement";
		}
	}
	
	return "badgeManagement";
}


	@RequestMapping(value = "/removeBadge", method = RequestMethod.GET)
	public String removeBadge(@RequestParam("id") int idbadge, Model model ) {
		Badge badge = badgeService.getBadge(idbadge);
		return "badgeManagement";}
	
	@RequestMapping(value ="/modificaBadgeRedirect",method = RequestMethod.GET)
	public String modifiedredirectBadge(HttpServletRequest request, Model model )
	{
		int id=Integer.parseInt(request.getParameter("id"));
		
		l = badgeService.getBadge(id);
		request.setAttribute("id1", id);
		model.addAttribute("badge", l);
		return "modificaBadge";
	}
	
	@RequestMapping(value = "/addBadge", method = RequestMethod.POST)
	public String addedBadge(HttpServletRequest request, Model model ) {
		
		//int idbadge = Integer.parseInt(request.getParameter("idbadge").toString());
		String descrizione = request.getParameter("descrizione");
		String tipologia = request.getParameter("tipologia");
		
		Badge badge = new Badge(0, descrizione, tipologia);
		badge.setIdBadge(0);
		badge.setDescrizione(descrizione);
		badge.setTipologia(tipologia);
		badgeService.insertBadge(badge);
		List<Badge> badges = badgeService.getAllBadges();
		model.addAttribute("badges", badges);
		//request.setAttribute("badges", badgeService.getAllBadge(badge));
		return "badgeManagement";
	}

@RequestMapping(value = "/modificaBadge", method = RequestMethod.POST)
public String modifiedBadge(HttpServletRequest request, Model model ) {
	
    this.badgeService.updateBadge(request);
    List<Badge> badges = badgeService.getAllBadges();
	model.addAttribute("badges", badges);
	
	return "badgeManagement";
 }
}
