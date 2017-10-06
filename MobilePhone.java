package com.Lori;

import java.util.ArrayList;

/**
 * Created by lhema on 5/20/2017.
 */
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }



    public void addNewContact(Contact contact) {


        if (findContact(contact.getName()) >= 0) {
            System.out.println("can't add, already contains contact");
        } else {

            myContact.add(contact);
        }
    }




    public void printContacts() {
        System.out.println("You have " + myContact.size() + " people in your contact list");
        for (int i = 0; i < myContact.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContact.get(i).getName() + " " +
            this.myContact.get(i).getPhoneNumber());


        }

    }


//    private int findContact(Contact contact) {
//        return this.myContact.indexOf(contact);
//    }

    private int findContact(String contactName) {
        for(int i=0; i<this.myContact.size(); i++) {
            Contact contact = this.myContact.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    private String findContact(int contactNumber){
        String info = this.myContact.get(contactNumber).getName() + " " +
        this.myContact.get(contactNumber).getPhoneNumber();
        return info;

    }

    public String searchContact(String contactName){
        int contactLocation = findContact(contactName);
        if (contactLocation < 0){
            String info = "contact does not exist";
            return info;
        }else {
            String info = findContact(contactLocation);
            return info;
        }

    }

    public String removeContact(String contactName){
        int contactLocation = findContact(contactName);
        if (contactLocation < 0){
            String info = "contact does not exist";
            return info;
        }else {
            removeContact(contactLocation);
            String info = "contact was removed";
            return info;
        }

    }

    private void removeContact(int contactLocation){
        myContact.remove(contactLocation);
    }

    public String replaceContact(String contactName, Contact newContact){
        int contactLocation = findContact(contactName);
        if (contactLocation < 0){
            String info = "contact does not exist";
            return info;
        }else {
            replaceContact(contactLocation, newContact);
            String info = "contact was replaced";
            return info;
        }

    }

    private void replaceContact(int contactLocation, Contact newContact){
        myContact.set(contactLocation,newContact);

    }

    public String updateContactName(String contactName, String newName){
        int contactLocation = findContact(contactName);
        if (contactLocation < 0){
            String info = "contact does not exist";
            return info;
        }else {
            updateContactName(contactLocation, newName);
            String info = "name was updated";
            return info;
        }

    }

    private void updateContactName(int contactNumber, String newName){
        String phoneNumber = this.myContact.get(contactNumber).getPhoneNumber();
        Contact newContact = Contact.createContact(newName,phoneNumber);
        replaceContact(contactNumber,newContact);



    }

    public String updateContactNumber(String contactName, String newNumber) {
        int contactLocation = findContact(contactName);
        if (contactLocation < 0) {
            String info = "contact does not exist";
            return info;
        } else {
            updateContactNumber(contactLocation, newNumber);
            String info = "phone number was updated";
            return info;
        }

    }

        private void updateContactNumber(int contactNumber, String newNumber){
            String name = this.myContact.get(contactNumber).getName();

            Contact newContact = Contact.createContact(name,newNumber);
            replaceContact(contactNumber,newContact);



        }

    }




