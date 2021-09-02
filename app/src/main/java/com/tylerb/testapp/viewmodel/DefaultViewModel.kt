package com.tylerb.testapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tylerb.testapp.repository.DefaultRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DefaultViewModel @Inject constructor(private val repo: DefaultRepo) : ViewModel() {

    fun getPokemon(name: String) = repo.makeNetworkCall(name).asLiveData(Dispatchers.IO)


}