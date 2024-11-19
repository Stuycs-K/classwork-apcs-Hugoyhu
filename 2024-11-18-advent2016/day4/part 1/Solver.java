import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solver {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> roomList = new ArrayList<String>(1);
            while (scan.hasNextLine()) {
                roomList.add(scan.nextLine());
            }

            int sumSectorID = 0;

            for (int i = 0; i < roomList.size(); i++) {
                // remove []
                String checksum = "";

                String[] staging1 = roomList.get(i).split("\\[");
                checksum = staging1[1].split("]")[0];

                // get sector ID 
                String[] staging2 = staging1[0].split("-");
                int sectorID = Integer.valueOf(staging2[staging2.length - 1]);

                String encrypted = "";
                for (int j = 0; j < staging2.length - 1; j++) {
                    encrypted += staging2[j];
                }

                ArrayList<Integer> values = new ArrayList<Integer>(1); 

                for (int c = 0; c < checksum.length(); c++) {
                    char current = checksum.charAt(c);
                    int total=0;

                    for (int z = 0; z < encrypted.length(); z++) {
                        if (encrypted.charAt(z) == current) {
                            total++;
                        }
                    }
                    values.add(total);
                }

                boolean status = true;
                for (int c = 1; c < values.size(); c++) {
                    if (values.get(c-1) < values.get(c)) {
                        status =false;
                        break;
                    } else if ((values.get(c-1) == values.get(c)) && (checksum.charAt(c-1) > checksum.charAt(c)) ) {
                        status = false;
                        break;
                    }
                }

                if (status){
                    sumSectorID+= sectorID;
                }


            }

            System.out.println(sumSectorID);





        } catch (FileNotFoundException ex) {
            // File not found what should you do?
            System.out.println("File not found");
            return; // you can return from a void function just don't put a value.
        }
    }
}
