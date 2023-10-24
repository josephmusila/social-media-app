package com.example.jobapp.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.jobapp.AppComponents.BottomNavigationComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(){
    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            BottomNavigationComponent(navController)
        }
    ){
        HomeScreen()
    }

}