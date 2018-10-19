package com.virtualpairprogrammers.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.service.BuildingService;


/**
 * Servlet implementation class FileGenerator
 */
public class FileGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		String type =  request.getParameter("type");
		System.out.println("Sto generando "+type+" relativo al building "+buildingId);
		Building b = new Building();
		BuildingService bs = new BuildingService();
		b = bs.findByPrimaryKey(buildingId);
		switch (type) {
		case "xml":
			System.out.println("entro");
			Document doc = new Document();
			System.out.println(b.getIndirizzo());
			doc.setRootElement(b.getElement());
			XMLOutputter x = new XMLOutputter();
			x.setFormat(Format.getPrettyFormat());
			try {
				File file = new File(b.getIndirizzo()+" interno "+b.getInterno()+".xml");
				FileWriter fw = new FileWriter(file);
				x.output(doc, fw);
				System.out.println(file.getAbsolutePath());
	           
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "csv":
			b.buildCSV();
			break;
		}
		request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
	}

	

}
