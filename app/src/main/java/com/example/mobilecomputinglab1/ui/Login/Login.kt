package com.example.mobilecomputinglab1.ui.Login

import android.content.Context
import android.content.Context.MODE_APPEND
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding
import androidx.test.core.app.ApplicationProvider.getApplicationContext as getApplicationContext1

    @Composable
    fun Login(navController: NavController) {
        val context = LocalContext.current
        val pref = context.getSharedPreferences("MyPref",0)
//        editor.putString("username", "Marwa") // Storing string
//        editor.putString("password", "1234") // Storing string
//        editor.commit() // commit changes

        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            val username = rememberSaveable { mutableStateOf("") }
            val password = rememberSaveable { mutableStateOf("") }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .systemBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Login", modifier= Modifier.fillMaxWidth(),color = Color.DarkGray,
                    fontSize = 60.sp,textAlign = TextAlign.Center)
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = username.value,
                    onValueChange = { data -> username.value = data },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password.value,
                    onValueChange = { data -> password.value = data },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                   var name = pref.getString("username", "")// getting String
                   val pass = pref.getString("password", "") // getting string
                        Log.i("print","name="+name)
                        Log.i("print","username="+username)
                        if (username.value == "marwa"){
                       Log.i("print",name.toString())
                       Log.i("print",username.toString())


                       Log.i("print","username equal")
                       if (password.value == "1234"){
                          Log.i("print","passwords are equal")
                           // login here go to home screen
                           navController.navigate("home")
                       }
                       else {
                           Log.i("print","passwords not equal")
                           // alert
//
                           val myToast = Toast.makeText(context,"Password incorrect",Toast.LENGTH_LONG)
                           myToast.show()
                       }
                   }
                   else {
                       //alert
                       Log.i("print","username not equal"+name)
                       val myToast = Toast.makeText(context,"Username incorrect",Toast.LENGTH_LONG)
                       myToast.show()
                   }

                    },
                    enabled = true,
                    modifier = Modifier
                        .height(55.dp)
                        .width(250.dp),
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Login")
                }


                Spacer(modifier = Modifier.height(10.dp))
                TextButton(
                    onClick = {
                   navController.navigate("signup")
                    },
                    enabled = true,
                    modifier = Modifier
                        .height(35.dp)
                        .width(250.dp),
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Blue
                    )
                ) {
                    Text(text = "Create a new account")
                }
            }// end colomn


        }//end surface


    }// end Login


//@Preview
//@Composable
//fun preview(){
//    Login()
//}
