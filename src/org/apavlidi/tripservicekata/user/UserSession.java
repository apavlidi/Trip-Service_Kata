package org.apavlidi.tripservicekata.user;


import org.apavlidi.tripservicekata.UserSessionI;
import org.apavlidi.tripservicekata.exception.CollaboratorCallException;

public class UserSession implements UserSessionI {

    private static final UserSession userSession = new UserSession();

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() {
        throw new CollaboratorCallException(
            "UserSession.getLoggedUser() should not be called in an unit test");
    }

}
