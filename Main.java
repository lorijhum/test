package com.Lori;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static MobilePhone mobilePhone = new MobilePhone("2222222222");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        printOptions();
        boolean stop = false;

        while (!stop) {
            int userInt = scanner.nextInt();
            scanner.nextLine();

            switch (userInt) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    printContacts();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    replaceContact();
                    break;
                case 6:
                    UpdateContactName();
                    break;
                case 7:
                    UpdateContactNumber();
                    break;
                case 8:
                    printOptions();
                    break;
                case 9:
                    stop = true;
                    break;

            }

        }


    }
    public static void addContact() {
        System.out.println("enter name \r");
        Scanner scanner = new Scanner(System.in);
        String contactName = scanner.nextLine();
        System.out.println("enter phone number \r");
        String contactPhone = scanner.nextLine();
        Contact contact = Contact.createContact(contactName,contactPhone);
        mobilePhone.addNewContact(contact);
        System.out.println("contact added ");

        }


    public static void printContacts(){
        mobilePhone.printContacts();
    }

    public static void printOptions(){
        System.out.println("Contacts Menu \r");
        System.out.println("Enter 1 to add contact \r");
        System.out.println("enter 2 to search for contact \r");
        System.out.println("enter 3 to print contacts \r");
        System.out.println("enter 4 to remove contact \r");
        System.out.println("enter 5 to replace contact \r");
        System.out.println("enter 6 to update contact name \r");
        System.out.println("enter 7 to update contact number \r");
        System.out.println("enter 8 to display Menu \r");
        System.out.println("enter 9 to quit \r");
    }

    public static void searchContact(){
        System.out.println("enter contact name to search for \r");
        String searchName = scanner.nextLine();

        String displayContact = mobilePhone.searchContact(searchName);
        System.out.println("contact info is " +  displayContact);
    }

    public static void removeContact(){
        System.out.println("enter contact name to remove  \r");
        String searchName = scanner.nextLine();
        String displayContact = mobilePhone.removeContact(searchName);
        System.out.println(displayContact);
    }

    public static void replaceContact(){
        System.out.println("enter contact name to update  \r");
        String searchName = scanner.nextLine();
        System.out.println("enter new name \r");
        String newName = scanner.nextLine();
        System.out.println("enter new phone number \r");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        String displayContact = mobilePhone.replaceContact(searchName,newContact);
        System.out.println(displayContact);

    }
    public static void UpdateContactName(){
        System.out.println("enter contact name to update  \r");
        String searchName = scanner.nextLine();
        System.out.println("enter new name \r");
        String newName = scanner.nextLine();
        String displayinfo = mobilePhone.updateContactName(searchName,newName);

        System.out.println(displayinfo);

    }

    public static void UpdateContactNumber(){
        System.out.println("enter contact name to update  \r");

        String searchName = scanner.nextLine();
        String displayContact = mobilePhone.searchContact(searchName);
        System.out.println("contact info is " +  displayContact);

        System.out.println("enter new phone number \r");
        String newNumber = scanner.nextLine();
        String displayinfo = mobilePhone.updateContactNumber(searchName,newNumber);

        System.out.println(displayinfo);

    }
}
