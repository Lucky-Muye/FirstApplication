package com.example.myapplication

import android.os.Bundle
import android.os.strictmode.IncorrectContextUseViolation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

                            Row(
                                modifier= Modifier
                                    .fillMaxSize()
                                    .padding(5.dp),
                                horizontalArrangement  =  Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Best Destination",
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "View All >",
                                    color = Color.Blue
                                )

                            }


                        }

                        item{
                            LazyRow {
                                items(destinations) { destinations ->
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
                                            Column() {
                                                Image(
                                                    painter = painterResource(id = destinations.image),
                                                    contentDescription = null
                                                )
                                                Row(
                                                ) {

                                                    Text(text = destinations.name)
                                                    Row(
                                                        modifier=Modifier.fillMaxSize(),
                                                        horizontalArrangement = Arrangement.SpaceBetween
                                                    ) {
                                                        Icon(
                                                            modifier=Modifier.size(18.dp),
                                                            tint =Color.Magenta,
                                                            imageVector = destinations.rating,
                                                            contentDescription =null,
                                                        )
                                                        Text(text = "4.9")

                                                    }



                                                }


                                                Row() {
                                                    Icon(
                                                        imageVector = destinations.locationIcon,
                                                        contentDescription =null
                                                    )
                                                    Text(
                                                        text = destinations.location
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
        }
    }


    @Composable
    fun TopAppBar() {
        TopAppBar(
            backgroundColor = Color.White,
            elevation = 0.dp,
            title = {
                Image(
                    modifier= Modifier
                        .clip(CircleShape)
                        .background(Color.Cyan),
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            actions = {
                Icon(
                    modifier= Modifier
                        .clip(CircleShape)
                        .background(Color.Cyan),
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
    val rating: ImageVector,
    val location: String,
    val locationIcon: ImageVector
)
val destinations= listOf(
    BestDestinations(
        image=R.drawable.jakata,
        name = "Jakarta",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Jakarta, Indonesia"
    ),
    BestDestinations(
        image=R.drawable.paris,
        name = "Paris",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Paris, France"
    ),
    BestDestinations(
        image=R.drawable.thailand,
        name = "Bangkok",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Bangkok, Thailand"
    ),
    BestDestinations(
        image=R.drawable.indonesia,
        name = "Indonesia",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Indonesia,Indonesia"
    ),
    BestDestinations(
        image=R.drawable.china1,
        name = "China",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "HongKong, China"
    ),
    BestDestinations(
        image=R.drawable.thailand1,
        name = "Thailand",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Thailand, Thailand"
),
    BestDestinations(
        image=R.drawable.china,
        name = "China",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Beijing, China"
    ),
    BestDestinations(
        image=R.drawable.canada,
        name = "Canada",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "Canada,Canada"
            ),
    BestDestinations(
        image=R.drawable.mai,
        name = "Chiang Mai",
        rating = Icons.Default.Star,
        locationIcon = Icons.Default.LocationOn,
        location = "ChiangMai, Thailand"
    )
)


