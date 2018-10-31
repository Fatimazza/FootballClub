package io.github.fatimazza.footballclub.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.fatimazza.footballclub.R
import io.github.fatimazza.footballclub.R.id.favorites
import io.github.fatimazza.footballclub.R.id.teams
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener {
            item -> when(item.itemId) {
                teams -> { loadTeamsFragment(savedInstanceState) }
                favorites -> { loadFavoritesFragment(savedInstanceState) }
            }
            true
        }
        bottom_navigation.selectedItemId = favorites
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
