package hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {


    @Test
    void testHotel() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);

        when(hotelService.isRoomAvailable(anyInt())).thenReturn(true, false);

        assertTrue(bookingService.bookRoom(0));
        assertFalse(bookingService.bookRoom(0));
    }

    // Решение от преподавателя
    @Test
    void testBookingService() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(anyInt()))
                .thenAnswer(inv -> {
                    int roomNumber = inv.getArgument(0);
                    return roomNumber % 2 == 0;
                });

        assertTrue(bookingService.bookRoom(2));
        assertFalse(bookingService.bookRoom(1));
    }

}
