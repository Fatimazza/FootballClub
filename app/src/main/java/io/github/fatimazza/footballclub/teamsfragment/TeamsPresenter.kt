package io.github.fatimazza.footballclub.teamsfragment

import com.google.gson.Gson
import io.github.fatimazza.footballclub.model.TeamResponse
import io.github.fatimazza.footballclub.networking.ApiRepository
import io.github.fatimazza.footballclub.networking.TheSportDBApi
import io.github.fatimazza.footballclub.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson,
                     private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamList(league: String?) {

        GlobalScope.launch {
            delay(5000)
            println("Hello Kotlin Coroutine")
        }

        view.showLoading()

        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository.doRequest(
                                TheSportDBApi.getTeams(league)),
                                TeamResponse::class.java)

            view.showTeamList(data.teams)
            view.hideLoading()
        }

    }
}

