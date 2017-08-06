package com.example.android.hackingunittesting.dagger2;

import javax.inject.Inject;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 6/8/17
 */

public class NetworkApi {
    @Inject
    public NetworkApi(){
    }

    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
