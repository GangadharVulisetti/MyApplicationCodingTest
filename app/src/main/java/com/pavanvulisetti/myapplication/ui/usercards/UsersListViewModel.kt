package com.pavanvulisetti.myapplication.ui.usercards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.data.repository.UserCardsRepository
import com.pavanvulisetti.myapplication.ui.base.UiState
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UsersListViewModel(private val userCardRepository: UserCardsRepository) : ViewModel() {

    private val uiState = MutableLiveData<UiState<List<Result>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                coroutineScope {
                    val firstUserFromDeferred = async { userCardRepository.getUser() }

                    val secondUserFromDeferred = async { userCardRepository.getUser() }

                    val thirdUserFromDeferred = async { userCardRepository.getUser() }

                    val fourthUserFromDeferred = async { userCardRepository.getUser() }

                    val fifthUserFromDeferred = async { userCardRepository.getUser() }

                    val sixthUserFromDeferred = async { userCardRepository.getUser() }

                    val seventhUserFromDeferred = async { userCardRepository.getUser() }

                    val eightUserFromDeferred = async { userCardRepository.getUser() }

                    val ninthUserFromDeferred = async { userCardRepository.getUser() }

                    val tenthUserFromDeferred = async { userCardRepository.getUser() }

                    val eleventhUserFromDeferred = async { userCardRepository.getUser() }

                    val twelvethUserFromDeferred = async { userCardRepository.getUser() }

                    val thirteenthUserFromDeferred = async { userCardRepository.getUser() }

                    val fourteenthUserFromDeferred = async { userCardRepository.getUser() }

                    val fifteenthUserFromDeferred = async { userCardRepository.getUser() }

                    val sixteenthUserFromDeferred = async { userCardRepository.getUser() }

                    val seventeenthUserFromDeferred = async { userCardRepository.getUser() }

                    val eighteenthUserFromDeferred = async { userCardRepository.getUser() }

                    val nineteenthUserFromDeferred = async { userCardRepository.getUser() }

                    val twentiethUserFromDeferred = async { userCardRepository.getUser() }

                    val firstUser = firstUserFromDeferred.await()
                    val secondUser = secondUserFromDeferred.await()
                    val thirdUser = thirdUserFromDeferred.await()
                    val fourthUser = fourthUserFromDeferred.await()
                    val fifthUser = fifthUserFromDeferred.await()
                    val sixthUser = sixthUserFromDeferred.await()
                    val seventhUser = seventhUserFromDeferred.await()
                    val eighthUser = eightUserFromDeferred.await()
                    val ninthUser = ninthUserFromDeferred.await()
                    val tenthUser = tenthUserFromDeferred.await()
                    val eleventhUser = eleventhUserFromDeferred.await()
                    val twelvethUser = twelvethUserFromDeferred.await()
                    val thirteenthUser = thirteenthUserFromDeferred.await()
                    val fourteenthUser = fourteenthUserFromDeferred.await()
                    val fifteenthUser = fifteenthUserFromDeferred.await()
                    val sixteenthUser = sixteenthUserFromDeferred.await()
                    val seventeenthUser = seventeenthUserFromDeferred.await()
                    val eighteenthUser = eighteenthUserFromDeferred.await()
                    val nineteenthUser = nineteenthUserFromDeferred.await()
                    val twentiethUser = twentiethUserFromDeferred.await()

                    val allUsers = mutableListOf<Result>()

                    allUsers.addAll(firstUser.results)
                    allUsers.addAll(secondUser.results)
                    allUsers.addAll(thirdUser.results)
                    allUsers.addAll(fourthUser.results)
                    allUsers.addAll(fifthUser.results)
                    allUsers.addAll(sixthUser.results)
                    allUsers.addAll(seventhUser.results)
                    allUsers.addAll(eighthUser.results)
                    allUsers.addAll(ninthUser.results)
                    allUsers.addAll(tenthUser.results)
                    allUsers.addAll(eleventhUser.results)
                    allUsers.addAll(twelvethUser.results)
                    allUsers.addAll(thirteenthUser.results)
                    allUsers.addAll(fourteenthUser.results)
                    allUsers.addAll(fifteenthUser.results)
                    allUsers.addAll(sixteenthUser.results)
                    allUsers.addAll(seventeenthUser.results)
                    allUsers.addAll(eighteenthUser.results)
                    allUsers.addAll(nineteenthUser.results)
                    allUsers.addAll(twentiethUser.results)

                    uiState.postValue(UiState.Success(allUsers))
                }
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
