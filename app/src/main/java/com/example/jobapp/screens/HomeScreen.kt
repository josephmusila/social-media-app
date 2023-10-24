package com.example.jobapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jobapp.AppComponents.PostComponent
import com.example.jobapp.AppComponents.StoriesComponent
import com.example.jobapp.AppComponents.TopAppBarComponent
import com.example.jobapp.R


@Composable
fun HomeScreen(){
    val scrollState= rememberScrollState()
    val images = listOf<Int>(R.drawable.cat,R.drawable.musila,R.drawable.code,R.drawable.bakg)
    Column(
        modifier= Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
//            .padding(16.dp)
    ) {
        TopAppBarComponent(title = "Home", icon = "H")
        StoriesComponent()

        (0 until 4).map {
            index -> PostComponent(
            userProfileImage = images[index],
            userName = "Michael Stark",
            datePosted = "Just now",
            postContentText = "Here some of the arguments are passed " +
                    "while calling a function and these are used as " +
                    "function parameters.",
            postContentImage = images[index],
            likeCount = "17k",
            commentCount = "3k",
            shareCount = "30k",
            isVerified = true,
                tags = "#technology  #AI #programming #art #mobiledev"
        )
        }


    }
}