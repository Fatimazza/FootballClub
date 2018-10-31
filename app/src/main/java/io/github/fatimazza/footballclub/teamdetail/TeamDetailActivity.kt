package io.github.fatimazza.footballclub.teamdetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.setContentView

class TeamDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TeamDetailUI().setContentView(this)
    }

    class TeamDetailUI: AnkoComponent<TeamDetailActivity> {
        override fun createView(ui: AnkoContext<TeamDetailActivity>): View {
            return with(ui) {
                linearLayout {  }
            }
        }
    }
}
