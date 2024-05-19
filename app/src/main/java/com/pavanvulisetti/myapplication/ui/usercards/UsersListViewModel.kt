package com.pavanvulisetti.myapplication.ui.usercards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavanvulisetti.codingsessiontwo.ui.base.UiState
import com.pavanvulisetti.myapplication.data.repository.UserCardsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.pavanvulisetti.myapplication.data.model.Result

class UsersListViewModel(private val userCardsRepository: UserCardsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Result>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Result>>> = _uiState

    init {
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {

            //This call has to be triggered 20 times
            repeat(20){
                userCardsRepository.getUser()
                    .catch { e ->
                        _uiState.value = UiState.Error(e.toString())

                    }.collect {
                        _uiState.value = UiState.Success(it)
                    }
            }
        }
    }
}
