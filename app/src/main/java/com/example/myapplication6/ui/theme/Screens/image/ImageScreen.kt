package com.example.myapplication6.ui.theme.Screens.image

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//@Composable
//fun ImageScreen(modifier: Modifier = Modifier,
//                 context: Context, navController: NavHostController,
//                 name:String, telephone:String,
//                 report:String) {
//    var hasImage by remember { mutableStateOf(false) }
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//
//    val imagePicker = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent(),
//        onResult = { uri ->
//            hasImage = uri != null
//            imageUri = uri
//        }
//    )
//
//    Column(modifier = modifier,) {
//        if (hasImage && imageUri != null) {
//            val bitmap = MediaStore.Images.Media.
//            getBitmap(context.contentResolver,imageUri)
//            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
//        }
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
//            Button(
//                onClick = {
//                    imagePicker.launch("image/*")
//                },
//            ) {
//                //Text(
//                //  text = "Select Image"
//                // )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // Button(onClick = {
//            //-----------WRITE THE UPLOAD LOGIC HERE---------------//
//            //var reportRepository = ImageViewModel(navController,context)
//            // reportRepository.saveProductWithImage(name, telephone, report,imageUri!!)
//            //navController.navigate(ROUTE_VIEW_UPLOAD)
//
//            // }) {
//            //    Text(text = "Upload")
//        }
////            Button(onClick = {
////                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
////
////                navController.navigate(ROUTE_VIEW_UPLOAD)
////
////            }) {
////               Text(text = "Save")
////            }
//
//    }
//}
////}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ImageScreenPreview() {
//    ImageScreen(rememberNavController())
//}