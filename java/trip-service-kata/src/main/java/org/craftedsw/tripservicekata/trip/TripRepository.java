package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public interface TripRepository {//better name of interface
    List<Trip> findTripsByUser(User user);
}
