package com.marcodeb.piaandroiduppgift1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// THE FIX: Added the Activity class that actually starts the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // This tells the phone to run your navigation logic on startup
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            PiaScreen2(navController)
        }
        composable("details") {
            DetailsScreen()
        }
    }
}

@Composable
fun PiaScreen2(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)
    ) {
        // Red Header Row
        Row(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp, top = 0.dp, bottom = 20.dp)
            .background(Color.Red),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Rubrik", fontSize = 40.sp)
        }

        // White section with 3 Boxes
        Column(modifier = Modifier
            .padding(top = 60.dp)
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumberBox("1")
                NumberBox("2")
                NumberBox("3")
            }
        }

        Column(modifier = Modifier.weight(1f)) {}

        // THE BUTTON - Navigation Trigger
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(modifier = Modifier
                .width(200.dp)
                .height(80.dp)
                .background(Color.Blue)
                .clickable {
                    navController.navigate("details")
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Läs Mer",
                    fontSize = 25.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DetailsScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Läs mer", fontSize = 30.sp)
    }
}

@Composable
fun NumberBox(text: String) {
    Column(modifier = Modifier
        .size(60.dp)
        .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text, fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PiaScreen2Preview() {
    PiaScreen2(rememberNavController())
}