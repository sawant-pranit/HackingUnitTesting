package com.example.android.hackingunittesting.posts;

import com.example.android.hackingunittesting.data.Post;
import com.example.android.hackingunittesting.data.source.PostsRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

/**
 * Created by pranit on 1/7/17.
 */
public class PostsPresenterTest {

    private static List<Post> POSTS;

    @Mock
    private PostsContract.View mPostView;

    @Mock
    private PostsRepository mPostsRepository;

    private PostsPresenter mPostsPresenter;
    @Before
    public void setupPostsPresenter() {
        MockitoAnnotations.initMocks(this);
        mPostsPresenter = new PostsPresenter(mPostsRepository, mPostView);

        POSTS = Arrays.asList(new Post("title1", "body1"), new Post("title2", "body2")
        , new Post("title3", "body3"));
    }

    @Test
    public void createPresenter_setsPresenterToView(){
        mPostsPresenter = new PostsPresenter(mPostsRepository, mPostView);

        verify(mPostView).setPresenter(mPostsPresenter);
    }

    @Test
    public void getPostWithId_returnsPost(){

        int postId = anyInt();
        System.out.println(String.format("Post id: %d", postId));
        mPostsPresenter.getPost(postId);

        verify(mPostsRepository).getPost(postId);
    }
}