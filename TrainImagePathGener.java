import java.io.*;

/**
 * Created by yanqing on 2016/9/29.
 */
public class TrainImagePathGener {
    public static void main(String[] args) {

        method1("D:\\mpeg7fex_win32_v2\\imagesTest_112.txt");
    }

    public static void method1(String file) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
           // for (int i = 10000; i < 19340; i++) {
            for (int i = 0; i < 112; i++) {
                out.write("images/test/" + i + ".bmp\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
