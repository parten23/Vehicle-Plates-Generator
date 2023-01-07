package generator;

import java.util.List;
import java.util.Scanner;

import static generator.Generator.getPlates;
import static generator.Generator.getTotalPlates;

/**
 * The class includes methods to search for a plate.
 * <p>
 * {@code searchByName} method
 * <blockquote>
 * Takes a string plate name (e.g. ATN: 2323) as an argument and searches for it.
 * <p>
 * NOTE: There should be a single space after the colon (:). ATN:2323 will fail!
 * </p>
 * <p>
 * Returns the position of that plate relative to the first plate (AAA: 0000).
 * <p>
 * A successful message is printed out to the console (Plate 'ATN: 2323' found at position 5072324).
 * <p>
 * A failure message is printed out to the console (Oops no match!).
 * </p>
 * </blockquote>
 * {@code searchByIndex} method
 * <blockquote>
 * Takes an integer number (e.g. 4900200) as an argument and searches for a plate at that position.
 * <p>
 * Returns a plate name which corresponds to the given argument.
 * <p>
 * A successful message is printed out to the console (The plate at position 4900200 is ASW: 0200).
 * <p>
 * A failure message is printed out to the console (Invalid option).
 * </p>
 * </blockquote>
 * @author parten23
 */
public class UI {

    private static final List<String> plates = getPlates();

    public static void searchByName(String name) {
        boolean found = true;
        for(int i = 0; i < plates.size(); i++) {
            if(name.equals(plates.get(i))){
                int position = i + 1;
                System.out.println("Plate " + "'" + name + "'" + " found at position " + position);
                found = true;
                break;
            }else{
                found = false;
            }
        }
        if(!found){
            System.out.println("Oops no match!");
        }
    }

    public static void searchByIndex(int index) {
        boolean search = true;
        while(search){
            Scanner scanner = new Scanner(System.in);
            System.out.println("To search again enter 'Y' else enter 'N': ");
            String reply = scanner.next().toUpperCase();
            if (reply.equals("Y")) {
                System.out.println("Enter any number to search a plate: ");
                int number = scanner.nextInt();
                if (number >= 0 && number <= getTotalPlates()) {
                    System.out.println("The plate at position " + index + " is " + plates.get(number));
                }else {
                    System.out.println("Invalid option");
                    search = false;
                }
            }else if(reply.equals("N")){
                search = false;
            }
        }
        System.out.println("~~~Program Exited~~~");
    }

    public static void printPlates() {
        for(int i=0;i<plates.size();i++) {
            int count = i + 1;
            System.out.print("#"+count+" ");
            System.out.println(plates.get(i));
        }
        System.out.println("<-----Plates Count----->");
        System.out.println("Total of "+plates.size()+ " plates generated (Note: Zimbabwe Yellow Vehicle Plates)");
        System.out.println("<----------End--------->");
    }
}
