package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun Splash(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.mipmap.boarding),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

        // Placing the Column in the Box, aligning it at the center
        Column(
            modifier = Modifier
                .align(Alignment.Center) // Aligning Column to center inside Box
                .padding(top = 80.dp, start = 40.dp, end = 40.dp), // Adding some padding
        ) {
            // Adding text with appropriate padding and alignment
            Text(
                text = "MAKE YOUR",
                color = Color(0xFF606060),
                fontWeight = FontWeight.W600,
                fontSize = 24.sp,
            )

            Text(
                text = "HOME BEAUTIFUL",
                color = Color(0xFF303030),
                fontWeight = FontWeight.W700,
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 8.dp) // Padding between texts
            )

            Text(
                text = "The best simple place where you discover the most wonderful furniture and make your home beautiful",
                color = Color(0xFF808080),
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                letterSpacing = 1.5.sp,
                lineHeight = 32.sp,
                modifier = Modifier.padding(top = 16.dp, start = 24.dp) // Padding above this text
            )
            Button(
                onClick = { navController.navigate("Login") },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(top = 180.dp)
                    .width(160.dp)
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
            ) {
                Text(
                    text = "Get Started", color = Color.White, fontSize = 18.sp,
                    fontWeight = FontWeight.W600
                )
            }
        }
    }
}
