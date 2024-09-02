package com.example.valowiki

import android.app.ActionBar
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.valowiki.adapters.HomeAdapter
import com.example.valowiki.databinding.ActivityMainBinding
import com.example.valowiki.models.HomeScreenModel
import com.example.valowiki.uis.Agents
import com.google.android.material.navigation.NavigationView
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HomeAdapter
    private lateinit var list: ArrayList<HomeScreenModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set up Toolbar
//        setSupportActionBar(binding.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView


        binding.hamburgerIcon.setOnClickListener {

            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START)
            } else {
                Log.d("Hamburger", "Drawer already open")
            }
        }



        with(binding){
            list= ArrayList()
            list.add(HomeScreenModel("Agents",R.drawable.agentthird))
            list.add(HomeScreenModel("Weapons",R.drawable.weapons))
            list.add(HomeScreenModel("Maps",R.drawable.maps))
            list.add(HomeScreenModel("Cards",R.drawable.playercard))
            list.add(HomeScreenModel("Tiers",R.drawable.largeicontier))
            list.add(HomeScreenModel("Agents",R.drawable.agentthird))
            list.add(HomeScreenModel("Agents",R.drawable.agentthird))
            list.add(HomeScreenModel("Agents",R.drawable.agentthird))
            list.add(HomeScreenModel("Agents",R.drawable.agentthird))



            adapter= HomeAdapter(list,this@MainActivity)
            rvAgent.adapter=adapter


        }
    }

}



