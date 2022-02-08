package com.ersubhadip.instantweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.transition.FragmentTransitionSupport
import com.ersubhadip.instantweather.R
import com.ersubhadip.instantweather.viewmodel.MainViewModel
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    //todo:setup accent color
    //todo:font
    //todo:fragment transaction deprecate -> NavGraph
    //todo:colors.xml
    //todo:current weather fragment -> ?
    //todo:forced white theme

    lateinit var vm:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting up navBar
        val bottomNavigation:MeowBottomNavigation=findViewById(R.id.bottomNavigationView)
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_forecast))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_weather))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_graph))

        bottomNavigation.show(2,true)

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1->Toast.makeText(this@MainActivity,"Forecast",LENGTH_SHORT).show()

                2->Toast.makeText(this@MainActivity,"Home",LENGTH_SHORT).show()

                3->Toast.makeText(this@MainActivity,"Weather Analytics",LENGTH_SHORT).show()

                else -> Toast.makeText(this@MainActivity,"Hello",LENGTH_SHORT).show()
            }
        }


//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController

        vm = ViewModelProvider(this)[MainViewModel::class.java];
        GlobalScope.launch (Dispatchers.Main){

            vm.getCurrentWeatherVM()

        }



    }


}