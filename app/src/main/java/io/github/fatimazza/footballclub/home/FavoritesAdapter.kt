package io.github.fatimazza.footballclub.home

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import io.github.fatimazza.footballclub.R
import io.github.fatimazza.footballclub.R.id.team_badge
import io.github.fatimazza.footballclub.R.id.team_name
import io.github.fatimazza.footballclub.database.Favorite
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class FavoritesAdapter(private val favorite: List<Favorite>, private val listener: (Favorite) -> Unit)
    : RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(TeamUI().createView(
                AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(favorite[position], listener)
    }

    override fun getItemCount(): Int = favorite.size
}

class TeamUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {

                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = team_badge
                    backgroundColor = Color.GRAY
                }.lparams(width = dip(50), height = dip(50))

                textView {
                    id = team_name
                    textSize = 16f
                    text = ctx.getText(R.string.team_detail)
                }.lparams{
                    margin = dip(15)
                }

            }
        }
    }
}

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(team_badge)
    private val teamName: TextView = view.find(team_name)

    fun bindItem(favorite: Favorite, listener: (Favorite) -> Unit) {
        Picasso.get().load(favorite.teamBadge).into(teamBadge)
        teamName.text = favorite.teamName
        itemView.onClick { listener(favorite) }
    }

}