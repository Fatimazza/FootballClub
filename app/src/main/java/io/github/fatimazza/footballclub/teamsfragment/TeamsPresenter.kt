package io.github.fatimazza.footballclub.teamsfragment

import com.google.gson.Gson
import io.github.fatimazza.footballclub.model.TeamResponse
import io.github.fatimazza.footballclub.networking.ApiRepository
import io.github.fatimazza.footballclub.networking.TheSportDBApi
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    fun getTeamList(league: String?) {

        GlobalScope.launch {
            delay(5000)
            println("Hello Kotlin Coroutine")
        }

        view.showLoading()

        GlobalScope.async(UI) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(
                                TheSportDBApi.getTeams(league)),
                                TeamResponse::class.java)
            }
            view.showTeamList(data.await().teams)
            view.hideLoading()
        }

    }
}

