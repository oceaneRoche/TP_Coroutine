package com.example.bindingadapter.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bindingadapter.pojo.EtuItem

class EtuViewModel : ViewModel() {
    private val _data = MutableLiveData<ArrayList<EtuItem>>()
    val data : LiveData<ArrayList<EtuItem>> = _data
    fun initData(){
        val initialData = ArrayList<EtuItem>()
        _data.value = initialData
    }
    fun updateData(NewData : EtuItem){
        _data.value?.add(NewData)
    }
    fun updateData(arNewData : ArrayList<EtuItem>){
        var currentData = arNewData
        _data.value = currentData
    }
}