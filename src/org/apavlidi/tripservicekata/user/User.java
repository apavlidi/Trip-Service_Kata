package org.apavlidi.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;
import org.apavlidi.tripservicekata.trip.Trip;

public class User {

    private List<Trip> trips;
    private List<User> friends;

    public User() {
        this.trips = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Trip> getTrips() {
        return trips;
    }

}
