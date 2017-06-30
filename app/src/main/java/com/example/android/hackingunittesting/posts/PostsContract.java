package com.example.android.hackingunittesting.posts;

import com.example.android.hackingunittesting.BasePresenter;
import com.example.android.hackingunittesting.BaseView;

/**
 * Created by pranit on 1/7/17.
 */

public interface PostsContract {
    interface View extends BaseView<Presenter>{

    }

    interface Presenter extends BasePresenter{

    }
}
