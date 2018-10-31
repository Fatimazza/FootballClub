package io.github.fatimazza.footballclub.teamdetail

import io.github.fatimazza.footballclub.model.Team

interface TeamDetailView {

    fun showLoading()

    fun hideLoading()

    fun showTeamDetail(data: List<Team>)

}