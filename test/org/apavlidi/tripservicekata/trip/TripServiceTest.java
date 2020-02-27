package org.apavlidi.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import org.apavlidi.tripservicekata.exception.UserNotLoggedInException;
import org.apavlidi.tripservicekata.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TripServiceTest {

    private TripService tripService;
    private User user;
    private User loggedInUser;

    @BeforeEach
    void setUp() {
        user = new User();
        loggedInUser = new User();
    }

    @Test
    public void throw_exception_when_not_logged_in() {
        tripService = new TestableTripServiceNotLoggedIn();
        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(user));
    }

    @Test
    public void return_no_trips_if_user_is_not_a_friend_with_the_logged_in_user() {
        tripService = new TestableTripServiceLoggedIn();
        List<Trip> tripsByUser = tripService.getTripsByUser(user);
        assertEquals(0, tripsByUser.size());
    }

    @Test
    public void return_no_trips_if_user_has_friends_but_not_the_logged_in_user() {
        tripService = new TestableTripServiceLoggedIn();
        Trip trip = new Trip();
        user.addTrip(trip);
        user.addFriend(new User());
        assertEquals(0, tripService.getTripsByUser(user).size());
    }

    @Test
    public void return_trips_if_user_is_friend_with_the_logged_in_user() {
        tripService = new TestableTripServiceLoggedIn();
        Trip trip = new Trip();
        user.addTrip(trip);
        user.addFriend(loggedInUser);
        assertEquals(1, tripService.getTripsByUser(user).size());
    }

    public static class TestableTripServiceNotLoggedIn extends TripService {

        protected User getLoggedInUser() {
            return null;
        }
    }

    public class TestableTripServiceLoggedIn extends TripService {

        protected User getLoggedInUser() {
            return loggedInUser;
        }

        protected List<Trip> findTripsByUser(User user) {
            return Collections.singletonList(new Trip());
        }
    }

}
