package io.github.fatimazza.footballclub.teamdetail

import com.google.gson.Gson
import io.github.fatimazza.footballclub.model.Team
import io.github.fatimazza.footballclub.model.TeamResponse
import io.github.fatimazza.footballclub.networking.ApiRepository
import io.github.fatimazza.footballclub.networking.TheSportDBApi
import io.github.fatimazza.footballclub.utils.TestContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class TeamDetailPresenterTest {

    @Mock
    private lateinit var view: TeamDetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamDetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamDetailPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeamDetail() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val teamId = "133604"

        GlobalScope.launch {
            `when`(gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(teamId))  ,
                    TeamResponse::class.java
            )).thenReturn(response)

            presenter.getTeamDetail(teamId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showTeamDetail(teams)
            Mockito.verify(view).hideLoading()
        }
    }
}