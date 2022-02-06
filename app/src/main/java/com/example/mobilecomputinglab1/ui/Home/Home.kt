package com.example.mobilecomputinglab1.ui.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun Home(navController: NavController){
    var remindersList : Array<String> = arrayOf("a", "b", "c")
    val sb = StringBuilder()
    for (i in 0 until remindersList.count()) {
        sb.append(remindersList.get(i)).append(",")
    }
//    val context = LocalContext.current
//    val pref = context.getSharedPreferences("Reminders", 0)
//    val editor = pref.edit()
//    editor.putString("Reminders",sb.toString())
////    editor.putStringSet("username", "Marwa") // Storing string
////    editor.putString("password", "1234") // Storing string
//    editor.commit() // commit changes
    Scaffold(
        modifier = Modifier.padding(bottom = 24.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(route = "payment") },
                contentColor = Color.Blue,
                modifier = Modifier.padding(all = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxWidth()
        ) {

            HomeAppBar(navController = navController)

//            CategoryTabs(
//                categories = categories,
//                selectedCategory = selectedCategory,
//                onCategorySelected = onCategorySelected,
//            )

//Set the values

//Set the values
//            val context = LocalContext.current
//            val pref = context.getSharedPreferences("Reminders", 0)
//            val editor = pref.edit()
//            val ReminderslistString = pref.getString("Reminders",null)
//            val Reminderslist = ReminderslistString?.split(",");

            val Reminderslist = arrayOf("Pray", "Eat", "Exercise")
            ReminderList(reminders = Reminderslist)
//            CalendarContract.Reminders(
//                modifier = Modifier.fillMaxSize()
//            )
        }
    }

}


@Composable
private fun HomeAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Your Reminders",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        backgroundColor = Color.Blue,
        actions = {
//            IconButton( onClick = {} ) {
//                Icon(imageVector = Icons.Filled.Search, contentDescription = stringResource(R.string.search))
//            }
            IconButton( onClick = {
                navController.navigate("login") {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
//                navController.navigate("login")
            }) {
                Icon(imageVector = Icons.Outlined.ExitToApp, contentDescription = "Logout",tint = Color.White)
            }
        }
    )
}
