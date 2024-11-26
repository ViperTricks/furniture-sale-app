package com.example.assignment

import android.util.Log
import android.widget.Toast
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
import com.example.assignment.model.RegisterReq
import com.example.assignment.viewmodel.ViewModelApp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Register(
    navController: NavController = rememberNavController(),
    viewModel: ViewModelApp = viewModel()
) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
//    var repassword by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisibility by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }  // For error message display

    // Các biến trạng thái cho thông báo lỗi của từng trường
    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    // Directly observe the state
    val messageRegister = viewModel.messageRegister.value
    val context by remember { mutableStateOf("") }
    // Handle registration logic here after API call
    LaunchedEffect(messageRegister) {
        messageRegister?.let {
            if (it.status == true) {
                // Registration successful, navigate or show success message
                navController.navigate("Login") // For example, navigate to login
            } else {
                // Handle registration failure (show error message)
                errorMessage = it.message ?: "Registration failed"
                Log.d("RegisterError", errorMessage)
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
                    top = 50.dp, start = 15.dp, end = 15.dp
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
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.Center,  // Center all elements vertically


            ) {

                Text(
                    modifier = Modifier
                        .padding(start = 6.dp),
                    text = "WELCOME", color = Color(0xFF303030),
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(40.dp))

                // Trường Name
                Text(
                    text = "Name",
                    modifier = Modifier
                        .padding(start = 6.dp),
                    color = Color(0xFF909090)
                )
                TextField(
                    value = name, onValueChange = { name = it },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(350.dp)
                        .padding(bottom = 30.dp) // Khoảng cách dưới
                        .align(Alignment.CenterHorizontally)
                )
                if (nameError.isNotEmpty()) {
                    Text(
                        text = nameError,
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp, start = 6.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Trường Email
                Text(
                    modifier = Modifier
                        .padding(start = 6.dp),
                    text = "Email",
                    color = Color(0xFF909090)

                )
                TextField(
                    value = email, onValueChange = { email = it },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(350.dp)
                        .padding(bottom = 30.dp) // Khoảng cách dưới
                        .align(Alignment.CenterHorizontally)
                )

                if (emailError.isNotEmpty()) {
                    Text(
                        text = emailError,
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp, start = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Trường Password với chức năng ẩn/hiện mật khẩu
                Text(
                    modifier = Modifier
                        .padding(start = 6.dp),
                    color = Color(0xFF909090),
                    text = "Password"
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
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
                        .align(Alignment.CenterHorizontally)
                )

                if (passwordError.isNotEmpty()) {
                    Text(
                        text = passwordError,
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp, start = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Trường Repassword với chức năng ẩn/hiện mật khẩu

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                )
                {
                    Button(
                        onClick = {
                            // Reset lỗi trước khi kiểm tra
                            nameError = ""
                            emailError = ""
                            passwordError = ""

                            // Kiểm tra các trường không được bỏ trống
                            when {
                                name.text.isEmpty() -> nameError = "Name không được bỏ trống"
                                email.text.isEmpty() -> emailError = "Email không được bỏ trống"
                                !android.util.Patterns.EMAIL_ADDRESS.matcher(email.text)
                                    .matches() -> emailError = "Email không đúng định dạng"

                                password.text.isEmpty() -> passwordError =
                                    "Password không được bỏ trống"

                                else -> {
                                    // Gửi yêu cầu đăng ký
                                    val registerReq = RegisterReq(
                                        name = name.text,
                                        email = email.text,
                                        password = password.text
                                    )
                                    viewModel.register(registerReq)
                                }
                            }
                        },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .width(285.dp)
                            .height(50.dp)
                            .align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
                    ) {
                        Text(
                            text = "SIGN UP", color = Color.White, fontSize = 18.sp,
                            fontWeight = FontWeight.W600
                        )
                    }
                    Row(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Already have account?",
                            fontWeight = FontWeight.W700,
                            fontSize = 14.sp,
                            color = Color(0xFF909090)
                        )
                        Text(
                            modifier = Modifier.clickable { navController.navigate("Login") },
                            text = " SIGN IN",
                            fontWeight = FontWeight.W700,
                            fontSize = 14.sp,
                            color = Color(0xFF303030)
                        )
                    }

                }
            }
        }
    }
}