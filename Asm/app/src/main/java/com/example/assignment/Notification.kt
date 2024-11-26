package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Notification(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center) // Aligning Column to center inside Box
                .padding(30.dp), // Adding some padding
        ) {
            Text(
                text = "SUCCESS!",
                fontSize = 36.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 30.dp)
            )

            Image(
                painter = painterResource(id = R.mipmap.noti),
                contentDescription = "",
                modifier = Modifier
                    .width(200.dp)
                    .height(182.dp)
                    .align(Alignment.CenterHorizontally)
            )
            
            Image(
                painter = painterResource(id = R.mipmap.checkmark),
                contentDescription = "",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Your order will be delivered soon.\n" +
                        "Thank you for choosing our app!",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF606060),
                lineHeight = 27.sp,
                modifier = Modifier
                    .padding(top = 25.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(315.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
            ) {
                Text(
                    text = "Track your orders",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600
                )
            }

            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(8.dp), // Rounded corners
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(315.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally)
                    .border(
                        1.dp,
                        Color(0xFF303030),
                        RoundedCornerShape(8.dp)
                    ) // Adding a border
            ) {
                Text(
                    text = "BACK TO HOME",
                    color = Color(0xFF303030),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600
                )
            }

        }
    }
}

