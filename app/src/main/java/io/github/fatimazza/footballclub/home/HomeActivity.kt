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

        bottom_navigation.setOnNavigationItemReselectedListener {
            item -> when(item.itemId) {
                teams -> {}
                favorites -> {}
            }
            true
        }
        bottom_navigation.selectedItemId = teams
    }
}
