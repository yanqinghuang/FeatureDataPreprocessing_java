import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;


/**
 * Created by yanqing on 2016/9/30.
 */
public class formatNegEDHFeaturePlusOne {
    public static void main(String[] args) {

        modifyFileStyle("D:\\mpeg7fex_win32_v2\\EHDnegKnivesPlusOneFeature.txt",
                "D:\\mpeg7fex_win32_v2\\EHDnegKnives.txt");
    }

    public static void modifyFileStyle(String testDst, String src) {
        List<Integer> excludeList = Arrays.asList(13, 14, 3176,3177,3178,3179,3675,3676,3677,3678,3679,3680,3723,
            3729,3848,3830,13870,3942,4045,4044,4285,4809,6403);
        int lineNum = 0;
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
                String[] inputArr = line.toString().split(" ");
                for (int i=1; i<inputArr.length; i++) {
                    writeLine += " " + i + ":" + inputArr[i];
                }
                if(excludeList.contains(lineNum)){
                    writeLine += " 81:1" ;
                }else {
                    writeLine += " 81:0" ;
                }
                testOut.write(writeLine + "\r\n");
                testOut.flush();
                writeLine = "-1";
                lineNum++;
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
