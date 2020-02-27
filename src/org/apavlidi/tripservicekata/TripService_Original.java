package org.apavlidi.tripservicekata;

import java.util.ArrayList;
import java.util.List;
import org.apavlidi.tripservicekata.trip.TripDAO;
import org.apavlidi.tripservicekata.user.UserSession;
import org.apavlidi.tripservicekata.exception.UserNotLoggedInException;
import org.apavlidi.tripservicekata.trip.Trip;
import org.apavlidi.tripservicekata.user.User;

public class TripService_Original {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
