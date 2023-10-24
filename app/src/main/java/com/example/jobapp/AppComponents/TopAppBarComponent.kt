package com.example.jobapp.AppComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jobapp.R


@Composable
fun TopAppBarComponent(title:String,icon:String){
    Card(
        colors=CardDefaults.cardColors(Color.White),
        elevation =CardDefaults.cardElevation(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row (
        ){
            TextComponent(textValue = "Home", textSize = 20.sp, fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.weight(1f))
//            TextComponent(textValue = "H", textSize = 15.sp )
            Image(painter = painterResource(id = R.drawable.search),
                modifier= Modifier
                    .padding(4.dp)
                    .size(30.dp),
                contentDescription = "Search")
        }

    }
}

@Composable
fun TextComponent(textValue:String,textSize:TextUnit,fontWeight:FontWeight?=null,modifier:Modifier?=null){
    Text(text = textValue,
        fontSize = textSize,
        fontWeight=fontWeight,
        modifier = Modifier.padding(8.dp))
}

@Composable
fun StoryCardComponent(label:String,image:Int){
    Column(
        modifier = Modifier
            .padding(end = 8.dp, start = 10.dp)

    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
//                .padding(3.dp)
                .border(2.dp, Color.Blue, CircleShape),
            contentDescription = "Story Image"
        )
        TextComponent(textValue = label, textSize = 12.sp,fontWeight = FontWeight.Light)
    }
}

@Composable
fun StoriesComponent(){
    val scrollState= rememberScrollState()
    Row (
        modifier=Modifier.horizontalScroll(scrollState)
    ){
        StoryCardComponent("@Catty",R.drawable.cat)
        StoryCardComponent("@Catty",R.drawable.cat)
        StoryCardComponent("@Catty",R.drawable.cat)
        StoryCardComponent("@Catty",R.drawable.cat)
        StoryCardComponent("@Catty",R.drawable.cat)
        StoryCardComponent("@Catty",R.drawable.cat)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PostComponent(
    userProfileImage:Int,
    userName:String,
    datePosted:String,
    isVerified:Boolean,
    postContentText:String,
    postContentImage:Int,
    likeCount:String,
    commentCount:String,
    shareCount:String,
    tags:String?=null
){
    ConstraintLayout(
        modifier= Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 20.dp, end = 8.dp, bottom = 4.dp)
    ) {
        val(
            profileImage,
            username,
            moreInfoIcon,
            contentText,
            timePosted,
            divider,
            activeIndicator,
            postTags,
            postStats,
            verifiedIcon,
            contentImage)= createRefs()
        Image(
            painter = painterResource(id = userProfileImage),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(profileImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .size(50.dp)
                .clip(CircleShape),
            contentDescription = "Story Image"
        )

        Column(
            modifier= Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .constrainAs(activeIndicator){
                    bottom.linkTo(profileImage.bottom, margin = 16.dp)
                    start.linkTo(profileImage.start)
                    end.linkTo(profileImage.end)
                }
        ) {
            Box(modifier = Modifier
                .size(10.dp)
                .background(Color.Green)
                .clip(CircleShape))
        }

        Text(text = userName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.constrainAs(username){
            start.linkTo(profileImage.end, margin = 16.dp)
            top.linkTo(parent.top)
                },
            )

        Text(text = datePosted,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            modifier=Modifier.constrainAs(timePosted){
                start.linkTo(profileImage.end, margin = 16.dp)
                top.linkTo(username.bottom)
            },
        )

        Image(painter = painterResource(id = R.drawable.verified_icon),
            modifier= Modifier
                .size(20.dp)
                .constrainAs(verifiedIcon) {
                    start.linkTo(username.end, margin = 16.dp)
                    top.linkTo(parent.top)
                },
            contentDescription ="Verified Icon" )

        Image(painter = painterResource(id = R.drawable.more_info),
            modifier= Modifier
                .size(20.dp)
                .constrainAs(moreInfoIcon) {
                    end.linkTo(parent.end, margin = 18.dp)
                    top.linkTo(parent.top)
                },
            contentDescription ="More info" )

        Text(text = postContentText,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            modifier=Modifier.constrainAs(contentText){
                start.linkTo(parent.start, margin = 8.dp)
                end.linkTo(parent.end)
                top.linkTo(profileImage.bottom, margin = 16.dp)
            },
        )

        Text(text = tags?:"",
            fontSize = 12.sp,
            color=Color.Blue,
            fontWeight = FontWeight.Normal,
            modifier=Modifier.constrainAs(postTags){
                start.linkTo(parent.start, margin = 4.dp)
                end.linkTo(parent.end)
                top.linkTo(contentText.bottom, margin = 8.dp)
            },
        )


        Image(painter = painterResource(id = postContentImage),
            contentScale=ContentScale.Crop,
            modifier= Modifier
//                .size(70.dp)
                .fillMaxWidth()
                .height(200.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(10.dp))
                .constrainAs(contentImage) {
                    end.linkTo(parent.end, margin = 4.dp)
                    top.linkTo(postTags.bottom, margin = 4.dp)
                    start.linkTo(parent.start, margin = 4.dp)
                },
            contentDescription ="More info" )

        Row (
            modifier=Modifier.constrainAs(postStats){
                start.linkTo(parent.start, margin = 8.dp)
                top.linkTo(contentImage.bottom, margin = 8.dp)

            }
        ){

            PostStats(count = likeCount, icon =R.drawable.like_icon )
            PostStats(count = commentCount, icon =R.drawable.comment_icon )
            PostStats(count = shareCount, icon =R.drawable.share )
        }

        Divider(color = Color.Gray,
            thickness=1.dp,
            modifier = Modifier.constrainAs(divider){
            top.linkTo(postStats.bottom, margin = 16.dp)
            start.linkTo(parent.start, margin = 8.dp)
            end.linkTo(parent.end, margin = 8.dp)
        })



    }
}
@Composable
fun PostStats(count:String,icon:Int){
    Row(
        modifier=Modifier.padding(end = 16.dp)
    ) {
        Image(painter = painterResource(id = icon), contentDescription ="likeIcon" )
        TextComponent(textValue = count.toString(), textSize =12.sp )
    }
}
