package Sem5.model.service;

import Sem5.model.contact.Contact;
import Sem5.model.contact.Phone;
import Sem5.model.contact.User;
import java.util.ArrayList;

public interface ContactService <T extends User, E extends Phone>  {

	public boolean isCorrect(T user, ArrayList<E> phones);
	public Contact createContact(T user, ArrayList<E> phones);

}
