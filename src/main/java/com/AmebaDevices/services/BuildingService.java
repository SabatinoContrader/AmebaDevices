package com.AmebaDevices.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.BuildingConverter;
import com.AmebaDevices.converter.CustomerConverter;
import com.AmebaDevices.dao.BuildingDAO;
import com.AmebaDevices.dao.CustomerDAO;
import com.AmebaDevices.dao.FloorDAO;
import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Room;

@Service
public class BuildingService {

	private BuildingDAO buildingdao;
	private CustomerDAO customerdao;
	private FloorDAO floordao;
	private RoomDAO roomdao;

	// DEVE permettere operazioni di create, read, update e delete
	// e probabilmente altre se mi serviranno
	@Autowired
	public BuildingService(BuildingDAO buildingDao, CustomerDAO customerDao, FloorDAO floordao, RoomDAO roomdao) {
		this.buildingdao = buildingDao;
		this.customerdao = customerDao;
		this.floordao = floordao;
		this.roomdao = roomdao;
	}

	public List<BuildingDTO> getAll(String owner) {
		
		List<Building> buildings = new ArrayList<>();
		List<BuildingDTO>toReturn= new ArrayList<>();
		Customer ownerC = this.customerdao.findByUsername(owner);
		buildings = buildingdao.findByOwner(ownerC);
		buildings.forEach(b->toReturn.add(BuildingConverter.convertToDto(b)));
		System.out.println("----------------------------------->" + buildings.size());
		return toReturn;

	}

	public void delete(BuildingDTO toDestroy) {
		Building b = BuildingConverter.convertToBuilding(toDestroy);
		b.setOwner(null);
		List <Floor> floors = floordao.findByBuilding(b);
		for (Floor floor : floors) {
			floor.setBuilding(null);
			floordao.save(floor);
			floordao.delete(floor);
		}
		this.buildingdao.save(b);
		buildingdao.delete(b);
	}

	public Building create(BuildingDTO myNewBuilding, String owner) {
		Customer c = this.customerdao.findByUsername(owner);
		myNewBuilding.setOwner(CustomerConverter.convertToDto(c));
		return buildingdao.save(BuildingConverter.convertToBuilding(myNewBuilding));

	}

	public void update(BuildingDTO newValues, String owner) {
		if (buildingdao.findOne(newValues.getId()) != null) {
			Customer customer = this.customerdao.findByUsername(owner);
			newValues.setOwner(CustomerConverter.convertToDto(customer));
			buildingdao.save(BuildingConverter.convertToBuilding(newValues));
		}
	}

	public BuildingDTO findByPrimaryKey(long buildingId) {
		return BuildingConverter.convertToDto(buildingdao.findOne(buildingId));
	}

	public Element getElement(BuildingDTO b) {
		Element toReturn = new Element("building");
		toReturn.setAttribute(new Attribute("id", String.valueOf(b.getId())));
		toReturn.addContent(new Element("indirizzo").setText(b.getAddress()));
		toReturn.addContent(new Element("interno").setText(String.valueOf(b.getInterno())));
		toReturn.addContent(new Element("citta").setText(b.getCity()));
		toReturn.addContent(new Element("cap").setText(b.getCap()));
		Element floorsFather = new Element("floors");
		Element floorsElement;
		if (b.getId() != 0l) {
			List<Floor> floors = floordao.findByBuilding(BuildingConverter.convertToBuilding(b));
			for (int i = 0; i < floors.size(); i++) {
				floorsElement = new Element("floor");
				floorsElement.setAttribute(new Attribute("id", String.valueOf(floors.get(i).getId())));
				floorsElement.addContent(new Element("nome").setText(floors.get(i).getNomeFloor()));
				floorsElement.addContent(new Element("descrizione").setText(floors.get(i).getDescrizione()));
				Element roomsFather = new Element("rooms");
				if (floors.get(i).getId() != 0l) {
					List<Room> rooms = roomdao.findByFloor(floors.get(i));
					for (int j = 0; j < rooms.size(); j++) {
						Element roomElement = new Element("room");
						roomElement.setAttribute(new Attribute("id", String.valueOf(rooms.get(j).getId())));
						roomElement.addContent(new Element("nome").setText(rooms.get(j).getNomeRoom()));
						roomElement.addContent(new Element("descrizione").setText(rooms.get(j).getDescrizione()));
						roomsFather.addContent(roomElement);
						// Manca item
					}

					floorsElement.addContent(roomsFather);
				}
				floorsFather.addContent(floorsElement);
			}

			toReturn.addContent(floorsFather);
		}
		return toReturn;

	}

	public String buildCSV(BuildingDTO b) {
		String[] header = { "edificio", "interno", "citta", "cap", "floor", "", "room", "item" };
		// la struttura del file � fissa. Abbiamo 8 colonne diverse. La prima contiene
		// l'indirizzo dell'edificio
		// la seconda colonna � relativa all'interno
		// la terza contiene la citt� dell'edificio
		// la quarta contiene il cap
		// La quinta e sesta colonna del file contengono i dati relativi al floor
		// la quinta contiene il nome del floor e la sesta la sua descrizione
		// La settima colonna contiene il nome della room
		// L'ottava (ed eventuali successive) contengono le info sugli item
		// si � pensato per ragioni di ottimizzazione, di "scrivere" le info solo nel
		// momento di cambiamento
		// rispetto alle precedenti (es info sul floor solo nella riga relativa alla
		// prima room di quel floor)
		BufferedWriter bw;
		CSVPrinter csvPrinter = null;
		String path = new File(b.getAddress() + " interno " + b.getInterno() + ".csv").getAbsolutePath();
		try {
			bw = Files.newBufferedWriter(Paths.get(path));
			csvPrinter = new CSVPrinter(bw, CSVFormat.DEFAULT.withHeader(header));
			csvPrinter.flush();

			String[] row = new String[8];
			row[0] = b.getAddress();
			row[1] = String.valueOf(b.getInterno());
			row[2] = b.getCity();
			row[3] = b.getCap();
			List<Floor> myFloors = floordao.findByBuilding(BuildingConverter.convertToBuilding(b));
			for (int i = 0; i < myFloors.size(); i++) {
				row[4] = myFloors.get(i).getNomeFloor();
				row[5] = myFloors.get(i).getDescrizione();
				List<Room> myRooms = roomdao.findByFloor(myFloors.get(i));
				for (int k = 0; k < myRooms.size(); k++) {
					row[6] = myRooms.get(k).getNomeRoom();
					csvPrinter.printRecord(row);
					csvPrinter.flush();
					row = new String[8];
					// ItemService is = new ItemService();
					// List<Item> myItems =
					// is.getAllByRoom(Integer.parseInt(myRooms.get(k).getId()));
					// for sugli item
					// inserimento di dati nel csv

					// dato che non abbiamo gli items, stampiamo a livello di rooms
				}
				if (myRooms.size() == 0) {
					// Stampo la riga delle cose relative a building e floor
					csvPrinter.printRecord(row);
					csvPrinter.flush();
					row = new String[8];
				}
			}
			if (myFloors.size() == 0) {
				// Stampo la riga delle cose relative solamente al building
				csvPrinter.printRecord(row);
				csvPrinter.flush();
				row = new String[8];
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
