package org.apavlidi.tripservicekata.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apavlidi.tripservicekata.trip.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    public void user_should_have_no_friends_by_default() {
        assertEquals(0, user.getFriends().size());
    }

    @Test
    public void user_should_have_no_trips_by_default() {
        assertEquals(0, user.getTrips().size());
    }

    @Test
    public void addFriend_should_create_a_friend_to_the_user() {
        user.addFriend(new User());
        assertEquals(1, user.getFriends().size());
    }

    @Test
    public void addTrip_should_create_a_trip_to_the_user() {
        user.addTrip(new Trip());
        assertEquals(1, user.getTrips().size());
    }

}
