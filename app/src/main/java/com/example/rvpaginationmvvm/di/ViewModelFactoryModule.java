package com.example.rvpaginationmvvm.di;

import androidx.lifecycle.ViewModelProvider;

import com.example.rvpaginationmvvm.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
