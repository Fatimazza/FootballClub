package io.github.fatimazza.footballclub.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.fatimazza.footballclub.R
import io.github.fatimazza.footballclub.R.id.favorites
import io.github.fatimazza.footballclub.R.id.teams
import io.github.fatimazza.footballclub.favoritesfragment.FavoritesFragment
import io.github.fatimazza.footballclub.teamsfragment.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*
import android.os.StrictMode

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        bottom_navigation.setOnNavigationItemSelectedListener {
            item -> when(item.itemId) {
                teams -> { loadTeamsFragment(savedInstanceState) }
                favorites -> { loadFavoritesFragment(savedInstanceState) }
            }
            true
        }
        bottom_navigation.selectedItemId = teams
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(),
                            TeamsFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoritesFragment(),
                            FavoritesFragment::class.java.simpleName)
                    .commit()
        }
    }
}
