package com.pavanvulisetti.myapplication.ui.usercards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.data.repository.UserCardsRepository
import com.pavanvulisetti.myapplication.ui.base.UiState
import com.pavanvulisetti.myapplication.utils.AppConstant.RESULTS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UsersListViewModel(private val userCardRepository: UserCardsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Result>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Result>>> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            userCardRepository.getUser(RESULTS)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }.collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}
