package com.example.android.hackingunittesting.posts;

import com.example.android.hackingunittesting.data.Post;
import com.example.android.hackingunittesting.data.source.PostsRepository;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Captor
    ArgumentCaptor<List<String>> captor;

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

    @Test
    public void when_thenReturn(){
        int dummyPostId = 1;
        Post post = new Post("tit1", "body1");
        when(mPostsRepository.getPost(dummyPostId)).thenReturn(post);
        assertEquals(post,mPostsRepository.getPost(dummyPostId));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_thenThrow(){
        int dummyPostId = -1;
        Post post = new Post("tit1", "body1");
        when(mPostsRepository.getPost(dummyPostId)).thenThrow(new IllegalArgumentException());

        mPostsRepository.getPost(dummyPostId);
    }

    @Test
    public void test_withSpy(){
        List<Post> posts = new ArrayList<>();
        List<Post> spyPostsList = spy(posts);

        when(spyPostsList.size()).thenReturn(100);

        System.out.println(spyPostsList.size());

        Post post = new Post("tit1", "body1");
        when(spyPostsList.get(0)).thenReturn(post);

        assertEquals(post, spyPostsList.get(0));
    }

    @Test
    public void whenCreateSpy_thenCreate() {
        List spyList = Mockito.spy(new ArrayList());

        spyList.add("one");
        Mockito.verify(spyList).add("one");

        assertEquals(1, spyList.size());
    }

    @Test
    public void doReturnWhen_doReturnThrow(){
        Post post = new Post("title1", "body1");
        post.setId(10);

        Post spyProperties = spy(post);

        doReturn(15).when(spyProperties).getId();

        int spyId = spyProperties.getId();

        int id = post.getId();

        System.out.printf("id %d spyid %d", id, spyId);

        assertEquals(15, spyId);

    }

    @Test
    public void test_captor(){
        List<String> LIST = Arrays.asList("some1","some2","some3");
        List<String> mockedList = mock(List.class);

        mockedList.addAll(LIST);

        verify(mockedList).addAll(captor.capture());

        List<String> capturedArgu = captor.getValue();

        Assert.assertThat(capturedArgu, CoreMatchers.hasItem("some2"));
    }

    @Test
    public void answerTest(){
        doAnswer(AdditionalAnswers.returnsFirstArg()).when(POSTS).add(any(Post.class));

        when(mPostView).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return null;
            }
        });
    }
}