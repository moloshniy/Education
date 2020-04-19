package com.example.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity(), Fragment0.Fr0Finish{
private val navController:NavController by lazy {
    findNavController(R.id.nav_host_fragment)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController.navigate(R.id.action_fragment1_to_fragment0)
    }

    override fun finish0() {
        navController.popBackStack()
    }

}
