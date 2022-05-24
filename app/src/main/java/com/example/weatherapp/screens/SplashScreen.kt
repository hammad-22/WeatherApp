package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.ui.theme.LightText
import com.example.weatherapp.R
import com.example.weatherapp.Screen
import com.example.weatherapp.ui.theme.Shapes


@Composable
@Preview
fun SplashScreenUI(navController: NavController) {

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .clip(shape = Shapes.medium)
                .fillMaxWidth()
                .height(350.dp),
            elevation = 10.dp
        ) {
            Image(painter = painterResource(id = R.drawable.cloudy), contentDescription = "Weather logo" )
        }

    }

    Box(contentAlignment = Alignment.BottomCenter) {
      Card(
          modifier = Modifier
              .clip(shape = Shapes.medium)
              .fillMaxWidth()
              .height(436.dp),
          elevation = 10.dp
      ) {
          Column(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = 40.dp)
                  .padding(horizontal = 20.dp),
              horizontalAlignment = Alignment.CenterHorizontally

          ) {
              Text(
                  text = "Find Your Weather",
                  fontSize = 28.sp,
                  textAlign = TextAlign.Center,
                  fontWeight = FontWeight.SemiBold
              )
              Text(
                  text = "Easy steps to predict the weather",
                  fontSize = 18.sp,
                  textAlign = TextAlign.Center,
                  color = LightText
              )
              Spacer(modifier = Modifier.height(16.dp))
              Button(
                  onClick = { navController.navigate(Screen.HomeScreen.route) },
                  contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp),
                  modifier = Modifier.clip(shape = Shapes.medium)
              ) {
                  Text(text = "Get started", fontSize = 18.sp)
              }
          }
      }
    }
}