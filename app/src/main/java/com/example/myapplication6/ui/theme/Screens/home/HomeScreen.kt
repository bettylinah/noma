package com.example.myapplication6.ui.theme.Screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication6.R
import com.example.myapplication6.navigation.ROUTE_DISASTER
import com.example.myapplication6.navigation.ROUTE_HOTLINE

@Composable
fun HomeScreen(navController: NavController){

    Box(
        modifier = Modifier.fillMaxSize() // Fills the entire screen
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.pic1
            ), // Replace with your image resource
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize() // Fills the entire Box area
        )

        // Column for centered content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)

        ) {

            // Welcome Text

            Text(
                text = "Welcome to Home Page",
                onTextLayout = {},
                color = Color.White,
                fontSize =30.sp,
                // Ensure text is visible on any background
            ) // Add some bottom padding
            Spacer(modifier = Modifier.height(20.dp))

            // Submit Button
            Button(onClick = {
                navController.navigate(ROUTE_DISASTER)
            },modifier = Modifier.fillMaxWidth()) {
                Text(text = "Report Issue",
                    onTextLayout = {})
            }
            Button(onClick = {
                navController.navigate(ROUTE_HOTLINE)
            },modifier = Modifier.fillMaxWidth()) {
                Text(text = "Hotline Number",
                    onTextLayout = {})
            }

        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}
