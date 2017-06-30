package com.example.android.hackingunittesting.posts;

import com.example.android.hackingunittesting.data.source.PostsRepository;

/**
 * Created by pranit on 1/7/17.
 */

public class PostsPresenter implements PostsContract.Presenter {

    private final PostsRepository mPostsRepository;

    private final PostsContract.View mView;

    public PostsPresenter(PostsRepository postsRepository, PostsContract.View view) {
        mPostsRepository = postsRepository;
        mView = view;
        mView.setPresenter(this);
    }


    @Override
    public void start() {

    }

    public void getPost(int i) {
        mPostsRepository.getPost(i);
    }
}
