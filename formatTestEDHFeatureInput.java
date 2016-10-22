import java.io.*;
import java.util.Random;

import static java.lang.System.out;


/**
 * Created by yanqing on 2016/9/30.
 */
public class formatTestEDHFeatureInput {
    public static void main(String[] args) {

        modifyFileStyle("D:\\mpeg7fex_win32_v2\\myEHDKnivesFeature_112.txt",
                "D:\\mpeg7fex_win32_v2\\myEHDtest_112.txt");
    }

    public static void modifyFileStyle(String testDst, String src) {
        File testFile = new File(testDst);
        String line;
        try {
            InputStream fis = new FileInputStream(src);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String writeLine;
            int lineNum = 0;
            BufferedWriter testOut = new BufferedWriter(new OutputStreamWriter(
                    new  FileOutputStream(testFile, true)));

            while ((line = br.readLine()) != null) {
                String[] inputArr = line.toString().split(" ");
                if(lineNum<63) {
                    writeLine = "+1";
                } else {
                    writeLine = "-1";
                }
                for (int i=1; i<inputArr.length; i++) {
                    writeLine += " " + i + ":" + inputArr[i];
                }
                testOut.write(writeLine + "\r\n");
                testOut.flush();
                lineNum++;
            }
            System.out.print(lineNum);
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
