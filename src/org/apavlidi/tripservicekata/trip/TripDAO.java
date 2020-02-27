package org.apavlidi.tripservicekata.trip;

import java.util.List;
import org.apavlidi.tripservicekata.exception.CollaboratorCallException;
import org.apavlidi.tripservicekata.user.User;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO should not be invoked on an unit test.");
	}
	
}