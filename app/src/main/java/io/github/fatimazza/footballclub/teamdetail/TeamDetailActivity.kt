package io.github.fatimazza.footballclub.teamdetail

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import io.github.fatimazza.footballclub.R
import io.github.fatimazza.footballclub.R.color.colorAccent
import io.github.fatimazza.footballclub.R.color.colorPrimaryDark
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class TeamDetailActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    private lateinit var teamBadge: ImageView
    private lateinit var teamName: TextView
    private lateinit var teamFormedYear: TextView
    private lateinit var teamStadium: TextView
    private lateinit var teamDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TeamDetailUI().setContentView(this)

        supportActionBar?.title = getString(R.string.team_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class TeamDetailUI: AnkoComponent<TeamDetailActivity> {
        override fun createView(ui: AnkoContext<TeamDetailActivity>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.VERTICAL
                    backgroundColor = Color.WHITE

                    owner.swipeRefresh = swipeRefreshLayout {
                        setColorSchemeResources(
                                colorAccent,
                                android.R.color.holo_green_light,
                                android.R.color.holo_orange_light,
                                android.R.color.holo_red_light
                        )

                        scrollView {
                            isVerticalScrollBarEnabled = false
                            relativeLayout {
                                lparams(width = matchParent, height = wrapContent)

                                linearLayout {
                                    lparams(width = matchParent, height = wrapContent)
                                    padding = dip(10)
                                    orientation = LinearLayout.VERTICAL
                                    gravity = Gravity.CENTER_HORIZONTAL

                                    owner.teamBadge = imageView{}
                                            .lparams(height = dip(75))

                                    owner.teamName = textView {
                                        this.gravity = Gravity.CENTER
                                        textSize = 20f
                                        textColor = ContextCompat.getColor(
                                                context, colorAccent
                                        )
                                    }.lparams{ topMargin = dip(5) }

                                    owner.teamFormedYear = textView {
                                        this.gravity= Gravity.CENTER
                                    }

                                    owner.teamStadium = textView {
                                        this.gravity = Gravity.CENTER
                                        textColor = ContextCompat.getColor(
                                                context, colorPrimaryDark
                                        )
                                    }

                                    owner.teamDescription = textView()
                                            .lparams{topMargin = dip(20)}

                                }

                                owner.progressBar = progressBar {  }
                                        .lparams{ centerHorizontally() }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
