package com.example.quotesapp.model

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val category: String,
    var isSaved: Boolean = false
)