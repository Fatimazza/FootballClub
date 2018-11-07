package io.github.fatimazza.footballclub.teamsfragment

import com.google.gson.Gson
import io.github.fatimazza.footballclub.model.TeamResponse
import io.github.fatimazza.footballclub.networking.ApiRepository
import io.github.fatimazza.footballclub.networking.TheSportDBApi
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    fun getTeamList(league: String?) {

        launch {
            delay(5000)
            println("Hello Kotlin Coroutine")
        }

        view.showLoading()
        doAsync {
            val data = gson
                    .fromJson(apiRepository.doRequest(
                            TheSportDBApi.getTeams(league)),
                            TeamResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}

