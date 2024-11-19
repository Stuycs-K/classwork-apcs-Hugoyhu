import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solver {
    public static void main (String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> roomList = new ArrayList<String>(1);
            while (scan.hasNextLine()) {
                roomList.add(scan.nextLine());
            }


            ArrayList<String> newFilteredList = new ArrayList<String>();

            for (int i = 0; i < roomList.size(); i++) {
                // remove the checksum
                String[] staging1 = roomList.get(i).split("\\[");
                String checksum = staging1[1].split("\\]")[0];


                // get the sectorID 
                String[] staging2 = staging1[0].split("-");
                String sectorID = staging2[staging2.length - 1];
                String encrypted = "";
                for (int j = 0; j < staging2.length-1; j++) {
                    encrypted += staging2[j];
                }

                System.out.println("\n" + sectorID);
                System.out.println(encrypted);


                int[] checksumFreq = new int[26];

                for (int j = 0; j < encrypted.length(); j++) {
                    checksumFreq[encrypted.charAt(j) - 'a'] ++;
                }


                System.out.println(checksum);
                // for(int j = 0; j < checksumFreq.length; j++) {
                //     System.out.println(checksumFreq[j]);
                // }

                // generate a checksum 
                String actualChecksum = "";
                for (int j = 50; j >= 0; j--) {
                    for (int z = 0; z < checksumFreq.length; z++) {
                        //System.out.println("Compare: z: " + checksumFreq[z] + ", j: " + j);
                        if (checksumFreq[z] == j) {
                            actualChecksum += ( (char) (z + 'a') );
                        }
                    }
                }

                actualChecksum = actualChecksum.substring(0, 5);

                if (actualChecksum.equals(checksum)) {
                    newFilteredList.add(roomList.get(i));
                }
                
                

            }

            for (int i = 0; i < newFilteredList.size(); i++) {
                // remove the []
                String staging = newFilteredList.get(i);
                String staging1 = staging.split("\\[")[0];

                String[] staging2 = staging1.split("-");

                int sector = Integer.valueOf(staging2[staging2.length-1]);
                String[] filteredText = new String[staging2.length-1];

                for (int j=0; j < staging2.length-1; j++) {
                    String current = staging2[j];
                    String out = "";

                    for (int z=0; z < current.length(); z++) {
                        int working = current.charAt(z) - 'a';
                        working += sector;
                        working = working % 26;

                        out += ( (char) (working + 'a') );
                    }

                    filteredText[j] = out;
                }

                String x = String.join(" ", filteredText);
                System.out.println(x + ", " + sector);


            }


        } catch (FileNotFoundException ex) {
            // File not found what should you do?
            System.out.println("File not found");
            return; // you can return from a void function just don't put a value.
        }
    }
}
