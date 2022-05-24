package com.example.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.Shapes
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.LightText

@Composable
@Preview
fun HomeScreenUI() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Search for city",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
        )
        SearchBox()
        Cards()
        MoreCitiesButton()
        Databox()
    }
}

@Composable
fun Databox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        Card(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            elevation = 0.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Precipitation", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                    Text(text = "35%", fontSize = 23.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                    Text(text = "Humidity", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                    Text(text = "30%", fontSize = 23.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                }
                Spacer(modifier = Modifier.width(1.dp).height(80.dp).background(Color.Black))
                Column {
                    Text(text = "Wind", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                    Text(text = "16", fontSize = 23.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                    Text(text = "Pressure", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                    Text(text = "450hPa", fontSize = 23.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun MoreCitiesButton() {
    Button(onClick = {}) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "More Cities",
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun Cards() {
    Row(modifier = Modifier.padding(20.dp)) {
        CardUI(
            temperature = "95F",
            city = "NYC",
            weather = "rain",
            humidity = "77%",
            wind = "3 MPH"
        )
    }
}

@Composable
fun CardUI(temperature: String, city: String, weather: String, humidity: String, wind: String) {
    Card(backgroundColor = Color.White, elevation = 10.dp) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.TopEnd
        ) {

        }
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = weather, fontSize = 14.sp, color = Color.Black)
            Text(text = city, fontSize = 14.sp, color = Color.Black)
            Text(
                text = getTemperature(temperature = temperature).toAnnotatedString(),
                fontSize = 30.sp,
                color = Color.Black
            )
            Row {
                Text(
                    text = humidity,
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = wind,
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

fun getTemperature(temperature: String): AnnotatedString.Builder {
    val annotatedString = AnnotatedString.Builder(temperature)
        .apply {
            addStyle(
                SpanStyle(
                    fontSize = 18.sp,
                    baselineShift = BaselineShift.Superscript
                ), 2, 3
            )
        }
    return annotatedString
}

@Composable
fun SearchBox() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = null,
        placeholder = {Text("Search")},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.Black,
            placeholderColor = Color.Gray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp, bottom = 8.dp)
            .clip(Shapes.medium),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "search icon",
                tint = LightText,
                modifier = Modifier.size(20.dp))
        }
    )
}
