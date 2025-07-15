package org.craftedsw.tripservicekata.trip;

import java.util.Arrays;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	private final UserSession userSession;
	private final TripRepository tripRepository;

	public TripService(UserSession userSession, TripRepository tripRepository) {
		this.userSession = userSession;
		this.tripRepository = tripRepository;
	}

	//default const?

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = userSession.getLoggedUser();

		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
		return user.isFriendsWith(loggedUser) ? tripRepository.findTripsByUser(user) : Arrays.asList();
	}

}
