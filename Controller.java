package Sem5;

import Sem5.model.contact.Contact;
import Sem5.model.contact.Phone;
import Sem5.model.contact.User;
import Sem5.model.phonebook.Phonebook;
import Sem5.model.service.ContactServiceImpl;
import Sem5.model.service.PhonebookService;
import Sem5.utils.ReadFromJson;
import Sem5.utils.WriteToJson;
import java.util.ArrayList;

public class Controller {
	public static void startApp() {
		User user1 = new User("Ivan","Ivanov");
		User user2 = new User("Ivan","Petrov");
		User user3 = new User("Petr","Ivanov");
		user1.setCompany("IBM");
		user2.setCompany("IBM");
		user3.setCompany("Apple");

		ArrayList<Phone> phones1 = new ArrayList<>();
		phones1.add(new Phone("456456"));
		phones1.add(new Phone("123123"));

		ArrayList<Phone> phones2 = new ArrayList<>();
		phones2.add(new Phone("654654"));
		phones2.add(new Phone("789789"));

		ArrayList<Phone> phones3 = new ArrayList<>();
		phones3.add(new Phone("987987"));
		phones3.add(new Phone("321321"));

		Contact cont1 =  new ContactServiceImpl().createContact(user1, phones1);
		Contact cont2 =  new ContactServiceImpl().createContact(user2, phones2);
		Contact cont3 =  new ContactServiceImpl().createContact(user3, phones3);

		ArrayList<Contact> listContacts = new ArrayList<>();
		listContacts.add(cont1);
		listContacts.add(cont2);
		listContacts.add(cont3);

		Phonebook pb1 = new PhonebookService().createPhonebook("pb1", listContacts);
		for (Contact i: pb1.getContacts()){
			System.out.println(i);
		}


		String pathFile = "Sem5/book1.json";

		WriteToJson jsonWriter = new WriteToJson();
		jsonWriter.writeJson(jsonWriter.createJsonArray(pb1), pathFile);

		ReadFromJson jsonReader = new ReadFromJson();
		Phonebook pb2 = jsonReader.readJson(pathFile);

		for (Contact i: pb2.getContacts()){
			System.out.println(i);
		}

	}
}
