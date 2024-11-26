package com.example.assignment.model

data class Category(val idCate: String, val nameCate: String, val image: String)

data class RegisterReq(val name: String, val email: String, val password: String)

data class RegisterRes(val status: Boolean?, val message: String?)

data class LoginReq(val email: String, val password: String)

data class LoginRes(val status: Boolean?, val message: String?)

data class Product(
    val idProduct: String,
    val nameProduct: String,
    val price: String,
    val image: String,
    val description: String,
    val idCate: String
)
