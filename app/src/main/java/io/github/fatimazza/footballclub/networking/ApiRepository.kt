package io.github.fatimazza.footballclub.networking;

import java.net.URL

public class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}
