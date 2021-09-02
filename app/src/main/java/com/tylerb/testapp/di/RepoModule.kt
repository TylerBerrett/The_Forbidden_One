package com.tylerb.testapp.di

import com.tylerb.testapp.data.dao.DefaultDao
import com.tylerb.testapp.data.network.DefaultService
import com.tylerb.testapp.repository.DefaultRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object RepoModule {

    @Provides
    @ViewModelScoped
    fun provideDefaultRepo(defaultService: DefaultService, defaultDao: DefaultDao): DefaultRepo =
        DefaultRepo(defaultService, defaultDao)

}