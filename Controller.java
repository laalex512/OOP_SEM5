package Sem5;

import Sem5.model.contact.Contact;
import Sem5.model.contact.Phone;
import Sem5.model.contact.User;
import Sem5.model.phonebook.Phonebook;
import Sem5.model.service.ContactServiceImpl;
import Sem5.model.service.PhonebookService;
import Sem5.utils.ReadFromConsole;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
	public static void startApp() {
		String message = new ReadFromConsole().getMessage();
		List<String> line = (Arrays.stream(message.split(" ")).toList());
		User user1 = new User(line.get(0), line.get(1));
		ArrayList<Phone> phones1 = new ArrayList<>();
		for (int i = 2; i< line.size(); i++){
			phones1.add(new Phone(line.get(i)));
		}
		Contact cont1 =  new ContactServiceImpl().createContact(user1, phones1);
		ArrayList<Contact> listContacts = new ArrayList<>();
		listContacts.add(cont1);
		Phonebook pb1 = new PhonebookService().createPhonebook("pb1", listContacts);
		System.out.println(pb1);
	}
}
