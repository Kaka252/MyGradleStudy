package tasks.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author: ZhouYou
 * Date: 2017/5/4.
 */
public class JavaDownloadTask {

    private static final String FILE_PATH = "app/src/main/assets";
    private static final String FILE_NAME = "test.txt";


    public void download() {
        Thread t = new Thread(new FileDownloader());
        t.start();
    }

    private static class FileDownloader implements Runnable {

        @Override
        public void run() {
            InputStream is = null;
            FileOutputStream os = null;
            try {
                URL url = new URL("https://www.baidu.com");
                URLConnection con = url.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0 Firefox/3.0.4");
                con.setConnectTimeout(30 * 1000);
                con.connect();
                File file = new File(FILE_PATH, FILE_NAME);
                is = con.getInputStream();
                byte[] bytes = new byte[1024 * 10];
                int len;
                os = new FileOutputStream(file);
                while ((len = is.read(bytes)) != -1) {
                    os.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (os != null) os.close();
                    if (is != null) is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
