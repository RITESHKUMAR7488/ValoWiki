package com.example.valowiki.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.valowiki.repositories.MyRepository
import com.example.valowiki.viewModels.MyViewModel

class MyViewModelFactory(private val myRepository: MyRepository): ViewModelProvider.Factory {
override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
return MyViewModel(myRepository) as T
}
}