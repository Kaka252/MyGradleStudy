package tasks.demo

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyTask extends DefaultTask {

    private static final String FILE_PATH = "app/src/main/assets"
    private static final String FILE_NAME = "test.txt"

    private static final String BASE_URL = "https://github.com"
    private HTTPBuilder http

    @TaskAction
    def executeTask() {
        println("Hello")
        http = new HTTPBuilder(BASE_URL)
        http.request(Method.GET, ContentType.JSON) {

//            uri.path = "/Kaka252"
//            response.success = {
//
//            }
        }

    }

}