package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final List<Trip> trips = new ArrayList<>();
    private final List<User> friends = new ArrayList<>();

	public boolean isFriendsWith(final User loggedUser) {
		return friends.contains(loggedUser);
	}

    //default
    List<User> getFriends() {
        return Collections.unmodifiableList(friends);
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    List<Trip> trips() {
        return Collections.unmodifiableList(trips);
    }

}
