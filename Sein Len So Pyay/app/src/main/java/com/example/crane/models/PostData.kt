package com.example.crane.models

data class PostData(
    val postUrl: String,
    val reactCount: String
)

data class BadgeData(
    val postUrl: Int,
    val reactCount: String
)
