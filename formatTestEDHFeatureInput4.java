import java.io.*;

import static java.lang.System.out;


/**
 * Created by yanqing on 2016/9/30.
 */
public class formatTestEDHFeatureInput4 {
    public static void main(String[] args) {

        modifyFileStyle("D:\\mpeg7fex_win32_v2\\EHDnegKnivesFeatureTrain4.txt",
                "D:\\mpeg7fex_win32_v2\\EHDnegKnives.txt");
    }

    public static void modifyFileStyle(String testDst, String src) {
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
                int[][][] arrInput = new int[4][4][5];
                String[] inputArr = line.toString().split(" ");
                int index = 1;
                int l=1;
                for (int i=0; i<4; i++) {
                    for (int j=0; j<4; j++) {
                        for (int k=0; k<5; k++) {
                            arrInput[i][j][k] = Integer.parseInt(inputArr[l]);
                            writeLine += " " + (index++) + ":" + inputArr[l];
                            l++;
                        }
                    }
                }

                for (int i=0; i<4; i++) {
                    for (int j=0; j<4; j++) {
                        for (int k=0; k<5; k++) {
                            System.out.print(arrInput[i][j][k]);
                        }
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                testOut.write(writeLine + "\r\n");
                testOut.flush();

                // rotate 90 clockwise
                writeLine = "-1";
                index=1;
                for (int j=0; j<4; j++) {
                    for (int i=3; i>=0; i--) {
                        writeLine += " " + (index++) + ":" + arrInput[i][j][1];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][0];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][3];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][2];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][4];
                    }
                }
                System.out.println("90: " + writeLine);
                testOut.write(writeLine + "\r\n");
                testOut.flush();

                // rotate 180 clockwise
                writeLine = "-1";
                index = 1;
                for (int i=3; i>=0; i--) {
                    for (int j=3; j>=0; j--) {
                        for(int k=0; k<5; k++)
                        writeLine += " " + (index++) + ":" + arrInput[i][j][k];
                    }
                }
                System.out.println("180: " + writeLine);
                testOut.write(writeLine + "\r\n");
                testOut.flush();

                // rotate 270 clockwise
                writeLine = "-1";
                index=1;
                for (int j=3; j>=0; j--) {
                    for (int i=0; i<4; i++) {
                        writeLine += " " + (index++) + ":" + arrInput[i][j][1];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][0];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][3];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][2];
                        writeLine += " " + (index++) + ":" + arrInput[i][j][4];
                    }
                }
                System.out.println("270: " + writeLine);
                System.out.println();

                testOut.write(writeLine + "\r\n");
                testOut.flush();
                writeLine = "-1";
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
