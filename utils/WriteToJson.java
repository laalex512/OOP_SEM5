package Sem5.utils;

import Sem5.model.contact.Contact;
import Sem5.model.phonebook.Phonebook;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteToJson {

	public void writeJson(JSONArray jsonArray, String pathFile){
		try (PrintWriter out = new PrintWriter(new FileWriter(pathFile))) {
			for (Object i : jsonArray){
				out.write(i.toString()+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JSONArray createJsonArray(Phonebook pb){
		JSONArray resultArray = new JSONArray();
		ArrayList<Contact> contactsList = pb.getContacts();
		for (Contact i : contactsList){
			resultArray.add(createJsonObject(i));
		}
		return resultArray;
	}

	public JSONObject createJsonObject(Contact contact){
		JSONObject resultObject = new JSONObject();
		resultObject.put("firstName",contact.getUser().getFirstName());
		resultObject.put("lastName",contact.getUser().getLastName());
		resultObject.put("company",contact.getUser().getCompany());
		resultObject.put("Phones",contact.getPhones());
		return resultObject;
	}

}
