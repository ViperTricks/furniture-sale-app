package com.example.assignment.services

import com.example.assignment.model.Category
import com.example.assignment.model.LoginReq
import com.example.assignment.model.LoginRes
import com.example.assignment.model.Product
import com.example.assignment.model.RegisterReq
import com.example.assignment.model.RegisterRes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

// Interface định nghĩa API
interface ApiService {
    @GET("list-category.php")
    suspend fun getCategory(): List<Category>

    @POST("register.php")
    suspend fun register(@Body registerReq: RegisterReq): RegisterRes

    @POST("login.php")
    suspend fun login(@Body loginReq: LoginReq): LoginRes

    @GET("list-product-by-cate.php")
    suspend fun getProduct(@Query("id") categoryID: String): List<Product>

    @GET("detail-product.php")
    suspend fun getDetailProduct(@Query("id") idProduct: String): Product

}

// Object để khởi tạo Retrofit
object RetrofitInstance {
    private const val BASE_URL = "https://vieclam.shop/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
