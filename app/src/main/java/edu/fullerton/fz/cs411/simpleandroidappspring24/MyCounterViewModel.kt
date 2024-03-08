package edu.fullerton.fz.cs411.simpleandroidappspring24

import androidx.lifecycle.ViewModel

class MyCounterViewModel: ViewModel() {
    private var counter = 0
    fun getCounter(): Int { return counter }
    fun setCounter(i: Int) { counter = i }
}