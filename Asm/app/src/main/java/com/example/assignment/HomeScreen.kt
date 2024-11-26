package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.assignment.model.Product
import com.example.assignment.viewmodel.ViewModelApp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: ViewModelApp = viewModel()
) {
    val listCate by viewModel.categorys
    val listProducts by viewModel.products

    LaunchedEffect(Unit) {
        viewModel.getCategory()
    }

    Box(modifier = Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.mipmap.search_ic),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .width(24.dp)
                    .height(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Make home",
                    color = Color(0xFF909090),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
//                    modifier = Modifier.align(Alignment.Center)
                )
                Text(
                    text = "BEAUTIFUL", fontSize = 24.sp,
                    fontWeight = FontWeight.W700
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.cart_ic),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 5.dp)
                    .width(24.dp)
                    .height(24.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { navController.navigate("MyCart") }
            )
        }


        // Horizontal list of categories
//        CategoryList()
        LazyRow(
            modifier = Modifier.padding(top = 60.dp, start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(listCate) { item ->
                Card(
                    modifier = Modifier.clickable {
                        // Khi nhấn vào danh mục, gọi hàm getProduct với id của danh mục
                        viewModel.getProduct(item.idCate)
                    }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        // Load image from URL using Coil
                        Image(
                            painter = rememberAsyncImagePainter(model = item.image),
                            contentDescription = item.nameCate,
                            modifier = Modifier
                                .width(44.dp)
                                .height(44.dp)
                                .padding(bottom = 8.dp)
                        )
                        Text(text = item.nameCate, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
//        ProductList()
        Box(modifier = Modifier.padding(top = 150.dp)) {
            // Hiển thị danh sách sản phẩm
            LazyVerticalGrid(
//                modifier = Modifier.padding(top = 200.dp),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(5.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(listProducts) { product ->
                    ProductItemView(product = product, navController)
                }
            }
        }

    }
}

@Composable
fun ProductItemView(product: Product, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(160.dp)
                .clickable {
                    // Điều hướng sang trang chi tiết sản phẩm
                    navController.navigate("detail/${product.idProduct}")
                }
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = product.image),
                contentDescription = product.nameProduct,
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.mipmap.addtocart),
                contentDescription = "Add to cart",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(75.dp)
                    .padding(bottom = 50.dp)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(4.dp)
        ) {
            Text(text = product.nameProduct, fontSize = 16.sp, fontWeight = FontWeight.W600)
            Text(
                text = "$${product.price}",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 3.dp)
            )
        }
    }
}

//@Composable
//fun CategoryList() {
//    val categories = listOf(
//        CategoryItem(R.mipmap.popular, "Popular"),
//        CategoryItem(R.mipmap.chair, "Chair"),
//        CategoryItem(R.mipmap.table, "Table"),
//        CategoryItem(R.mipmap.armchair, "Armchair"),
//        CategoryItem(R.mipmap.bed, "Bed"),
//    )
//    LazyRow(
//        modifier = Modifier.padding(top = 50.dp),
//        horizontalArrangement = Arrangement.spacedBy(18.dp)
//    ) {
//        items(categories.size) { index ->
//            CategoryItemView(category = categories[index])
//        }
//    }
//}

//@Composable
//fun CategoryItemView(category: CategoryItem) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .width(60.dp)
//                .height(60.dp)
//                .padding(8.dp)
//        ) {
//            Image(
//                painter = painterResource(id = category.iconRes),
//                contentDescription = category.title,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp)
//            )
//        }
//        Text(
//            text = category.title,
//            fontSize = 14.sp,
//            color = Color.Gray,
//            fontWeight = FontWeight.W500
//        )
//    }
//}
//
//data class CategoryItem(val iconRes: Int, val title: String)
//
//@Composable
//fun ProductList() {
//    // Mock data
//    val products = listOf(
//        ProductItem(R.mipmap.black_simple_lamp, "Black Simple Lamp", 12.00),
//        ProductItem(R.mipmap.minimal_stand, "Minimal Stand", 25.00),
//        ProductItem(R.mipmap.coffee_chair, "Coffee Chair", 20.00),
//        ProductItem(R.mipmap.simple_desk, "Simple Desk", 50.00)
//    )
//
//    LazyVerticalGrid(
//        modifier = Modifier.padding(top = 150.dp),
//        columns = GridCells.Fixed(2),
//        contentPadding = PaddingValues(5.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(products.size) { index ->
//            ProductItemView(product = products[index])
//        }
//    }
//}

//@Composable
//fun ProductItemView(product: Product) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .width(160.dp)
//                .height(234.dp)
//        ) {
//            Image(
//                painter = painterResource(id = product.imageRes),
//                contentDescription = product.name,
//                modifier = Modifier.fillMaxSize()
//            )
//            Image(
//                painter = painterResource(id = R.mipmap.addtocart),
//                contentDescription = "Add to cart",
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(bottom = 25.dp, end = 10.dp)
//                    .size(32.dp)
//            )
//        }
//        Column(
//            modifier = Modifier
//                .align(Alignment.Start)
//                .padding(start = 4.dp)
//        ) {
//            Text(
//                text = product.name,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.W600,
////            modifier = Modifier.padding(top = 2.dp)
//            )
//            Text(
//                text = "$ ${product.price}",
//                fontSize = 14.sp,
//                fontWeight = FontWeight.W500,
//                color = Color.Gray,
//                modifier = Modifier.padding(top = 3.dp)
//            )
//        }
//
//    }
//}
//
//data class ProductItem(val imageRes: Int, val name: String, val price: Double)