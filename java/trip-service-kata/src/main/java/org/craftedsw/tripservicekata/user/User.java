package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<>();
	private List<User> friends = new ArrayList<>();
	
	public List<User> getFriends() {
		return Collections.unmodifiableList(friends);
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public List<Trip> trips() {
		return Collections.unmodifiableList(trips);
	}

}
