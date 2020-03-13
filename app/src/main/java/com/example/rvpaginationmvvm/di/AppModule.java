package com.example.rvpaginationmvvm.di;

import android.app.Application;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.rvpaginationmvvm.R;
import com.example.rvpaginationmvvm.network.PostsApi;
import com.example.rvpaginationmvvm.ui.PostRecyclerAdapter;
import com.example.rvpaginationmvvm.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions
                .placeholderOf(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions){
        return Glide
                .with(application)
                .applyDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static PostsApi providePostsApi(Retrofit retrofit){
        return retrofit.create(PostsApi.class);
    }

    @Singleton
    @Provides
    static PostRecyclerAdapter provideAdaptor(){
        return new PostRecyclerAdapter();
    }
}
