package com.tylerb.testapp.repository

import com.tylerb.testapp.data.dao.DefaultDao
import com.tylerb.testapp.data.model.Pokemon
import com.tylerb.testapp.data.network.DefaultService
import com.tylerb.testapp.util.networkRunCatching
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultRepo @Inject constructor(
    private val defaultService: DefaultService,
    private val defaultDao: DefaultDao
) {

    fun makeNetworkCall(name: String) = flow {
        emit(networkRunCatching {
            val pokemon = defaultService.fetch(name)
            savePokemon(pokemon)

            pokemon
        })
    }

    private suspend fun savePokemon(pokemon: Pokemon) {
        defaultDao.insertAll(pokemon)
    }

}