package io.github.fatimazza.footballclub.main

import io.github.fatimazza.footballclub.model.Team

interface TeamsView {

    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)

}