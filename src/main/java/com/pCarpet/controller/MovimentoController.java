package com.pCarpet.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import com.pCarpet.model.Movimento;
import com.pCarpet.model.User;
import com.pCarpet.services.AssegnazioneService;
import com.pCarpet.services.AssetService;
import com.pCarpet.services.BadgeService;
import com.pCarpet.services.MovimentoService;
import com.pCarpet.services.PrenotazioneService;
import com.pCarpet.services.UserService;

@Controller
@RequestMapping("/Movimento")

public class MovimentoController{
	
	private MovimentoService movimentoService;
	private String message;
	private AssetService assetService;
	private WritableFont wfont;
	private WritableFont wc;
	private List<User> allUsers;
	private WritableCellFormat wcfFC;
	private WritableCellFormat wC;
	private UserService userService;
	private PrenotazioneService prenotazioneService;
	
	@Autowired
	public MovimentoController(UserService userService, MovimentoService movimentoService, PrenotazioneService prenotazioneService) {
		this.userService = userService;
		this.movimentoService= movimentoService;
		this.prenotazioneService= prenotazioneService;
	
	}

	@RequestMapping(value = "/homeMovimento", method = RequestMethod.GET)
	public String Logs(HttpServletRequest request) {
		String scelta= request.getParameter("scelta");
		if (scelta.equals("movimentoManagement")) {
        	request.setAttribute("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
        	return "homeMovimenti";
		}
		else if(scelta.equals("export"))
				{
			this.allUsers = this.userService.getAllUsers();
			request.setAttribute("visualizzaUsers", allUsers);
            	return "logsExportHome";
    }return "";
        	
	}
	@RequestMapping(value = "/homeMovimento", method = RequestMethod.POST)
	public String LogsExp(HttpServletRequest request)
	{
		String scelta= request.getParameter("richiesta");
		if (scelta.equals("exportdue")) {
			if (writeOnExcel(request)) 
        	{
        		this.message = "Export avvenuto correttamente";
        	}
        	else {
        		this.message = "Errore durante la procedura di export";
        	}
		}
		else if(scelta.equals("export"))
		{
	this.allUsers = this.userService.getAllUsers();
	request.setAttribute("visualizzaUsers", allUsers);
    	return "logsExportHome";
		}
		else if(scelta.equals("indietroHome"))
			return "homeLogs";
		this.allUsers = this.userService.getAllUsers();
		request.setAttribute("visualizzaUsers", allUsers);
		return "logsExportHome";
		}
	
	public boolean writeOnExcel(HttpServletRequest request) {
    	String par=request.getParameter("dir").toString();
    	String storico=request.getParameter("name").toString();
    	File f=new File(par+"\\"+storico+".xls");
    	String iduser = request.getParameter("scelta").toString();
    	
		
		try {
	    	wfont = new WritableFont(WritableFont.createFont("Arial"), 12, WritableFont.BOLD, true,
	        UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
	    	wc = new WritableFont(WritableFont.createFont("Arial"), 10, WritableFont.NO_BOLD, false,
	    	UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
	    
	        wcfFC = new WritableCellFormat(wfont);
	        wC = new WritableCellFormat(wc);
	   	 	wC.setAlignment(Alignment.CENTRE);
	        wcfFC.setAlignment(Alignment.CENTRE);
	        
	        
			WritableWorkbook myexel = Workbook.createWorkbook(f);
			
			
			
			
			
			if (iduser.equalsIgnoreCase("")) {
				
				WritableSheet mysheet = myexel.createSheet("Utilizzo", 0);
    			WritableSheet mysheetP = myexel.createSheet("Prenotazione", 1);
    			
    			mysheet.setColumnView(0, 25);
    			mysheet.setColumnView(1,15);
    			mysheet.setColumnView(2, 20);
    			mysheet.setColumnView(3,20);
    			Label l=null;
    			Label l2=null;
    			Label l3=null;
    			Label l4=null;
    			
    			mysheetP.setColumnView(0, 25);
    			mysheetP.setColumnView(1,15);
    			mysheetP.setColumnView(2, 20);
    			mysheetP.setColumnView(3,20);
    			
    			
    			
    			mysheet.addCell(new Label(0,0,"ID Badge Reader",wcfFC));
    			mysheet.addCell(new Label(1,0,"ID Badge",wcfFC));
    			mysheet.addCell(new Label(2,0,"Ora Inizio",wcfFC));
    			mysheet.addCell(new Label(3,0,"Ora Fine",wcfFC));
    			
    			mysheetP.addCell(new Label(0,0,"ID User",wcfFC));
    			mysheetP.addCell(new Label(1,0,"ID Asset",wcfFC));
    			mysheetP.addCell(new Label(2,0,"Ora Inizio",wcfFC));
    			mysheetP.addCell(new Label(3,0,"Ora Fine",wcfFC));
				
				
			for(int i=1; i<=movimentoService.getAllMovimenti().size(); i++) {
				for(int j=0; j<4; j++) {
					l=new Label(0,i, String.valueOf(movimentoService.getAllMovimenti().get(i-1).getIdbadgereader()),wC );
					l2=new Label(1,i, String.valueOf(movimentoService.getAllMovimenti().get(i-1).getIdbadge()),wC );
					l3=new Label(2,i, movimentoService.getAllMovimenti().get(i-1).getOrainizio(),wC);
					l4=new Label(3,i,movimentoService.getAllMovimenti().get(i-1).getOrafine(),wC);
					mysheet.addCell(l);
					mysheet.addCell(l2);
					mysheet.addCell(l3);
					mysheet.addCell(l4);
				}}
					for(int x=1; x<=prenotazioneService.getAllPrenotazioni().size(); x++) {
						for(int k=0; k<4; k++) {					
					l=new Label(0,x, String.valueOf(prenotazioneService.getAllPrenotazioni().get(x-1).getIduser()),wC );
					l2=new Label(1,x, String.valueOf(prenotazioneService.getAllPrenotazioni().get(x-1).getIdasset()),wC );
					l3=new Label(2,x, prenotazioneService.getAllPrenotazioni().get(x-1).getOrainizio(),wC);
					l4=new Label(3,x, prenotazioneService.getAllPrenotazioni().get(x-1).getOrafine(),wC);
					
					mysheetP.addCell(l);
					mysheetP.addCell(l2);
					mysheetP.addCell(l3);
					mysheetP.addCell(l4);
				}
			}
			}else if (! iduser.equalsIgnoreCase("")) {
				
				WritableSheet mysheet = myexel.createSheet("Utilizzo", 0);
    			
    			mysheet.setColumnView(0, 25);
    			mysheet.setColumnView(1,15);
    			mysheet.setColumnView(2, 20);
    			mysheet.setColumnView(3,20);
    			Label l=null;
    			Label l2=null;
    			Label l3=null;
    			Label l4=null;
    			
    			
    			
    			mysheet.addCell(new Label(0,0,"ID Badge Reader",wcfFC));
    			mysheet.addCell(new Label(1,0,"ID Badge",wcfFC));
    			mysheet.addCell(new Label(2,0,"Ora Inizio",wcfFC));
    			mysheet.addCell(new Label(3,0,"Ora Fine",wcfFC));
				
				for(int i=1; i<=movimentoService.getAllUserMovimenti(iduser).size(); i++) {
					for(int j=0; j<4; j++) {
						l=new Label(0,i, String.valueOf(movimentoService.getAllUserMovimenti(iduser).get(i-1).getIdbadgereader()),wC );
						l2=new Label(1,i, String.valueOf(movimentoService.getAllUserMovimenti(iduser).get(i-1).getIdbadge()),wC );
						l3=new Label(2,i, movimentoService.getAllUserMovimenti(iduser).get(i-1).getOrainizio(),wC);
						l4=new Label(3,i, movimentoService.getAllUserMovimenti(iduser).get(i-1).getOrafine(),wC);
						mysheet.addCell(l);
						mysheet.addCell(l2);
						mysheet.addCell(l3);
						mysheet.addCell(l4);
						
					}
				}
			
			}
			myexel.write();	
			myexel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		return true;
    
}
}