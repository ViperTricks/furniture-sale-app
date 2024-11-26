@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.assignment.viewmodel.ViewModelApp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailProduct(
    navController: NavController = rememberNavController(),
    viewModel: ViewModelApp = viewModel(),
    idProduct: String?
) {
    var quantity by remember { mutableIntStateOf(1) }

    // Get the product details from the ViewModel
    val productDetails by viewModel.productDetails

    //Call API to fetch product details
    LaunchedEffect(Unit) {
        viewModel.getProductDetails(idProduct.toString())
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Background
            Box(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = productDetails?.image,
                    contentDescription = "detailBackground",
                    modifier = Modifier
                        .width(330.dp)
                        .align(Alignment.TopEnd)
                        .height(455.dp)
                        .clip(RoundedCornerShape(bottomStart = 50.dp)),
                    contentScale = ContentScale.Crop,
                )
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .absoluteOffset(x = 40.dp, y = 40.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.goback_ic),
                        contentDescription = null,
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
            } // End background

            Spacer(modifier = Modifier.padding(15.dp))

            // Nội dung
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp)
            ) {

                productDetails?.let {
                    Text(
                        text = it.nameProduct,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500)
                    )
                }


                Spacer(modifier = Modifier.padding(5.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    productDetails?.let {
                        Text(
                            text = it.price,
                            fontSize = 30.sp,
                            fontWeight = FontWeight(700)
                        )
                    }


                    Row(
                        modifier = Modifier.width(150.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Button cộng
                        Button(
                            onClick = { quantity++ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF5F5F5),
                                contentColor = Color.Black,
                            ),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                        ) {
                            Text("+", fontSize = 25.sp, textAlign = TextAlign.Center)
                        }

                        // Số lượng
                        Text(
                            text = quantity.toString().padStart(2, '0'),
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600)
                        )

                        // Button trừ
                        Button(
                            onClick = {
                                if (quantity > 1)
                                    quantity--
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF5F5F5),
                                contentColor = Color.Black,
                            ),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                        ) {
                            Text("-", fontSize = 25.sp, textAlign = TextAlign.Center)
                        }
                    }
                } // End button

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.star),
                        contentDescription = "start",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                    Text(
                        text = "4.5", fontWeight = FontWeight(700), fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        text = "(50 reviews)", fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        color = Color(0xFF808080)
                    )
                }


                productDetails?.let {
                    Text(
                        text = it.description,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(300)
                    )
                }


                Spacer(modifier = Modifier.padding(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .background(Color(0xFFF0F0F0)),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.bookmark_ic),
                            contentDescription = "Save",
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )
                    }

                    Button(
                        onClick = { navController.navigate("MyCart") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White,
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .width(250.dp)
                            .height(60.dp)
                            .shadow(10.dp, shape = RoundedCornerShape(10.dp))
                    ) {
                        Text("Add to cart", fontWeight = FontWeight(600), fontSize = 20.sp)
                    }
                }
            }
        }
    }
}






