package com.example.myapplication6.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication6.ui.theme.Screens.disaster.DisasterScreen
import com.example.myapplication6.ui.theme.Screens.home.HomeScreen
import com.example.myapplication6.ui.theme.Screens.hotline.HotlineScreen

import com.example.myapplication6.ui.theme.Screens.login.LoginScreen
import com.example.myapplication6.ui.theme.Screens.register.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String= ROUTE_REGISTER) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) { HomeScreen(navController) }
        composable(ROUTE_DISASTER) { DisasterScreen(navController) }
        composable(ROUTE_REGISTER) { RegisterScreen(navController) }
        composable(ROUTE_LOGIN) { LoginScreen(navController) }
        composable(ROUTE_HOTLINE) { HotlineScreen(navController) }



//        composable(ROUTE_ADD_PRODUCT){ AddProductsScreen(navController)}
//        composable(ROUTE_VIEW_UPLOAD){ ViewUploadsScreen(navController)}
//        composable(ROUTE_UPDATE_PRODUCT+"/{id}"){
//                passedData ->
//            UpdateProductsScreen(
//                navController,passedData.arguments?.getString("id")!!
//            )
//        }
//        composable(ROUTE_VIEW_UPLOAD){ViewUploadsScreen(navController)}
    }
}