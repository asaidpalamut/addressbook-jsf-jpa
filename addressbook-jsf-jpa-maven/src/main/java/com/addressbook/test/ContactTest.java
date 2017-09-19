package com.addressbook.test;

import com.addressbook.dao.AddressDao;
import com.addressbook.dao.AddressDaoImpl;
import com.addressbook.dao.ContactDao;
import com.addressbook.dao.ContactDaoImpl;
import com.addressbook.dao.PhoneDao;
import com.addressbook.dao.PhoneDaoImpl;
import com.addressbook.domain.Address;
import com.addressbook.domain.Contact;
import com.addressbook.domain.Phone;
import com.addressbook.service.AddressService;
import com.addressbook.service.AddressServiceImpl;
import com.addressbook.service.ContactService;
import com.addressbook.service.ContactServiceImpl;
import com.addressbook.service.PhoneService;
import com.addressbook.service.PhoneServiceImpl;

public class ContactTest {

	public static void main(String[] args) {
		
		PhoneService phoneService = new PhoneServiceImpl();
		AddressService addressService = new AddressServiceImpl();
		ContactService contactService = new ContactServiceImpl();
		
//		for (Phone p : phoneService.findByContactId(19L)) {
//			System.out.println("-----------------");
//			System.out.println(p.getPhoneNumber());
//		}
		
//		Phone phone = phoneService.getById(95L);
//		phone.setPhoneNumber("588888888");
//		phoneService.update(phone);
		
//		/* Phone */
//		Phone phone1 = new Phone();
//		phone1.setPhoneNumber("05313174433");
//		
//		Phone phone2 = new Phone();
//		phone2.setPhoneNumber("05336673366");
//		
//		Phone phone3 = new Phone();
//		phone3.setPhoneNumber("05424600598");
//		
//		Phone phone4 = new Phone();
//		phone4.setPhoneNumber("05348440101");
//		
//		
//		/* Address */ 
//		
//		Address address1 = new Address();
//		address1.setDesc("Soganli");
//		address1.setCity("Istanbul");
//		address1.setCountry("Turkey");
//		
//		Address address2 = new Address();
//		address2.setDesc("Odemis");
//		address2.setCity("Izmir");
//		address2.setCountry("Turkey");
//		
//		Address address3 = new Address();
//		address3.setDesc("Kangal");
//		address3.setCity("Sivas");
//		address3.setCountry("Turkey");
//		
//		/* Contact */
//		
//		Contact contact1 = new Contact();
//		contact1.setName("Ahmet");
//		contact1.setSurname("Palamut");
//		contact1.setEmail("asaitpalamut@gmail.com");
//		contact1.getPhones().add(phone1);
//		contact1.getPhones().add(phone2);
//		contact1.getAddresses().add(address1);
//		phone1.setContact(contact1);
//		phone2.setContact(contact1);
//		address1.setContact(contact1);
//		
//		Contact contact2 = new Contact();
//		contact2.setName("Furakan");
//		contact2.setSurname("Kara");
//		contact2.setEmail("mfukara@gmail.com");
//		contact2.getPhones().add(phone3);
//		contact2.getAddresses().add(address2);
//		phone3.setContact(contact2);
//		address2.setContact(contact2);
//
//		Contact contact3 = new Contact();
//		contact3.setName("Mehmet");
//		contact3.setSurname("Palamut");
//		contact3.setEmail("mpala@gmail.com");
//		contact3.getPhones().add(phone4);
//		contact3.getAddresses().add(address3);
//		phone4.setContact(contact3);
//		address3.setContact(contact3);
//		
//
//		contactService.create(contact1);
//		contactService.create(contact2);
//		contactService.create(contact3);
//		
//		phoneService.create(phone1);
//		phoneService.create(phone2);
//		phoneService.create(phone3);
//		phoneService.create(phone4);
//		
//		addressService.create(address1);
//		addressService.create(address2);
//		addressService.create(address3);
		
//		List<Contact> list = contactService.getAll();
//		for (Contact c : list) {
//			System.out.println(c.getName()+ " - " + c.getAddresses().get(0).getCity());
//		}

	}
}
