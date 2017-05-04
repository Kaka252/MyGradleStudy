package tasks.demo

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyTask extends DefaultTask {

    private static final String FILE_PATH = "app/src/main/assets";
    private static final String FILE_NAME = "test.txt";

    @TaskAction
    def downloadFile() {
        println("Start Download")

        def connection = new URL("https://www.baidu.com").openConnection()
        connection.setRequestProperty('User-Agent', 'Mozilla/5.0 Firefox/3.0.4')
        connection.doOutput = true
        connection.connect()

        def text = connection.content.text

        def bytes = text.getBytes("utf-8") as byte[]
        def file = new File(FILE_PATH, FILE_NAME);
        def fos = new FileOutputStream(file)
        fos.write(bytes)
        fos.flush()
        fos.close()
        println("Complete Download")
    }

}