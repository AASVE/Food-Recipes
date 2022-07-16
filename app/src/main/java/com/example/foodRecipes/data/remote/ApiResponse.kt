package com.example.foodRecipes.data.remote

sealed class ApiResponse<out T> {

    data class Success<out T>(val data: T) : ApiResponse<T>()

    data class Failure(
        var message: String?,
        var status: Int?,
        var errorCode: String?
    ) : ApiResponse<Nothing>()
}