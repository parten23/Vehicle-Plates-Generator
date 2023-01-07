import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static generator.Generator.getTotalPlates;
import static generator.Generator.plateGenerator;
import static generator.UI.*;

/**
 * @author parten
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome fam!");
        System.out.println("To see all plates being generated and printed to you enter P else enter C to continue.");
        Scanner printOrContinue = new Scanner(System.in);
        String fReply = printOrContinue.nextLine().toUpperCase();
        if (fReply.equals("P")){
//            System.out.println("Plates are being loaded please wait...");
            plateGenerator();
            printPlates();
            System.out.println(getTotalPlates() + " total plates generated");
            System.out.println("Enter a plate to search for: ");
            Scanner scanner = new Scanner(System.in);
            String txt = scanner.nextLine();
            searchByName(txt);
            boolean search = true;
            while(search){
                System.out.println("To search again enter 'Y' else enter 'N': ");
                Scanner replyScanner = new Scanner(System.in);
                String reply = replyScanner.next().toUpperCase();
                if (reply.equals("Y")) {
                    System.out.println("Enter a plate to search for: ");
                    Scanner scan = new Scanner(System.in);
                    String scanTxt = scan.nextLine();
                    searchByName(scanTxt);
                    search = true;
                }else if(reply.equals("N")){
                    search = false;
                }
            }
            System.out.println("Enter any number to search a plate: ");
            Scanner numScanner = new Scanner(System.in);
            int num = numScanner.nextInt();
            searchByIndex(num);
        }else if(fReply.equals("C")){
            System.out.println("Plates are being loaded please wait...");
            plateGenerator();
            System.out.println(getTotalPlates() + " total plates generated");
            System.out.println("Enter a plate to search for: ");
            Scanner scanner = new Scanner(System.in);
            String txt = scanner.nextLine();
            searchByName(txt);
            boolean search = true;
            while(search){
                System.out.println("To search again enter 'Y' else enter 'N': ");
                Scanner replyScanner = new Scanner(System.in);
                String reply = replyScanner.next().toUpperCase();
                if (reply.equals("Y")) {
                    System.out.println("Enter a plate to search for: ");
                    Scanner scan = new Scanner(System.in);
                    String scanTxt = scan.nextLine();
                    searchByName(scanTxt);
                    search = true;
                }else if(reply.equals("N")){
                    search = false;
                }
            }
            System.out.println("Enter any number to search a plate: ");
            Scanner numScanner = new Scanner(System.in);
            int num = numScanner.nextInt();
            searchByIndex(num);
        }
    }

}
