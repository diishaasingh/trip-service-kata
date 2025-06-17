package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TripDAOTest {

    @Test
    void shouldThrowExceptionWhenFindingTripByUser() {
        TripDAO tripDAO = new TripDAO();
        User user = new User();

        assertThrows(CollaboratorCallException.class, () -> tripDAO.findTripsByUser(user));
    }
}
