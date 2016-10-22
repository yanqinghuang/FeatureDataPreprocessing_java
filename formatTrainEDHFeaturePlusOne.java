import java.io.*;
import java.util.List;

import static java.lang.System.out;


/**
 * Created by yanqing on 2016/9/30.
 */
public class formatTrainEDHFeaturePlusOne {
    public static void main(String[] args) {

        modifyFileStyle("D:\\mpeg7fex_win32_v2\\EHDnegKnivesPlusOneFeature4.txt",
                "D:\\mpeg7fex_win32_v2\\EHDnegKnivesFeature4.txt");
    }

    public static void modifyFileStyle(String testDst, String src) {
        int maxIndex = 0;
        int[] maxSumArr = new int[5];
        File testFile = new File(testDst);
        String line;
        try {
            InputStream fis = new FileInputStream(src);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String writeLine = "-1";
            BufferedWriter testOut = new BufferedWriter(new OutputStreamWriter(
                    new  FileOutputStream(testFile, true)));

            while ((line = br.readLine()) != null) {
                int maxSum = 0;
                int[][][] featureArr= new int[4][4][5];
                String[] inputArr = line.toString().split(" ");
                int index = 1;
                int l=1;
                for (int i=0; i<4; i++) {
                    for (int j=0; j<4; j++) {
                        for (int k=0; k<5; k++) {
                            featureArr[i][j][k] = Integer.parseInt(inputArr[l].split(":")[1]);
                            writeLine += " " + (index++) + ":" + inputArr[l].split(":")[1];
                            l++;
                        }
                    }
                }
                for (int i=0; i<4; i++) {
                    for (int j=0; j<4; j++) {
                        for (int k=0; k<5; k++) {
                            System.out.print(featureArr[i][j][k]);
                        }
                        System.out.print(" ");
                    }
                    System.out.println();
                }

                //choose the max sum as a new feature value
                for (DirectEnum direct: DirectEnum.values()) {
                    int[] sumArr = new int[5];
                    List<String> list  = direct.getCoordinate();
                    for(String coordinate : list){
                        int x = Integer.parseInt(coordinate.split(",")[0]);
                        int y = Integer.parseInt(coordinate.split(",")[1]);
                        for(int i=0; i<5; i++){
                            sumArr[i] += featureArr[x][y][i];
                        }
                    }
                    System.out.print("Index: " + direct.getIndex() + "; Sum: ");
                    for(int sum : sumArr){
                        System.out.print(sum + " ");
                        if(sum > maxSum){
                            maxIndex = direct.getIndex();
                            maxSum = sum;
                        }
                    }
                    System.out.println();
                }
                System.out.println("MaxIndex: " + maxIndex + "; Sum: " + maxSum);
                writeLine += " 81:" + maxSum;
                testOut.write(writeLine + "\r\n");
                testOut.flush();
                writeLine = "-1";
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
