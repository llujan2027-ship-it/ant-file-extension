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
        File file = new File("contacts.txt");
        String contactsPath = "Contacts/contacts.txt";
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        String choice;
        ArrayList<Contact> contactList = new ArrayList<>();
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
                    Contact user = new Contact(details);
                    contactList.add(user);
                    
                    
                    //Write to contacts.txt
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactsPath,
                    true))) {
                        //writer.write(contentToWrite);

                        writer.append(user + "\n");
                        System.out.println("Successfully wrote to the file." + user + "\n"
                                + "Please choose another option.\n");
                    } catch (IOException e) {
                        System.err.println("An error occurred while writing to the file: " +
                        e.getMessage());
                    }
                    break;
                case "e":
                    /*// Read from contacts.txt
                    String lineE;
                    try (BufferedReader reader = new BufferedReader(new
                        FileReader(contactsPath))) {
                        String line;
                        System.out.println("\nContacts sorted by email:");
                        while ((line = reader.readLine()) != null) {
                            lineE = line;
                            String[] emailSort = lineE.split("\n");
                            String[] tempArray = new String[emailSort.length];
                            for(int j = 0; j < emailSort.length; j++){
                                for(int i = 0; i < emailSort.length - 1; i++){
                                    String[] temp1 = emailSort[i].split(" ");
                                    System.out.println("This is a test");
                                    System.out.println(Arrays.toString(temp1));
                                    String[] temp2 = emailSort[i+1].split(" ");
                                    System.out.println(Arrays.toString(temp2));
                                    int result = temp1[1].compareToIgnoreCase(temp2[1]);
                                    if(result > 0){
                                        tempArray[0] = emailSort[i];
                                        emailSort[i] = emailSort[i+1];
                                        emailSort[i+1] = tempArray[0];
                                    }
                                }
                            }

                            System.out.println(Arrays.toString(emailSort));
                        }
                    } catch (IOException e) {
                        System.err.println("An error occurred while reading from the file: "
                        + e.getMessage());
                    }
                    */
                    break;
                case "y":
                    /*// Read from contacts.txt
                    String lineY;
                    try (BufferedReader reader = new BufferedReader(new
                        FileReader(contactsPath))) {
                        String line;
                        System.out.println("\nReading from the file:");
                    while ((line = reader.readLine()) != null) {
                        lineY = line;
                    }
                    } catch (IOException e) {
                        System.err.println("An error occurred while reading from the file: "
                        + e.getMessage());
                    }*/
                    break;
                case "n":
                    /*// Read from contacts.txt
                    String lineN;
                    System.out.println("Ordered by name:\n\n");
                    try (BufferedReader reader = new BufferedReader(new
                        FileReader(contactsPath))) {
                        String line;
                        System.out.println("\nReading from the file:");
                    while ((line = reader.readLine()) != null) {
                        lineN = line;
                        String[] nameSort = lineN.split("\n");
                        Arrays.sort(nameSort);
                        System.out.println(Arrays.toString(nameSort));
                    }
                    } catch (IOException e) {
                        System.err.println("An error occurred while reading from the file: "
                        + e.getMessage());
                    }*/
                    break;
                case "q":
                    System.out.println("Thank you.");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
        
        
        
        
        
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
    
    String name, email, gradYear, username;
    
    public Contact(ArrayList details){
        name = details.get(0).toString();
        email = details.get(1).toString();
        gradYear = details.get(2).toString();
        username = details.get(3).toString();
    }
    
    @Override
    public String toString(){
        String result;
        result = name +", "+ email +", "+ gradYear +", "+ username;
        return result;
    }
}