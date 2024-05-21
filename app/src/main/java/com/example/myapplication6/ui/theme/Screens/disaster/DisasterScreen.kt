package com.example.myapplication6.ui.theme.Screens.disaster

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication6.data.ProductViewModel
import com.example.myapplication6.navigation.ROUTE_HOME
import com.example.myapplication6.ui.theme.Purple40

@Composable
fun DisasterScreen(navController: NavController){
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var telephone by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember{ mutableStateOf(TextFieldValue("")) }
    var context=LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "fill in the details",
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =name , onValueChange = {name=it},
            label = { Text(text = "Enter Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Purple40,
                unfocusedLeadingIconColor = Purple40,
                focusedLabelColor = Purple40,
                unfocusedLabelColor = Purple40,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Purple40,
                unfocusedIndicatorColor = Purple40,
                unfocusedPlaceholderColor = Purple40

            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =telephone , onValueChange = {telephone=it},
            label = { Text(text = "Enter Telephone number") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Purple40,
                unfocusedLeadingIconColor = Purple40,
                focusedLabelColor = Purple40,
                unfocusedLabelColor = Purple40,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Purple40,
                unfocusedIndicatorColor = Purple40,
                unfocusedPlaceholderColor = Purple40

            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "telephone")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Describe the issue:",
        )
        OutlinedTextField(
            value = description,
            onValueChange = {description =it},
            label = { Text("Write a detailed description") },
            modifier = Modifier.size(300.dp),
            maxLines = Integer.MAX_VALUE

        )
//        Button(
//            onClick = {
//                navController.navigate(ROUTE_PHOTOS)
//            },
//            modifier = Modifier,
//
//            ) {
//            Text(text = "Upload Images")
//        }


//        Button(onClick = {
//
//            val reportRepository = ImageViewModel(navController,context)
//            reportRepository.saveProduct(name.text.trim(),telephone.text.trim(),
//                report.text)
//            navController.navigate(ROUTE_HOME)
//
//
//        }) {
//            Text(text = "Save")
//        }
        Spacer(modifier = Modifier.height(20.dp))

        ImagePicker(Modifier, context, navController, name.text.trim(), telephone.text.trim(), description.text.trim())

    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier,
                context: Context,
                navController: NavController,
                name:String, telephone:String, description:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image",
                    onTextLayout = {}
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                val productRepository = ProductViewModel(navController,context)
                productRepository.saveProduct(name, telephone, description)
                navController.navigate(ROUTE_HOME)

            }) {
                Text(text = "Save",
                    onTextLayout = {})
            }
            Button(onClick = {
                val productRepository = ProductViewModel(navController,context)
                productRepository.saveProductWithImage(name, telephone, description,imageUri!!)
                navController.navigate(ROUTE_HOME)

                navController.navigate(ROUTE_HOME)

            }) {
                Text(text = "Home",
                    onTextLayout = {})
            }

        }
    }
}
@Preview
@Composable
fun DisasterScreenPreview(){
    DisasterScreen(rememberNavController())
}
