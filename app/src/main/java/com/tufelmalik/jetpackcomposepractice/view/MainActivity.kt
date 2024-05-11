package com.tufelmalik.jetpackcomposepractice.view


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tufelmalik.jetpackcomposepractice.R
import com.tufelmalik.jetpackcomposepractice.data.UsersModel
import com.tufelmalik.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposePracticeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowUserData()
                }
            }
        }
    }
}

@Composable
fun SetUserData(users: UsersModel) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            val isExpanded by remember { mutableStateOf(false) }

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
            ) {
                Text(
                    text = users.name!!,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    Text(
                        text = users.email!!,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_MASK,
    name = "Night Mode"
)
@Composable
fun ShowUserData() {
    val usersList: MutableList<UsersModel> = mutableListOf()
    val user1 = UsersModel(
        name = "Tufel Malik",
        email = "mtufel21@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user2 = UsersModel(
        name = "Uzair Lakdawala",
        email = "uzair342@gmail.com",
        password = "bfjsbdg",
        profileImage = R.drawable.ic_launcher_background
    )

    val user3 = UsersModel(
        name = "Kaif Pathan",
        email = "kaify43787@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user17 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.comgradually modifying its value from MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.primary and vice versa. To do so, you will use the animateColorAsState function. Lastly, you will use the animateContentSize modifier to animate the message container size smoothl",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user6 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user7 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user8 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.comgradually modifying its value from MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.primary and vice versa. To do so, you will use the animateColorAsState function. Lastly, you will use the animateContentSize modifier to animate the message container size smoothl",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user9 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user10 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.comgradually modifying its value from MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.primary and vice versa. To do so, you will use the animateColorAsState function. Lastly, you will use the animateContentSize modifier to animate the message container size smoothl",

        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user11 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.comgradually modifying its value from MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.primary and vice versa. To do so, you will use the animateColorAsState function. Lastly, you will use the animateContentSize modifier to animate the message container size smoothl",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user12 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user13 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user14 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.comgradually modifyingt lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow. These composables render only the elements that are visible on screen, so they are designed to be very efficient for long lists.\n" +
                "In this code snippet, you can see that LazyColumn has an items child. It takes a List as a parameter and its lambda receives a parameter we’ve named message (we could have named it whatever we want) which is an instance of Message. In short, this lambda is called for each item of the provided List. Copy the sample dataset into your project to help bootstrap the conversation quickly.\n" +
                "\n" +
                "Animate messages while expanding\n" +
                "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content  its value from MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.primary and vice versa. To do so, you will use the animateColorAsState function. Lastly, you will use the animateContentSize modifier to animate the message container size smoothl",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user15 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.comgradually modifyingt lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow. These composables render only the elements that are visible on screen, so they are designed to be very efficient for long lists.\n" +
                "In this code snippet, you can see that LazyColumn has an items child. It takes a List as a parameter and its lambda receives a parameter we’ve named message (we could have named it whatever we want) which is an instance of Message. In short, this lambda is called for each item of the provided List. Copy the sample dataset into your project to help bootstrap the conversation quickly.\n" +
                "\n" +
                "Animate messages while expanding\n" +
                "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content  its value from MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.primary and vice versa. To do so, you will use the animateColorAsState function. Lastly, you will use the animateContentSize modifier to animate the message container size smoothl",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user16 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    val user4 = UsersModel(
        name = "Samir Garasiya",
        email = "gsamir@gmail.com",
        password = "abcsefg",
        profileImage = R.drawable.ic_launcher_background
    )
    usersList.add(user1)
    usersList.add(user2)
    usersList.add(user3)
    usersList.add(user4)
    usersList.add(user6)
    usersList.add(user7)
    usersList.add(user8)
    usersList.add(user9)
    usersList.add(user10)
    usersList.add(user11)
    usersList.add(user12)
    usersList.add(user13)
    usersList.add(user14)
    usersList.add(user15)
    usersList.add(user16)
    usersList.add(user17)

    LazyColumn {
        items(usersList) { users ->
            SetUserData(users)
        }
    }

}

