package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCart(navController: NavController = rememberNavController()) {
    var promoCode by remember { mutableStateOf("") }

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
            Text(text = "My cart", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 14.dp)
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.mipmap.cart1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
//                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Minimal stand", color = Color.Gray, fontSize = 14.sp)
                        Image(
                            painter = painterResource(id = R.mipmap.delete_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                    Text(text = "$ 25.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "+", color = Color.Black)
                        }
                        Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "-", color = Color.Black)
                        }
                    }
                }
            }
        }
        // Đường kẻ ngang
        HorizontalDivider(
            thickness = 0.5.dp,   // Độ dày của đường
            color = Color.Gray // Màu xám
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 14.dp)
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.mipmap.cart2),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
//                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Coffee table", color = Color.Gray, fontSize = 14.sp)
                        Image(
                            painter = painterResource(id = R.mipmap.delete_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                    Text(text = "$ 20.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "+", color = Color.Black)
                        }
                        Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "-", color = Color.Black)
                        }
                    }
                }
            }
        }
        // Đường kẻ ngang
        HorizontalDivider(
            thickness = 0.5.dp,   // Độ dày của đường
            color = Color.Gray // Màu xám
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 14.dp)
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.mipmap.cart3),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
//                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Minimal desk", color = Color.Gray, fontSize = 14.sp)
                        Image(
                            painter = painterResource(id = R.mipmap.delete_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }
                    Text(text = "$ 50.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "+", color = Color.Black)
                        }
                        Text(text = "01", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFf3f3f3)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "-", color = Color.Black)
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = promoCode, // Sử dụng biến trạng thái
                        onValueChange = {
                            promoCode = it
                        }, // Cập nhật giá trị khi người dùng nhập liệu
                        placeholder = { Text(text = "Enter your promo code") }, // Thêm placeholder cho TextField
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(310.dp)
                            .height(60.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFe7e7e7), // Màu nền khi không được chọn
                            focusedContainerColor = Color(0xFFe7e7e7),  // Màu nền khi được chọn
                            unfocusedTextColor = Color.Gray,            // Màu chữ khi không được chọn
                            focusedTextColor = Color.Gray,              // Màu chữ khi được chọn
                            unfocusedIndicatorColor = Color.Transparent, // Ẩn viền khi không được chọn
                            focusedIndicatorColor = Color.Transparent    // Ẩn viền khi được chọn
                        )
                    )
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color(0xFF303030)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.vector),
                            contentDescription = "",
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),

                            )
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total:",
                        color = Color(0xFF808080),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600
                    )
                    Text(
                        text = "$ 95.00",
                        color = Color(0xFF303030),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { navController.navigate("CheckOut") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242424) // Đặt màu nền của nút thành màu đen
                    ),
                    shape = RoundedCornerShape(10.dp) // Bo tròn 10dp
                ) {
                    Text(text = "Check out", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}