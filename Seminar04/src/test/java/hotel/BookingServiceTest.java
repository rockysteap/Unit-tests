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

        assertTrue(hotelService.isRoomAvailable(0));
        assertFalse(hotelService.isRoomAvailable(0));
    }

    @Test
    void test(){
        HotelService g = mock(HotelService.class);
        BookingService b = new BookingService(g);
        when(g.isRoomAvailable(anyInt()))
                .thenAnswer(inv->{
                    int roomNumber= inv.getArgument(0);
                    return roomNumber%2==0;
                });

        assertTrue(b.bookRoom(2));
        assertFalse(b.bookRoom(1));
    }

}