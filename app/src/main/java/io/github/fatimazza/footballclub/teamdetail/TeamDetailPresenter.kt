package io.github.fatimazza.footballclub.teamdetail

import com.google.gson.Gson
import io.github.fatimazza.footballclub.model.TeamResponse
import io.github.fatimazza.footballclub.networking.ApiRepository
import io.github.fatimazza.footballclub.networking.TheSportDBApi
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getTeamDetail(teamId: String) {

        view.showLoading()

        async(UI) {
            val data = bg {
                gson.fromJson(
                        apiRepository.doRequest(
                                TheSportDBApi.getTeamDetail(teamId)),
                        TeamResponse::class.java
                )
            }
            view.showTeamDetail(data.await().teams)
            view.hideLoading()
        }

    }

}
