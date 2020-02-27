package org.apavlidi.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import org.apavlidi.tripservicekata.exception.UserNotLoggedInException;
import org.apavlidi.tripservicekata.user.User;
import org.apavlidi.tripservicekata.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = getLoggedInUser();
        if (loggedUser != null) {
            return isFriendWithUser(user, loggedUser) ? findTripsByUser(user) : new ArrayList<>();
        }
        throw new UserNotLoggedInException();
    }

    private boolean isFriendWithUser(User user, User loggedUser) {
        return user.getFriends().contains(loggedUser);
    }

    protected List<Trip> findTripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }

    protected User getLoggedInUser() {
        return UserSession.getInstance().getLoggedUser();
    }

}
