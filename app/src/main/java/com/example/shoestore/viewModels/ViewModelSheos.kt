package com.example.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoes

class ViewModelSheos : ViewModel() {
    private val _shoesList =   MutableLiveData<MutableList<Shoes>>()
    val shoesList:  LiveData<MutableList<Shoes>>
        get() =   _shoesList


    private val  _isListEmpty = MutableLiveData<Boolean>()
    val  isListEmpty :  LiveData<Boolean>
         get() =  _isListEmpty

    init {
         _shoesList.value  =  mutableListOf()
         _isListEmpty.value  =  true
    }

    fun  addNewshoe(shoe:  Shoes) {
        _shoesList.value?.add(shoe)
         _isListEmpty.value =  false
    }
}