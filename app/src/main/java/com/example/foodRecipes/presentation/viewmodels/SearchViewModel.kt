package com.example.foodRecipes.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodRecipes.data.remote.ApiResponse
import com.example.foodRecipes.domain.model.MealModel
import com.example.foodRecipes.domain.repositories.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository = SearchRepository()
) : ViewModel() {

    val mealsLiveData = MutableLiveData<List<MealModel>>()

    fun onInputTextChanged(text: CharSequence?) {
        if (text.isNullOrBlank()) return

        searchForMeals(text.trim().toString())
    }

    private fun searchForMeals(text: String) {
        viewModelScope.launch {
            val response = repository.searchMeals(text)

            if (response is ApiResponse.Success) {
                mealsLiveData.value = response.data
            }
        }
    }
}