package Sem5.utils;

import Sem5.model.contact.Contact;
import Sem5.model.contact.Phone;
import Sem5.model.contact.User;
import Sem5.model.phonebook.Phonebook;
import Sem5.model.service.ContactServiceImpl;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadFromJson {

	public Phonebook readJson(String pathFile){
		Phonebook resultBook = new Phonebook(pathFile.substring(pathFile.lastIndexOf("/")+1 , pathFile.lastIndexOf(".")));
		try (FileReader fr = new FileReader(pathFile)){
			Scanner scanner = new Scanner(fr);
			JSONParser parser = new JSONParser();
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				JSONObject object = (JSONObject) parser.parse(line);
				resultBook.addContact(JsonToContact(object));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBook;
	}

	public Contact JsonToContact(JSONObject line){
		User user = new User(line.get("firstName").toString(), line.get("lastName").toString());
		user.setCompany(line.get("company").toString());
		String phonesLine = line.get("Phones").toString();
		phonesLine.replace("[","").replace("]","");
		String[] phonesArray = phonesLine.split(",");
		ArrayList<Phone> phones = new ArrayList<>();
		for (String i: phonesArray){
			phones.add(new Phone(i));
		}
		return new ContactServiceImpl().createContact(user, phones);
	}
}
