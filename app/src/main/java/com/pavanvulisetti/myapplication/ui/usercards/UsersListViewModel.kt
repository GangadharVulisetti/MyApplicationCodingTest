package com.pavanvulisetti.myapplication.ui.usercards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavanvulisetti.codingsessiontwo.ui.base.UiState
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.data.repository.UserCardsRepository
import kotlinx.coroutines.launch

class UsersListViewModel(private val userCardsRepository: UserCardsRepository) : ViewModel() {

    private val uiState = MutableLiveData<UiState<List<Result>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                val firstUserFromApi = userCardsRepository.getUser()
                val secondUserFromApi = userCardsRepository.getUser()
                val thirdUserFromApi = userCardsRepository.getUser()
                val fourthUserFromApi = userCardsRepository.getUser()
                val fifthUserFromApi = userCardsRepository.getUser()
                val sixthUserFromApi = userCardsRepository.getUser()
                val seventhUserFromApi = userCardsRepository.getUser()
                val eightUserFromApi = userCardsRepository.getUser()
                val ninthUserFromApi = userCardsRepository.getUser()
                val tenthUserFromApi = userCardsRepository.getUser()
                val eleventhUserFromApi = userCardsRepository.getUser()
                val twelvethUserFromApi = userCardsRepository.getUser()
                val thirteenthUserFromApi = userCardsRepository.getUser()
                val fourteenthUserFromApi = userCardsRepository.getUser()
                val fifteenthUserFromApi = userCardsRepository.getUser()
                val sixteenthUserFromApi = userCardsRepository.getUser()
                val seventeenthUserFromApi = userCardsRepository.getUser()
                val eighteenthUserFromApi = userCardsRepository.getUser()
                val nineteenthUserFromApi = userCardsRepository.getUser()
                val twentiethUserFromApi = userCardsRepository.getUser()
                val allUsersFromApi = mutableListOf<Result>()
                allUsersFromApi.addAll(firstUserFromApi.results)
                allUsersFromApi.addAll(secondUserFromApi.results)
                allUsersFromApi.addAll(thirdUserFromApi.results)
                allUsersFromApi.addAll(fourthUserFromApi.results)
                allUsersFromApi.addAll(fifthUserFromApi.results)
                allUsersFromApi.addAll(sixthUserFromApi.results)
                allUsersFromApi.addAll(seventhUserFromApi.results)
                allUsersFromApi.addAll(eightUserFromApi.results)
                allUsersFromApi.addAll(ninthUserFromApi.results)
                allUsersFromApi.addAll(tenthUserFromApi.results)
                allUsersFromApi.addAll(eleventhUserFromApi.results)
                allUsersFromApi.addAll(twelvethUserFromApi.results)
                allUsersFromApi.addAll(thirteenthUserFromApi.results)
                allUsersFromApi.addAll(fourteenthUserFromApi.results)
                allUsersFromApi.addAll(fifteenthUserFromApi.results)
                allUsersFromApi.addAll(sixteenthUserFromApi.results)
                allUsersFromApi.addAll(seventeenthUserFromApi.results)
                allUsersFromApi.addAll(eighteenthUserFromApi.results)
                allUsersFromApi.addAll(nineteenthUserFromApi.results)
                allUsersFromApi.addAll(twentiethUserFromApi.results)
                uiState.postValue(UiState.Success(allUsersFromApi))
            } catch (e: Exception) {
                print("******* $e")
                uiState.postValue(UiState.Error("Something Went Wrong"))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<Result>>> {
        return uiState
    }
}
