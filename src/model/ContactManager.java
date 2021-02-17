package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ContactManager {
	public final static String FILESEPARATOR = ";";
	
	
	private List<Contact> contacts;
	
	
	
	public ContactManager() {
		contacts =new ArrayList<>();
	}
	
	
	public void addContat(String nm, String em) {
		contacts.add(new Contact(nm,em));
	}


	public List<Contact> getContacts() {
		return contacts;
	}

	public void importContacts(String fileName)throws IOException{
		System.out.println(fileName);
		 BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line = br.readLine();
		    while(line!=null){
		      String[] parts = line.split(FILESEPARATOR);
		      addContat(parts[0],parts[1]);
		      line = br.readLine();
		    }
		    br.close();
		
	}
	
	public void exportContacts(String fileName)throws IOException{
		 PrintWriter pw = new PrintWriter(fileName);

		    for(int i=0;i<contacts.size();i++){
		      Contact myContact = contacts.get(i);
		      pw.println(myContact.getName()+";"+myContact.getEmail());
		    }

		    pw.close();
		
	}

}
