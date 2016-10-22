import java.io.*;
import java.util.*;

import static java.lang.System.out;


/**
 * Created by yanqing on 2016/9/30.
 */
public class formatEDHFeatureInput {
    public static void main(String[] args) {

        modifyFileStyle("D:\\mpeg7fex_win32_v2\\EHDposKnivesFeatureTest.txt",
                "D:\\mpeg7fex_win32_v2\\EHDposKnivesFeatureTrain.txt",
                "D:\\mpeg7fex_win32_v2\\EHDposKnives.txt");
    }


    public static void modifyFileStyle(String testDst, String trainDst, String src) {
        File testFile = new File(testDst);
        File trainFile = new File(trainDst);
        Random random = new Random();
        String line;
        try {
            InputStream fis = new FileInputStream(src);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String writeLine = "+1";
            BufferedWriter testOut = new BufferedWriter(new OutputStreamWriter(
                    new  FileOutputStream(testFile, true)));
            BufferedWriter trainOut = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(trainFile, true)));
            while ((line = br.readLine()) != null) {
                String[] inputArr = line.toString().split(" ");
                for (int i=1; i<inputArr.length; i++) {
                    writeLine += " " + i + ":" + inputArr[i];
                }
                // 1/9 as sample images
                if(random.nextInt(10)==1){
                    testOut.write(writeLine + "\r\n");
                    testOut.flush();
                }else{
                    trainOut.write(writeLine + "\r\n");
                    trainOut.flush();
                }
                writeLine = "+1";
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
