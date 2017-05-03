package zhouyou.freedom;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * 作者：ZhouYou
 * 日期：2017/5/3.
 */
public class StoreFileUtils {

    private static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    private static final String FILE_NAME = "test.txt";

    public void saveFile() {
        File f = new File(PATH, FILE_NAME);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
