package com.pCarpet.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.model.Movimento;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;
import com.pCarpet.services.PrenotazioneService;

@Controller
@RequestMapping("/HomePrenotazione")
public class PrenotazioneController {
	
	private PrenotazioneService prenotazioneService;
	
	private boolean isLogged = false;
	
	private Prenotazione p=null;

	@Autowired
	public PrenotazioneController(PrenotazioneService prenotazioneService) {
		this.prenotazioneService = prenotazioneService;
	}

	@RequestMapping(value = "/showPrenotazione", method = RequestMethod.GET)
	public String loginControl(HttpServletRequest request, Model model ) {
		
		List<Prenotazione> listPrenotazione;
				
		String choice=request.getParameter("choice");
		
		if(choice != null) {
			switch(choice) {
		
				case "managementPrenotazioni":
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					
					return "insertBookings";
				
				case "insert":
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					return "insertBookings";
					
				case "update":
					//model.addAttribute("user",userService.getUser(Integer.parseInt(request.getParameter("id"))));
					int iduser=Integer.parseInt(request.getParameter("idU"));
					int idasset=Integer.parseInt(request.getParameter("idA"));
					String orainizio=request.getParameter("idO");
					
					p=prenotazioneService.getPrenotazione(iduser, idasset, orainizio);
					//prenotazioneService.updatePrenotazione(request);
					model.addAttribute("p",p);
					return "updateBookings";
					
				case "indietro":
					return "homeSegretaria";
					
				case "indietroManagementBookings":
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);
					return "homeSegretaria";
			}
		}
		
		return "insertBookings";
	}
	
	
	@RequestMapping(value = "/showPrenotazione", method = RequestMethod.POST)
	public String loginControlPost(HttpServletRequest request, Model model ) {
		
		List<Prenotazione> listPrenotazione = prenotazioneService.getAllPrenotazioni();
		listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
		model.addAttribute("listPrenotazione", listPrenotazione);
			
		String choice=request.getParameter("choice");
	
		if(choice != null) {
			switch(choice) {
				case "insert":
					
					int iduser=Integer.parseInt(request.getParameter("iduser"));
					
					int idasset=Integer.parseInt(request.getParameter("idasset"));
					
					String oldOrainizio=request.getParameter("orainizio");
					
					String oldOrafine=request.getParameter("orafine");
					
					String orainizio=formatData(oldOrainizio);
					String orafine=formatData(oldOrafine);
					
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					boolean corretto=true;
					
					
					if(orafine.compareTo(orainizio)<=0) {
						System.out.println("if1");
						corretto=false;
					}
					
					
					if( orainizio.compareTo(formatDataNow(LocalDateTime.now().toString()))<0) {
						System.out.println("if2");
						corretto=false;
					}
					
					
					for(Movimento u: prenotazioneService.getAllUtilizzo()){
						if ( u.getIdbadgereader()==idasset && u.getOrafine().equals("0000-00-00 00:00:00") ) {
							System.out.println("if3");
							corretto=false;
						}
					}
					
					
					
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					for(Prenotazione p: listPrenotazione) {
						
						if( idasset==p.getIdasset() ) {
							
							String prenotazioneOrainizio = formatDataPoint(p.getOrainizio());
							String prenotazioneOrafine = formatDataPoint(p.getOrafine());
							if( (orainizio.compareTo(prenotazioneOrainizio)>=0 && orainizio.compareTo(prenotazioneOrafine)<0) ||
							    (orafine.compareTo(prenotazioneOrainizio)>0 && orafine.compareTo(prenotazioneOrafine)<=0) ) {
								System.out.println("orainizio:"+orainizio);
								System.out.println("orafine:"+orafine);
								System.out.println("prenotazioneOrainizio:"+prenotazioneOrainizio);
								System.out.println("prenotazioneOrafine:"+prenotazioneOrafine);
								System.out.println("if4");
								corretto=false;
							}
							
							if( orainizio.compareTo(prenotazioneOrainizio)<=0 && orafine.compareTo(prenotazioneOrafine)>=0 ) {
								System.out.println("if5");
								corretto=false;
								
							}
							
						}
						
					}
					
					if(corretto) {
						Prenotazione p=new Prenotazione(iduser,idasset,orainizio,orafine);
						prenotazioneService.insertPrenotazione(p);
						model.addAttribute("feedback", "success");
					}else {
						model.addAttribute("feedback", "wrong");
					}
					
					
					
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					model.addAttribute("listPrenotazione", listPrenotazione);

					
					return "insertBookings";
					
				case "update":
					
					
					String s=formatData(request.getParameter("nuovoCampo"));
					request.setAttribute("nuovoCampo2", s);
					
					
					iduser=Integer.parseInt(request.getParameter("id1"));
					idasset=Integer.parseInt(request.getParameter("id2"));
					
					
					if(request.getParameter("campo").equals("orainizio")) {
						
						orainizio=s;
						orafine=request.getParameter("orafine");
						
					}else {
						orainizio=request.getParameter("id3");
						orafine=s;
						
					}
					

					
				
					
					
					
					listPrenotazione = prenotazioneService.getAllPrenotazioni();
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					corretto=true;
					
					
					if(orafine.compareTo(orainizio)<=0) {
						System.out.println("orafine minore di orainizio");
						corretto=false;
					}
					
					
					if( orainizio.compareTo(formatDataNow(LocalDateTime.now().toString()))<0) {
						System.out.println("ora inizio minore di now");
						corretto=false;
					}
					
					
					for(Movimento u: prenotazioneService.getAllUtilizzo()){
						if ( u.getIdbadgereader()==idasset && u.getOrafine().equals("0000-00-00 00:00:00") ) {
							System.out.println("ENTRATO IN 0000-00-00");
							corretto=false;
						}
					}
					
					
					
					listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
					
					int cont1=0;
					int cont2=0;
					
					for(Prenotazione p: listPrenotazione) {
						
						if( idasset==p.getIdasset() ) {
							
							String prenotazioneOrainizio = formatDataPoint(p.getOrainizio());
							String prenotazioneOrafine = formatDataPoint(p.getOrafine());
							
							if( (orainizio.compareTo(prenotazioneOrainizio)>=0 && orainizio.compareTo(prenotazioneOrafine)<0) ||
							    (orafine.compareTo(prenotazioneOrainizio)>0 && orafine.compareTo(prenotazioneOrafine)<=0) ) {
								System.out.println("prenotazione già presente 1");
								cont1++;
								
							}
							
							if( orainizio.compareTo(prenotazioneOrainizio)<=0 && orafine.compareTo(prenotazioneOrafine)>=0 ) {
								System.out.println("prenotazione già presente 2");
								cont2++;
								
								
							}
							
						}
						
					}
					
					if(cont1>1)
						corretto=false;
					if(cont2>2)
						corretto=false;
					
					if(corretto) {
						prenotazioneService.updatePrenotazione(request);
						
						orainizio=request.getParameter("id3");
						
						Prenotazione p= prenotazioneService.getPrenotazione(iduser, idasset, orainizio);
						
						listPrenotazione = prenotazioneService.getAllPrenotazioni();
						listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
						model.addAttribute("listPrenotazione", listPrenotazione);
						
						model.addAttribute("p", p);
						model.addAttribute("feedback", "success");
						return "insertBookings";
						
					}else {
						
						
						listPrenotazione = prenotazioneService.getAllPrenotazioni();
						listPrenotazione = aggiornaPrenotazioni(listPrenotazione);
						model.addAttribute("listPrenotazione", listPrenotazione);
						
						model.addAttribute("feedback", "wrong");
						return "insertBookings";
					}
					
					
					
					
					
					
					
				
					
			}
		}
	
		return "homeBookings";
		
	}
	
	
	
	//OLD DATE
	//datetime-local --> gg/mm/yyyy hh.mm (es. 29/09/2018 10.29)
	//NEW DATE
	//String --> yyyy-mm-gg hh:mm:ss (es. 2018-09-29 10:29:00)
	public String formatData(String oldDate) {
		
		StringTokenizer st=new StringTokenizer(oldDate,"/.-T: ");
		String newDate="";
		
		int index=0;
		
		while(st.hasMoreTokens()) {
			index += 1;
			String tk=st.nextToken();
			if(tk.length()>=3 && tk.charAt(2)==('.')) {
				String temp=tk.substring(0, 1);
				tk=temp+tk.substring(1,2);
				newDate+=tk;
				break;
			}
			if(index<3) {
				newDate+=tk;
				newDate+="-";
			}
			else if(index==3) {
				newDate+=tk;
				newDate+=" ";
			}
			else if(index<5) {//index<6 se nella data ci sono anche i secondi
				newDate+=tk;
				newDate+=":";
			}else {
				newDate+=tk;
			}//if
			
		}//while
		
		newDate+=":00";
		
		return newDate;
		
		
	}//formatData
	
	
	
	//OLD DATE
	//LocalDateTime --> yyyy-mm-ggThh:mm:ss.mls (es. 2018-09-29T10:29:51.025) CAMBIA L'ULTIMO ELSE IF
	//NEW DATE
	//String --> yyyy-mm-gg hh:mm:ss (es. 2018-09-29 10:29:00)
	public String formatDataNow(String oldDate) {
		
		
		StringTokenizer st2=new StringTokenizer(LocalDateTime.now().toString(),"/.-T: ");
		String newDate="";
		
		int ind=0;
		
		while(st2.hasMoreTokens()) {
			ind += 1;
			String tk=st2.nextToken();
			if(ind==6) {
				newDate+="00";
				break;
			}
			if(ind<3) {
				newDate+=tk;
				newDate+="-";
			}
			else if(ind==3) {
				newDate+=tk;
				newDate+=" ";
			}
			else if(ind<6) {
				newDate+=tk;
				newDate+=":";
			}else {
				newDate+=tk;
			}//if
			
		}//while
		
		return newDate;
		
	}//formatDataNow
	
	
	
public String formatDataPoint(String oldDate) {
		
		
		StringTokenizer st2=new StringTokenizer(LocalDateTime.now().toString(),".");
		String newDate="";
		
		int ind=0;
		
		while(st2.hasMoreTokens()) {
			newDate+=st2.nextToken();
			break;
			
			
		}//while
		
		return newDate;
		
	}//formatDataPoint
	
	
	public List<Prenotazione> aggiornaPrenotazioni(List<Prenotazione> listPrenotazione){
		List<Prenotazione> pAll = new LinkedList<>();
		
		for(Prenotazione p: listPrenotazione) {
			
			if( p.getOrafine().compareTo(formatDataNow(LocalDateTime.now().toString()))>=0 ){
				pAll.add(p);
			}
			
		}
		
	
		listPrenotazione=new LinkedList<>();
		
		listPrenotazione.addAll(pAll);
		
		return listPrenotazione;
	}
	
}
