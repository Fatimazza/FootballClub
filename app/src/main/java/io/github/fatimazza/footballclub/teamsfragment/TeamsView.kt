package io.github.fatimazza.footballclub.teamsfragment

import io.github.fatimazza.footballclub.model.Team

interface TeamsView {

    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)

}