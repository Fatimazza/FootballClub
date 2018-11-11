package io.github.fatimazza.footballclub.teamsfragment

import com.google.gson.Gson
import io.github.fatimazza.footballclub.networking.ApiRepository
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TeamsPresenterTest {

    @Mock
    private
    lateinit var view: TeamsView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson)
    }

    @Test
    fun testGetTeamList() {

    }
}