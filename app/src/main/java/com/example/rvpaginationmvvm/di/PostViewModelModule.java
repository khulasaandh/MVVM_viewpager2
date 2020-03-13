package com.example.rvpaginationmvvm.di;

import androidx.lifecycle.ViewModel;

import com.example.rvpaginationmvvm.ui.PostViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PostViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindPostViewModel(PostViewModel viewModel);
}
