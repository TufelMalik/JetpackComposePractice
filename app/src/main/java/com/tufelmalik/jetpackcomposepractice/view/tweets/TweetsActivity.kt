package com.tufelmalik.jetpackcomposepractice.view.tweets

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tufelmalik.jetpackcomposepractice.api.TweetsApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TweetsActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsApi: TweetsApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            App()
        }
    }

    // Navigation Component
    @Composable
    fun App() {
        val navController = rememberNavController()

        // Setting up navigation host
        NavHost(navController = navController, startDestination = "signIn") {

            /*
                    sending to data from SignIn to Main-Screen with "email" parameter
            */
            composable(route = "signIn") {
                SignIn {
                    navController.navigate("main/$it")
                }
            }


            /*
                    Getting "email" data in Main-Screen from SignIn
             */
            composable(route = "main/{email}", arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                }
            )) {
                val email = it.arguments!!.getString("email")
                MainScreen(email!!)
            }
        }
    }

    @Composable
    fun SignIn(onClick: (email: String) -> Unit) {
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(top = 300.dp)
                .clickable {
                    onClick("mtufel21@gmail.com")
                })
    }

    @Composable
    fun MainScreen(email: String) {
        Text(
            text = "Main Screen\n$email",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(top = 300.dp)
        )
    }

    @Composable
    fun SignUp(navController: NavController) {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(top = 400.dp)
                .clickable {
                    navController.navigate("signIn")
                })
    }


    @Composable
    fun ShowCategoryList(onClick: (categoryName: String) -> Unit) {
        TextButton(
            onClick = {
                Toast.makeText(
                    this,
                    "Wait for tweets categories to load",
                    Toast.LENGTH_SHORT
                ).show()
                onClick("dotNET")
            },
            modifier = Modifier
                .padding(top = 500.dp)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .width(2002.dp),
            contentPadding = PaddingValues(all = 16.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Blue, // Set the background color to blue
                contentColor = Color.White // Set the text color to white
            )
        ) {
            Text(text = "Fetch Tweets Categories")
        }
    }


    @Composable
    fun ShowAndroidTweets(onClick: (tweetName: String) -> Unit) {
        TextButton(
            onClick = {
                Toast.makeText(this@TweetsActivity, "wait for tweets to load", Toast.LENGTH_SHORT)
                    .show()
                onClick("dotNET")
            },
            modifier = Modifier
                .padding(top = 300.dp)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .width(2002.dp),
            contentPadding = PaddingValues(16.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Blue, // Set the background color to blue
                contentColor = Color.White // Set the text color to white
            )
        ) {
            Text(text = "Fetch Android Tweets")
        }
    }


    @Composable
    @Preview
    private fun ShowPreviewFirst() {
        TweetsScreen("Android")
    }


}