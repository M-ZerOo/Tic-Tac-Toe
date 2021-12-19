package com.melfouly.tictactoe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val _playerOne = MutableLiveData<String>()
    val playerOne: LiveData<String> = Transformations.map(_playerOne) { it }
    private val _playerTwo = MutableLiveData<String>()
    val playerTwo: LiveData<String> = Transformations.map(_playerTwo) { it }
    private val _playerOneScore = MutableLiveData(0)
    val playerOneScore: LiveData<String> = Transformations.map(_playerOneScore) { it.toString() }
    private val _playerTwoScore = MutableLiveData(0)
    val playerTwoScore: LiveData<Int> get() = _playerTwoScore
    private val _buttonX = MutableLiveData<String?>()
    val buttonX: LiveData<String?> = _buttonX
    val buttonText = listOf<String>("X", "O")

    init {
        resetData()
    }

    fun setPlayerOne(name: String) {
        _playerOne?.value = name
    }

    fun setPlayerTwo(name: String) {
        _playerTwo?.value = name
    }

    fun checkWhich(): String {
        if (_buttonX.value == null) {
            _buttonX.value = buttonText[0]
        } else {
            when (_buttonX.value) {
                buttonText[0] -> _buttonX.value = buttonText[1]
                buttonText[1] -> _buttonX.value = buttonText[0]
            }
        }
        return _buttonX.value!!
    }

    fun playerOneWon() {
        _playerOneScore.value = _playerOneScore.value?.plus(1)
    }

    fun playerTwoWon() {
        _playerTwoScore.value = _playerTwoScore.value?.plus(1)
    }

    fun resetRound() {
        _buttonX.value = null
    }

    fun resetData() {
        _playerOneScore.value = 0
        _playerTwoScore.value = 0
        _buttonX.value = null
    }


}