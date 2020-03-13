package com.example.rvpaginationmvvm.ui;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.rvpaginationmvvm.BaseActivity;
import com.example.rvpaginationmvvm.R;
import com.example.rvpaginationmvvm.model.Post;
import com.example.rvpaginationmvvm.network.PostsApi;
import com.example.rvpaginationmvvm.utils.Resource;
import com.example.rvpaginationmvvm.utils.VerticalSpaceItemDecoration;
import com.example.rvpaginationmvvm.viewmodel.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

public class PostsActivity extends BaseActivity {
    private static final String TAG = "PostsActivity";
    private PostViewModel viewModel;
    //private RecyclerView recyclerView;
    private ViewPager2 viewPager2;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    PostRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Log.d(TAG, "onCreate: PostsActivity created..");

        viewPager2 = findViewById(R.id.viewpager2);
        viewModel = new ViewModelProvider(this, providerFactory).get(PostViewModel.class);

        initViewPager();
        subscribeObserver();
    }

    private void subscribeObserver() {
        viewModel.observePosts().observe(this, new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if (listResource != null)
                    switch (listResource.status) {
                        case LOADING: {
                            Log.d(TAG, "onChanged: PostsFragment: LOADING...");
                            break;
                        }
                        case SUCCESS: {
                            Log.d(TAG, "onChanged: PostsFragment: got posts...");
                            adapter.setPosts(listResource.data);
                            break;
                        }
                        case ERROR: {
                            Log.d(TAG, "onChanged: PostsFragment: ERROR... " + listResource.message);
                            break;
                        }
                    }
            }
        });
    }

    private void initViewPager(){
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(adapter);
    }
}
