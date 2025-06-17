package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void shouldHaveNoFriendsWhenNew(){
        User user = new User();

        List<User> friends = user.getFriends();

        assertThat(friends, is(empty()));
    }

    @Test
    void shouldHaveFriendsWhenAdded(){
        User user = new User();
        User friend = new User();
        user.addFriend(friend);

        List<User> friends = user.getFriends();

        assertThat(friends, contains(friend));
    }

    @Test
    void shouldReturnUnmodifiableFriendsList(){
        User user = new User();
        user.addFriend(new User());

        List<User> friends = user.getFriends();

        assertThrows(UnsupportedOperationException.class, ()-> friends.add(new User()));
    }

    @Test
    void shouldHaveNoTripsWhenNew() {
        User user = new User();

        assertThat(user.trips(), is(empty()));
    }

    @Test
    void shouldHaveTripsWhenAdded() {
        User user = new User();
        Trip trip = new Trip();

        user.addTrip(trip);

        assertThat(user.trips(), contains(trip));
    }

    @Test
    void shouldReturnUnmodifiableTripsList() {
        User user = new User();
        user.addTrip(new Trip());

        List<Trip> trips = user.trips();

        assertThrows(UnsupportedOperationException.class, () -> trips.add(new Trip()));
    }
}
