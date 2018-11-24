package io.github.fatimazza.footballclub.teamdetail

import com.google.gson.Gson
import io.github.fatimazza.footballclub.model.TeamResponse
import io.github.fatimazza.footballclub.networking.ApiRepository
import io.github.fatimazza.footballclub.networking.TheSportDBApi
import io.github.fatimazza.footballclub.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson,
                          private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamDetail(teamId: String) {

        view.showLoading()

        GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(teamId)),
                    TeamResponse::class.java
            )

            view.showTeamDetail(data.teams)
            view.hideLoading()
        }

    }

}
