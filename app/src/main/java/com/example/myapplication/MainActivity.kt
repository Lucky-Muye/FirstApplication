package com.example.myapplication

import android.os.Bundle
import android.os.strictmode.IncorrectContextUseViolation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Scaffold(

                    topBar = {
                        TopAppBar()
                    }
                ){
                    LazyColumn {
                        item {
                            LazyRow {
                                items(mountains) { mountain ->
                                    Card(
                                        modifier = Modifier
                                            .padding(5.dp)
                                            .wrapContentSize()


                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .padding(5.dp)
                                        )
                                        {
                                            Image(
                                                painter = painterResource(id = mountain.image),
                                                contentDescription = null
                                            )
                                            Text(text = mountain.name)

                                            Icon(
                                                modifier = Modifier.align(Alignment.BottomStart),
                                                imageVector = mountain.locationIcon,
                                                contentDescription =null
                                            )
                                            Text(
                                                text = mountain.location,
                                                modifier = Modifier.align(Alignment.BottomEnd)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        

                    }

                 }

                }

            }
        }
    }


    @Composable
    fun TopAppBar() {
        TopAppBar(
            backgroundColor = Color.White,
            elevation = 0.dp,
            title = {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null
                )

            }
        )
    }


data class Mountain(
    val image: Int,
    val name: String,
    val location: String,
    val rating: Float,
    val locationIcon: ImageVector
)
val mountains= listOf(
    Mountain(
        image =R.drawable.kilimanjaro ,
        name="Mt. Kilimanjaro",
        location = "Tanzania",
        locationIcon = Icons.Default.LocationOn,
        rating = 9.67f
    ),
    Mountain(
        image =R.drawable.kenya ,
        name="Mt. Kenya",
        location = "Kenya",
        locationIcon = Icons.Default.LocationOn,
        rating = 7.67f
    ),
    Mountain(
        image =R.drawable.ruwenzori ,
        name="Ruwenzori Mountains",
        location = "Uganda",
        locationIcon = Icons.Default.LocationOn,
        rating = 5.00f
    ),
    Mountain(
        image =R.drawable.lorio ,
        name="Mt. Lorio",
        location = "Bungoma",
        locationIcon = Icons.Default.LocationOn,
        rating = 3.20f
    ),
    Mountain(
        image =R.drawable.lorio ,
        name="Mt. Lorio",
        location = "Bungoma",
        locationIcon = Icons.Default.LocationOn,
        rating = 3.20f
    )

)
data class BestDestinations(
    val image: Int,
    val name: String,
    val rating: Float,
    val location: String,
    val locationIcon: ImageVector
)
val destinations= listOf(
    BestDestinations(
        image=R.drawable.kenya,
        name = "number one",
        rating = 90.45f,
        locationIcon = Icons.Default.LocationOn,
        location = "Kibabii"
    ),
    BestDestinations(
        image=R.drawable.kenya,
        name = "number Two",
        rating = 90.45f,
        locationIcon = Icons.Default.LocationOn,
        location = "Kanduyi"
    ),
    BestDestinations(
        image=R.drawable.kenya,
        name = "number Three",
        rating = 90.45f,
        locationIcon = Icons.Default.LocationOn,
        location = "Mayanja"
    ),
    BestDestinations(
        image=R.drawable.kenya,
        name = "Number Four",
        rating = 90.45f,
        locationIcon = Icons.Default.LocationOn,
        location = "Tuuti"
    ),
    BestDestinations(
        image=R.drawable.kenya,
        name = "Number Five",
        rating = 90.45f,
        locationIcon = Icons.Default.LocationOn,
        location = "Namaloko"
    )
)



