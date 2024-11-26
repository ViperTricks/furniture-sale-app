package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.assignment.model.LoginReq
import com.example.assignment.viewmodel.ViewModelApp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login(
    navController: NavController = rememberNavController(),
    viewModel: ViewModelApp = viewModel()
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisibility by remember { mutableStateOf(false) }

    var errorMessage by remember { mutableStateOf("") } // For error message display

    // Biến lưu trạng thái lỗi cho email và password
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    // Observe the login response
    val messageLogin = viewModel.messageLogin.value

    // Handle login logic after API call
    LaunchedEffect(messageLogin) {
        messageLogin?.let {
            if (it.status == true) {
                // Login successful, navigate to home screen
                navController.navigate("HomeScreen") // Replace with your destination screen
            } else {
                // Đăng nhập thất bại, hiển thị thông báo lỗi
                errorMessage = it.message ?: "Sai email hoặc mật khẩu"
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.padding(
                    top = 50.dp, start = 10.dp, end = 10.dp
                ),  // Optional padding for spacing
                horizontalArrangement = Arrangement.Center,  // Center the items in the Row
                verticalAlignment = Alignment.CenterVertically  // Align items vertically centered
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.line),
                    contentDescription = "",
                    modifier = Modifier
                        .width(130.dp)
                        .height(1.dp)
                        .padding(end = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.mipmap.login),
                    contentDescription = "",
                    modifier = Modifier
                        .width(74.dp)
                        .height(74.dp)
                        .padding(end = 10.dp)

                )
                Image(
                    painter = painterResource(id = R.mipmap.line),
                    contentDescription = "",
                    modifier = Modifier
                        .width(130.dp)
                        .height(1.dp)
                )

            }
            Column(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.Center,  // Center all elements vertically


            ) {
                Text(
                    text = "Hello !",
                    color = Color(0xFF909090),
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = "WELCOME BACK", color = Color(0xFF303030),
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Trường Email
                Text(text = "Email")
                TextField(
                    value = email, onValueChange = { email = it },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(350.dp)
                        .padding(bottom = 30.dp) // Khoảng cách dưới
                )
                if (emailError.isNotEmpty()) {
                    Text(
                        text = emailError,
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                // Trường Password với chức năng ẩn/hiện mật khẩu
                Text(text = "Password")
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = "" // Xóa lỗi khi người dùng thay đổi giá trị
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = painterResource(id = if (passwordVisibility) R.drawable.visibility_ic else R.drawable.visibility_off_ic),
                                contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(350.dp)
                        .padding(bottom = 30.dp)
                )
                if (passwordError.isNotEmpty()) {
                    Text(
                        text = passwordError,
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            )
            {
                Spacer(modifier = Modifier.padding(top = 30.dp))
                Text(
                    text = "Forgot Password",
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    color = Color(0xFF303030),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Button(
                    onClick = {
                        // Kiểm tra các trường trước khi gọi API
                        var valid = true
                        if (email.text.isEmpty()) {
                            emailError = "Email không được để trống"
                            valid = false
                        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text)
                                .matches()
                        ) {
                            emailError = "Email không hợp lệ"
                            valid = false
                        }
                        if (password.text.isEmpty()) {
                            passwordError = "Password không được để trống"
                            valid = false
                        }

                        if (valid) {
                            // Tạo đối tượng LoginReq và gọi ViewModel để thực hiện đăng nhập
                            val loginRequest =
                                LoginReq(email = email.text, password = password.text)
                            viewModel.login(loginRequest)
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(top = 50.dp, bottom = 30.dp)
                        .width(285.dp)
                        .height(50.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
                ) {
                    Text(
                        text = "Log in", color = Color.White, fontSize = 18.sp,
                        fontWeight = FontWeight.W600
                    )
                }
                Text(
                    text = "SIGN UP",
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    color = Color((0xFF303030)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable { navController.navigate("Register") }
                )
            }
        }
    }
}
