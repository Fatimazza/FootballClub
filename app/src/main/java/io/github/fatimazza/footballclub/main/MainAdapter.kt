package io.github.fatimazza.footballclub.main

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.fatimazza.footballclub.model.Team

class MainAdapter(private val teams: List<Team>) {

}

class TeamViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(teams: Team) {
        
    }

}