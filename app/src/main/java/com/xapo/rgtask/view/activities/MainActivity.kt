package com.xapo.presentation.view.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.xapo.githubtask.R
import kotlinx.android.synthetic.main.activity_main_layout.*


class MainActivity : AppCompatActivity() {
    private val navigationController: NavController by lazy { findNavController(R.id.fragment_base_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        setToolbar()
    }

    private fun setToolbar() {
        activity_base_toolbar_main?.run {
            setSupportActionBar(this)
            setupWithNavController(
                    navController = navigationController,
                    configuration = AppBarConfiguration(navigationController.graph)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.fragment_login -> {
                //navigationController.navigate(R.id.global_action_open_login)
                navigationController.navigate(
                        R.id.fragment_login, null, NavOptions.Builder()
                        .setPopUpTo(R.id.fragment_a, true)
                        .build()
                )
                activity_base_toolbar_main.setupWithNavController(
                        navController = navigationController,
                        configuration = AppBarConfiguration(navigationController.graph)
                )
                super.onOptionsItemSelected(item)

            }
            else -> item.onNavDestinationSelected(navigationController)
        }
    }
}
