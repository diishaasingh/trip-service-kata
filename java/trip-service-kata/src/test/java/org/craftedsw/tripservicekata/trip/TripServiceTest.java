package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripServiceTest {

    @Test
    void shouldThrowExceptionWhenUserNotLoggedIn(){ //test name should not be technical
        UserSession userSession = mock(UserSession.class);
        TripRepository tripRepository = mock(TripRepository.class);
        TripService tripService = new TripService(userSession, tripRepository);

        when(userSession.getLoggedUser()).thenReturn(null);

        assertThrows(UserNotLoggedInException.class, ()-> tripService.getTripsByUser(new User()));
    }

    @Test
    void shouldReturnEmptyListWhenUsersAreNotFriends(){
        UserSession userSession = mock(UserSession.class);
        TripRepository tripRepository = mock(TripRepository.class);
        TripService tripService = new TripService(userSession, tripRepository);

        User loggedUser = new User();
        User anotherUser = new User();

        when(userSession.getLoggedUser()).thenReturn(loggedUser);

        List<Trip> trips = tripService.getTripsByUser(anotherUser);

        assertTrue(trips.isEmpty(), "Expected empty trip list for non-friend user");
    }

    @Test
    void shouldNotCallRepositoryWhenUsersAreNotFriends(){
        UserSession userSession = mock(UserSession.class);
        TripRepository tripRepository = mock(TripRepository.class);
        TripService tripService = new TripService(userSession, tripRepository);

        User loggedUser = new User();
        User anotherUser = new User();

        when(userSession.getLoggedUser()).thenReturn(loggedUser);
        tripService.getTripsByUser(anotherUser);

        verify(tripRepository, times(0)).findTripsByUser(anotherUser);
        //brittle
    }

    @Test
    void shouldReturnTripsWhenUsersAreFriends() {
        UserSession userSession = mock(UserSession.class);
        TripRepository tripRepository = mock(TripRepository.class);
        TripService tripService = new TripService(userSession, tripRepository);

        User loggedUser = new User();
        User user = new User();
        user.addFriend(loggedUser);

        List<Trip> expectedTrips = Arrays.asList(new Trip(), new Trip());
        when(userSession.getLoggedUser()).thenReturn(loggedUser);
        when(tripRepository.findTripsByUser(user)).thenReturn(expectedTrips);

        List<Trip> actualTrips = tripService.getTripsByUser(user);

        assertEquals(expectedTrips, actualTrips);
    }

    @Test
    void shouldCallRepositoryWhenUsersAreFriends() {
        UserSession userSession = mock(UserSession.class);
        TripRepository tripRepository = mock(TripRepository.class);
        TripService tripService = new TripService(userSession, tripRepository);

        User loggedUser = new User();
        User user = new User();
        user.addFriend(loggedUser);

        List<Trip> expectedTrips = Arrays.asList(new Trip(), new Trip());
        when(userSession.getLoggedUser()).thenReturn(loggedUser);
        when(tripRepository.findTripsByUser(user)).thenReturn(expectedTrips);

        tripService.getTripsByUser(user);

        verify(tripRepository, times(1)).findTripsByUser(user);
    }

}
