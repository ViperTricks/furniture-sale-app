package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckOut(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.mipmap.goback_ic),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
                    .clickable { navController.popBackStack() }
            )
            Text(text = "Check out", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Shipping Address",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF909090)
            )
            Text(text = " ")
            Image(
                painter = painterResource(id = R.mipmap.edit_black_ic),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(135.dp)
                .fillMaxWidth()

                .shadow(
                    elevation = 12.dp, // Đổ bóng theo Y = 8dp
                    shape = RoundedCornerShape(12.dp), // Bo góc 8dp
                    clip = true // Bóng chỉ hiển thị trong vùng bo góc
                )
                .clip(RoundedCornerShape(12.dp)) // Bo góc 8dp
                .background(Color.White) // Màu nền của Box

        ) {
            Column {
                Text(
                    text = "Bruno Fernandes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(
                    modifier = Modifier
                        .height(4.dp)
                        .padding(start = 1.dp, end = 1.dp),
                    thickness = 4.dp,   // Độ dày của đường
                    color = Color(0xFFF0F0F0) // Màu xám
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                    text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF808080),
                )
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Payment",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF909090)
            )
            Text(text = " ")
            Image(
                painter = painterResource(id = R.mipmap.edit_gray_ic),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp, // Đổ bóng theo Y = 8dp
                    shape = RoundedCornerShape(12.dp), // Bo góc 8dp
                    clip = true // Bóng chỉ hiển thị trong vùng bo góc
                )
                .clip(RoundedCornerShape(12.dp)) // Bo góc 8dp
                .background(Color.White) // Màu nền của Box

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(64.dp) // Chiều rộng 64dp
                        .height(38.dp) // Chiều cao 38dp
                        .shadow(
                            elevation = 4.dp, // Bóng đổ
                            shape = RoundedCornerShape(12.dp), // Bo góc
                            clip = true // Không cắt phần bóng
                        )
                        .clip(RoundedCornerShape(12.dp)) // Bo tròn cạnh của Box
                        .background(Color.White) // Màu nền trắng cho Box
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.mastercard), // Logo Mastercard
                        contentDescription = null,
                        contentScale = ContentScale.Fit, // Đảm bảo hình ảnh phù hợp với kích thước Box nhưng không bị méo
                        modifier = Modifier
                            .fillMaxWidth() // Hình ảnh lấp đầy chiều rộng Box
                            .align(Alignment.Center) // Căn giữa hình ảnh trong Box
                    )
                }


                Text(
                    modifier = Modifier
                        .padding(start = 18.dp),
                    text = "**** **** **** 3947",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF242424),
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Delivery method",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF909090)
            )
            Text(text = " ")
            Image(
                painter = painterResource(id = R.mipmap.edit_gray_ic),
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp, // Độ cao để tạo bóng, tương ứng với Y
                    shape = RoundedCornerShape(12.dp), // Hình dạng bóng, có thể điều chỉnh nếu cần bo góc
                    clip = true // Không cắt phần bóng
                )
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White) // Màu nền của Box
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.dhl),
                    contentDescription = null,
                    modifier = Modifier
                        .width(90.dp)
                        .height(22.dp)
                )
                Text(
                    modifier = Modifier
                        .padding(start = 18.dp),
                    text = "Fast (2-3days)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF303030),
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp, // Độ cao để tạo bóng, tương ứng với Y
                    shape = RoundedCornerShape(12.dp), // Hình dạng bóng, có thể điều chỉnh nếu cần bo góc
                    clip = true // Không cắt phần bóng
                )
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White) // Màu nền của Box
                .padding(15.dp) // Padding bên trong Box

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp) // Khoảng cách giữa các dòng
            ) {
                // Row cho Order
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween // Căn đều hai bên
                ) {
                    Text(
                        text = "Order:",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "$ 95.00",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                // Row cho Delivery
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Delivery:",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "$ 5.00",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                // Row cho Total
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "$ 100.00",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("Notification") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
        ) {
            Text(
                text = "SUBMIT ORDER", color = Color.White, fontSize = 18.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}