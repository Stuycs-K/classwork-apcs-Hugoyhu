import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Take2 {
    public static void main (String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> roomList = new ArrayList<String>(1);
            while (scan.hasNextLine()) {
                roomList.add(scan.nextLine());
            }

            int totalSectorSum = 0;

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
                    totalSectorSum += Integer.valueOf(sectorID);
                }


            }

            System.out.println(totalSectorSum);


        } catch (FileNotFoundException ex) {
            // File not found what should you do?
            System.out.println("File not found");
            return; // you can return from a void function just don't put a value.
        }
    }
}
