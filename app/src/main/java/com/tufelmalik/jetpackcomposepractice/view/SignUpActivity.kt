package com.tufelmalik.jetpackcomposepractice.view

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tufelmalik.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme
import com.tufelmalik.jetpackcomposepractice.functions.ReusableTextFields


class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposePracticeTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpForm()
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpForm() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isUsernameError by remember { mutableStateOf(false) }
    var isEmailError by remember { mutableStateOf(false) }
    val isPasswordError by remember { mutableStateOf(false) }

    var usernameErrorMessage: String by remember { mutableStateOf("") }
    var emailErrorMessage by remember { mutableStateOf("") }
    val passwordErrorMessage by remember { mutableStateOf("") }


    Surface(
        Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onPrimary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sign Up")

            ReusableTextFields(
                value = username,
                onValueChanged = {
                    username = it
                    if (it.isEmpty()) {
                        isUsernameError = true
                        usernameErrorMessage = "Username cannot be empty"
                    } else {
                        isUsernameError = false
                    }
                },
                label = "Username",
                leadingIcon = Icons.Default.Person,
                leadingDescription = "Username",
                showError = isUsernameError,
                errorMessage = usernameErrorMessage
            )

            ReusableTextFields(
                value = email,
                onValueChanged = {
                    email = it
                    isEmailError = !Patterns.EMAIL_ADDRESS.matcher(it).matches()
                    emailErrorMessage = if (isEmailError) "Invalid email address" else ""
                },
                label = "Email",
                leadingIcon = Icons.Default.Email,
                leadingDescription = "Email",
                showError = isEmailError,
                errorMessage = emailErrorMessage
            )

            ReusableTextFields(
                value = password,
                onValueChanged = {
                    password = it
                    // Add password validation logic here
                },
                label = "Password",
                leadingIcon = Icons.Default.Lock,
                leadingDescription = "Password",
                isPasswordField = true,
                isPasswordVisible = false,
                onVisibleChange = { /* handle password visibility change if needed */ },
                showError = isPasswordError,
                errorMessage = passwordErrorMessage
            )

            SignUpButton(
                onClick = { /* Handle signup logic */ },
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}


@Composable
fun SignUpButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .width(2002.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Blue, // Set the background color to blue
            contentColor = Color.White // Set the text color to white
        )
    ) {
        Text(text = "Sign Up")
    }
}