package com.example.myapplication6.ui.theme.Screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication6.data.AuthViewModel
import com.example.myapplication6.navigation.ROUTE_HOME
import com.example.myapplication6.navigation.ROUTE_LOGIN
import com.example.myapplication6.ui.theme.Purple40

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally) {


        Text(
            text = "Register here",
            onTextLayout = {},
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email",
                onTextLayout = {}) },
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

        OutlinedTextField(
            value = pass, onValueChange = { pass = it },
            label = { Text(text = "Enter Password",
                onTextLayout = {}) },
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
                Icon(imageVector = Icons.Default.Lock, contentDescription = "lock")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmpass, onValueChange = { confirmpass = it },
            label = { Text(text = "Confirm Pass",
                onTextLayout = {}) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Purple40 ,
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
                Icon(imageVector = Icons.Default.Lock, contentDescription = "name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val myregister= AuthViewModel(navController,context)
            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
            navController.navigate(ROUTE_HOME)




        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ",
                onTextLayout ={}
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Have an Account? Click to Login",
                onTextLayout ={}
            )
        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())

}