package com.example.jobapp.AppComponents

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

 open class BottomNavItem(val route:String, val icon:ImageVector, val  label:String){
    object  Home:BottomNavItem("home",Icons.Default.Home,"Home")
    object  Search:BottomNavItem("search",Icons.Default.Search,"Search")
    object  Profile:BottomNavItem("profile",Icons.Default.Person,"Profile")

    fun getObjects():List<BottomNavItem> {
        return  listOf(Home,Search,Profile)
    }

     companion object {
         fun getObjects(): List<BottomNavItem> {
             return  listOf(Home,Search,Profile)
         }
     }
 }

@Composable
fun BottomNavigationComponent(navController:NavController){
    BottomNavigation{
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute=navBackStackEntry?.destination?.route
        val items = BottomNavItem.getObjects()


        items.forEach{
            item->BottomNavigationItem(
            selected = currentRoute == item.route,
            onClick = {
//                      navController.navigate(item.route){
//                          popUpTo(navController.graph.startDestinationId)
//                      }
                      if (currentRoute != item.route){
                          navController.navigate(item.route)
                      }
            },
            icon = { Icon(item.icon,contentDescription=null)})
        }

    }
}