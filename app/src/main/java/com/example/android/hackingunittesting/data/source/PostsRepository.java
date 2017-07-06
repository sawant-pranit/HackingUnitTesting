package com.example.android.hackingunittesting.data.source;

import com.example.android.hackingunittesting.data.Post;

/**
 * Created by pranit on 1/7/17.
 */

public class PostsRepository implements PostsDataSource{

    private static PostsRepository sInstance;

    private final PostsDataSource mPostsLocalDataSource;


    private PostsRepository(PostsDataSource postsLocalDataSource) {
        mPostsLocalDataSource = postsLocalDataSource;
    }

    public static PostsRepository getInstance(PostsDataSource postsLocalDataSource){
        if(sInstance == null){
            sInstance = new PostsRepository(postsLocalDataSource);
        }

        return sInstance;
    }

    public static void destroyInstance(){
        sInstance = null;
    }

    public Post getPost(int post){
        return null;
    }

}
