package com.AmebaDevices.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.FloorService;




@Controller
@RequestMapping("/Floors")
public class FloorController {
	
	
	private void processRequest(String filePath, HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		        try {
		            response.setContentType("text/html;charset=UTF-8");
		            File file = new File(filePath);
		            FileInputStream inputStream = new FileInputStream(file);
		            ServletContext context = request.getServletContext();
		            String mimeType = context.getMimeType(filePath);
		            if (mimeType == null) {
		                mimeType = "application/octet-stream";
		            }
		            response.setContentType(mimeType);
		            response.setContentLength((int) file.length());
		            // forziamo il download del file
		            String headerKey = "Content-Disposition";
		            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
		            response.setHeader(headerKey, headerValue);
		            OutputStream outputStream = response.getOutputStream();
		            byte[] buffer = new byte[4096];
		            int bytesRead = -1;
		            while ((bytesRead = inputStream.read(buffer)) != -1) {
		                outputStream.write(buffer, 0, bytesRead);
		            }
		            inputStream.close();
		            outputStream.close();
		        } catch (Exception e) {
		            //gestiamo eventuali errori come file non esistente
		        }
		    }


	@Autowired
	public FloorController() {
	}

	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		return "newFloor";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		String name = request.getParameter("floorName");
		String description = request.getParameter("floorDescription");
		String bid = (String) request.getAttribute("buildingId");
		FloorService newFloorService = new FloorService();
		Floor f = new Floor();
		f.setNomeFloor(name);
		f.setDescrizione(description);
		f.setIdBuilding(bid);
		newFloorService.insertFloor(f);
		return "floorManager";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		FloorService fs = new FloorService();
		List<Floor> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "floorManager";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		FloorService fs = new FloorService();
		List<Floor> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "updateFloor";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String newName = request.getParameter("floorName");
		String newDescription = request.getParameter("floorDescription");
		String buildingid = (String) request.getAttribute("buildingId");
		String floorId = request.getParameter("floorid");
		Floor newFloor = new Floor();
		FloorService fs = new FloorService();
		newFloor.setId(floorId);
		newFloor.setNomeFloor(newName);
		newFloor.setDescrizione(newDescription);
		newFloor.setIdBuilding(buildingid);
		fs.update(newFloor);
		return "floorManager";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		FloorService fs = new FloorService();
		List<Floor> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "deleteFloor";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("floorid"));
		FloorService fs = new FloorService();
		fs.deleteById(id);
		return "floorManager";
	}
	
	
	
	@RequestMapping (value = "/download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response) {
    	int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		String type =  request.getParameter("type");
		Building b = new Building();
		BuildingService bs = new BuildingService();
		b = bs.findByPrimaryKey(buildingId);
		switch (type) {
		case "xml":
			//xml 
			System.out.println("entro");
			Document doc = new Document();
			System.out.println(b.getIndirizzo());
			doc.setRootElement(b.getElement());
			XMLOutputter x = new XMLOutputter();
			x.setFormat(Format.getPrettyFormat());
			try {
				File file = new File(b.getIndirizzo()+" interno "+b.getInterno()+".xml");
				System.out.println(file.getAbsolutePath());
				FileWriter fw = new FileWriter(file);
				x.output(doc, fw);
				processRequest(file.getAbsolutePath(), request, response);
	           
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "csv":
			try {
				processRequest(b.buildCSV(), request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		return "floorManager";
	}

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { int buildingId =
	 * Integer.parseInt(request.getParameter("buildingId"));
	 * request.setAttribute("buildingId",String.valueOf(buildingId));
	 * RequestDispatcher dispatcher = null; FloorService fs = new FloorService();
	 * List <Floor> alreadyExisting = new ArrayList<>(); alreadyExisting =
	 * fs.getAllByBuilding(buildingId); request.setAttribute("floors",
	 * alreadyExisting); String operation = request.getParameter("operation");
	 * 
	 * switch (operation) { case "create": dispatcher =
	 * request.getRequestDispatcher("newFloor.jsp"); break; case "read":
	 * RequestDispatcher view = request.getRequestDispatcher("/displayFloors.jsp");
	 * view.include(request, response); break; case "update": dispatcher =
	 * request.getRequestDispatcher("updateFloor.jsp"); break; case "delete":
	 * dispatcher = request.getRequestDispatcher("deleteFloor.jsp"); break; case
	 * "sendDataForInsert": String name = request.getParameter("floorName"); String
	 * description = request.getParameter("floorDescription"); String bid = (String)
	 * request.getAttribute("buildingId"); FloorService newFloorService = new
	 * FloorService(); Floor f = new Floor(); f.setNomeFloor(name);
	 * f.setDescrizione(description); f.setIdBuilding(bid);
	 * newFloorService.insertFloor(f); dispatcher =
	 * request.getRequestDispatcher("floorManager.jsp"); break; case
	 * "sendDataForUpdate": String newName = request.getParameter("floorName");
	 * String newDescription = request.getParameter("floorDescription"); String
	 * buildingid = (String) request.getAttribute("buildingId"); String floorId =
	 * request.getParameter("floorid"); Floor newFloor = new Floor();
	 * newFloor.setId(floorId); newFloor.setNomeFloor(newName);
	 * newFloor.setDescrizione(newDescription); newFloor.setIdBuilding(buildingid);
	 * fs.update(newFloor); dispatcher =
	 * request.getRequestDispatcher("floorManager.jsp"); break; case "home":
	 * dispatcher = request.getRequestDispatcher("floorManager.jsp"); break; case
	 * "sendDataForDelete": int id =
	 * Integer.parseInt(request.getParameter("floorid")); fs.deleteById(id);
	 * dispatcher = request.getRequestDispatcher("floorManager.jsp"); break; } if
	 * (dispatcher != null) { dispatcher.forward(request, response); } //
	 * response.getWriter().append("Non capisco. Che fai?"); }
	 * 
	 */

}
