/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readwriteantfile;

/**
 *
 * @author llujan2027
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class ReadWriteAntFile {
    public static void main(String[] args) {
        //sets the file path
        String contactsPath = "Contacts/contacts.txt";
        //keeps the program running
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        //Stores the user's choice in the program
        String choice;
        //Where all contacts are kept
        ArrayList<Contact> contactList = new ArrayList<>();
        //Creates a new contact.txt file, but if there already is one, adds the
        //contacts to the contactList
        try{
            File contacts = new File("contacts.txt");
            if(contacts.createNewFile()){
                
            }else{
                
                try (BufferedReader reader = new BufferedReader(new FileReader(contactsPath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    //Create a contact
                    String[] tempArray = line.split(",");
                    ArrayList<String> toContact = new ArrayList<>(Arrays.asList(tempArray));
                    Contact user = new Contact(toContact);
                    //Add to list
                    contactList.add(user);
                }
                } catch (IOException e) {
                    System.err.println("An error occurred while reading from the file: "
                    + e.getMessage());
                }
            }
        } catch (IOException e){
            System.out.println("An error occured.");
            e.getMessage();
        }
        
        
        
        System.out.println("""
                           Welcome. Please select an option -
                           
                           a: Add a contact
                           e: Order contacts by email
                           y: Order contacts by grad year
                           n: Order contacts by name
                           q: terminate program
                           """);
        while(run == true){
            choice = scan.next();
            switch(choice){
                case "a":
                    ArrayList details = new ArrayList();
                    String input;
                    System.out.println("""
                                       Please input contact's full name.
                                       Do not use a space between names
                                       (EX: JohnDoe)""");
                    input = scan.nextLine();
                    input = scan.nextLine();
                    if(!input.equals("\n")){
                        if(!input.equals("a")){
                            //Adds String to an ArrayList
                            details.add(input);
                        }
                    }
                    System.out.println("Please input contact's email address.");
                    input = scan.nextLine();
                    if(!input.equals("\n")){
                            details.add(input);
                    }
                    System.out.println("Please input contact's graduation year.");
                    input = scan.nextLine();
                    if(!input.equals("\n")){
                            details.add(input);
                    }
                    System.out.println("Please input contact's username.");
                    input = scan.nextLine();
                    if(!input.equals("\n")){
                            details.add(input);
                    }
                    //Uses the ArrayList to create a contact and adds it to contactList
                    Contact user = new Contact(details);
                    contactList.add(user);
                    
                    
                    //Write to contacts.txt
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactsPath,
                    true))) {
                        //writer.write(contentToWrite);

                        writer.append(user + "\n");
                        System.out.println("Successfully wrote to the file.\nPlease choose another option.\n");
                    } catch (IOException e) {
                        System.err.println("An error occurred while writing to the file: " +
                        e.getMessage());
                    }
                    break;
                case "e":
                    ArrayList<Contact> emailSort = contactList;
                    for(int i = contactList.size()-1; i > 0; i--){
                        for(int j = 0; j < i; j++){
                            //Creates two temp email strings
                            String email1 = emailSort.get(j).getEmail();
                            String email2 = emailSort.get(j+1).getEmail();
                            //comparison: if 2 comes before 1, then...
                            if(email1.compareTo(email2) > 0){
                                //switch 2 and 1
                                Contact temp = emailSort.get(j);
                                emailSort.set(j, emailSort.get(j+1));
                                emailSort.set(j+1, temp);
                            }
                        }
                    }
                    //print sorted email list
                    System.out.println("Contacts sorted by email:");
                    for(int i = 0; i < emailSort.size(); i++){
                        System.out.println(emailSort.get(i));
                    }
                    System.out.println("\nPlease choose another option.\n");
                    break;
                case "y":
                    //same with grad year
                    ArrayList<Contact> yearSort = contactList;
                    for(int i = contactList.size()-1; i > 0; i--){
                        for(int j = 0; j < i; j++){
                            String year1 = yearSort.get(j).getYear();
                            String year2 = yearSort.get(j+1).getYear();
                            if(year1.compareTo(year2) > 0){
                                Contact temp = yearSort.get(j);
                                yearSort.set(j, yearSort.get(j+1));
                                yearSort.set(j+1, temp);
                            }
                        }
                    }
                    System.out.println("Contacts sorted by grad year:");
                    for(int i = 0; i < yearSort.size(); i++){
                        System.out.println(yearSort.get(i));
                    }
                    System.out.println("\nPlease choose another option.\n");
                    break;
                case "n":
                    //same with name
                    ArrayList<Contact> nameSort = contactList;
                    for(int i = contactList.size()-1; i > 0; i--){
                        for(int j = 0; j < i; j++){
                            String name1 = nameSort.get(j).getName();
                            String name2 = nameSort.get(j+1).getName();
                            if(name1.compareTo(name2) > 0){
                                Contact temp = nameSort.get(j);
                                nameSort.set(j, nameSort.get(j+1));
                                nameSort.set(j+1, temp);
                            }
                        }
                    }
                    System.out.println("Contacts sorted by name:");
                    for(int i = 0; i < nameSort.size(); i++){
                        System.out.println(nameSort.get(i));
                    }
                    System.out.println("\nPlease choose another option.\n");
                    break;
                case "q":
                    //ends program
                    System.out.println("Thank you.");
                    run = false;
                    break;
                default:
                    //failsafe
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
        
        
        
        
        //for personal ref.
        /*// Read from contacts.txt
        try (BufferedReader reader = new BufferedReader(new
            FileReader(contactsPath))) {
            String line;
            //System.out.println("\nReading from the file:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: "
            + e.getMessage());
        }*/
    }
}

class Contact{
    //regular basic class, no need to explain
    String name, email, gradYear, username;
    //except for this--creates a contact based off Strings in an ArrayList
    public Contact(ArrayList details){
        name = details.get(0).toString();
        email = details.get(1).toString();
        gradYear = details.get(2).toString();
        username = details.get(3).toString();
    }
    
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getYear(){
        return this.gradYear;
    }
    public String getUser(){
        return this.username;
    }
    
    @Override
    //Single comma separation
    public String toString(){
        String result;
        result = name +","+ email +","+ gradYear +","+ username;
        return result;
    }
}