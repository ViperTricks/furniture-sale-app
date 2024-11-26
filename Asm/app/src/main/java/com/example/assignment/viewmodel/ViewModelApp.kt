package com.example.assignment.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.model.Category
import com.example.assignment.model.LoginReq
import com.example.assignment.model.LoginRes
import com.example.assignment.model.Product
import com.example.assignment.model.RegisterReq
import com.example.assignment.model.RegisterRes
import com.example.assignment.services.RetrofitInstance
import kotlinx.coroutines.launch


class ViewModelApp : ViewModel() {
    private val _categorys = mutableStateOf<List<Category>>(emptyList())
    val categorys: State<List<Category>> = _categorys

    private val _messageRegister = mutableStateOf<RegisterRes?>(null)
    val messageRegister: State<RegisterRes?> = _messageRegister

    private val _messageLogin = mutableStateOf<LoginRes?>(null)
    val messageLogin: State<LoginRes?> = _messageLogin

    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    private val _productDetails = mutableStateOf<Product?>(null)
    val productDetails: State<Product?> = _productDetails

    public fun getCategory() {
        viewModelScope.launch {
            try {
                _categorys.value = RetrofitInstance.api.getCategory()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======", e.toString())
            }
        }
    }

    public fun register(register: RegisterReq) {
        viewModelScope.launch {
            try {
                _messageRegister.value = RetrofitInstance.api.register(register)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======", e.toString())
            }
        }
    }

    public fun login(login: LoginReq) {
        viewModelScope.launch {
            try {
                _messageLogin.value = RetrofitInstance.api.login(login)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======", e.toString())
                _messageLogin.value = LoginRes(status = false, message = "Login failed")
            }
        }
    }

    public fun getProduct(idCate: String) {
        viewModelScope.launch {
            try {
                _products.value = RetrofitInstance.api.getProduct(idCate)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======", e.toString())
            }
        }
    }

   public fun getProductDetails(idProduct: String) {
        viewModelScope.launch {
            try {
                _productDetails.value = RetrofitInstance.api.getDetailProduct(idProduct)
            } catch (e: Exception) {
                // Xử lý lỗi nếu có (có thể sử dụng LiveData để thông báo lỗi)
//                _productDetails.value = null // Hoặc một giá trị mặc định
                Log.d("=======", e.toString())
            }
        }
    }
}
