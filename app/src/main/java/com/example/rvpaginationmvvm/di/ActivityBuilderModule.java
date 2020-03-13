package com.example.rvpaginationmvvm.di;

import com.example.rvpaginationmvvm.ui.PostsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {
            PostViewModelModule.class
    })
    abstract PostsActivity contributeMainActivity();
}
