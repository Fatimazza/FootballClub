package io.github.fatimazza.footballclub.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.github.fatimazza.footballclub.model.Team
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.linearLayout

class MainAdapter(private val teams: List<Team>)
    : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: TeamViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class TeamUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {  }
        }
    }
}

class TeamViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(teams: Team) {
        
    }

}