package generator;

import java.util.ArrayList;
import java.util.List;

 /**
 * The class includes methods to generate all possible vehicle plates numbers.
 * @author parten
 */
public final class Generator {

    private static final String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                                             "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private static List<String> plates = new ArrayList<>();

    public static int getTotalPlates(){
        int size = plates.size();
        return size;
    }

    public static List<String> getPlates() {
        return plates;
    }

    public static void addPlate(String plate) {
        plates.add(plate);
    }

    public static void plateGenerator(){
         int intPartRange = 9999;
         int z_indexOfLetter = 0;
         int y_indexOfLetter = 0;
         int x_indexOfLetter = 0;
         int counter = 0;
         for(int i = counter; i <= intPartRange; i++){
             if(i < 10){
                 addPlate(letters[x_indexOfLetter] + letters[y_indexOfLetter] + letters[z_indexOfLetter] + ": " + "000" + i);
             }else if(i >= 10 && i < 100){
                 addPlate(letters[x_indexOfLetter] + letters[y_indexOfLetter] + letters[z_indexOfLetter] + ": " + "00" + i);
             }else if(i >= 100 && i < 1000){
                 addPlate(letters[x_indexOfLetter] + letters[y_indexOfLetter] + letters[z_indexOfLetter] + ": " + "0" + i);
             }else {
                 addPlate(letters[x_indexOfLetter] + letters[y_indexOfLetter] + letters[z_indexOfLetter] + ": " + i);
             }
             if(i == intPartRange){
                 z_indexOfLetter++;
                 i =- 1;
                 if(z_indexOfLetter == 26){
                     z_indexOfLetter = 0;
                     y_indexOfLetter++;
                     if(y_indexOfLetter == 26){
                         i = intPartRange;
                     }
                 }
             }
         }
     }

}
