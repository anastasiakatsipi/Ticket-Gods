package ice.prodigy.ticketgods;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ice.prodigy.ticketgods.booking.BookController;
import ice.prodigy.ticketgods.booking.BookService;
import ice.prodigy.ticketgods.booking.Booking;
import ice.prodigy.ticketgods.cinema.CinemaService;
import ice.prodigy.ticketgods.concerts.Concert;
import ice.prodigy.ticketgods.concerts.ConcertService;
import ice.prodigy.ticketgods.concerts.ConcertRepository;
import ice.prodigy.ticketgods.museums.MuseumsService;
import ice.prodigy.ticketgods.sports.SportsService;

class TicketGodsTest {

    private BookService bookService;
    private CinemaService cinemaService;
    private ConcertService concertService;
    private MuseumsService museumsService;
    private SportsService sportsService;
    private BookController bookController;
    private ConcertRepository concertRepository;

    @BeforeEach
    void setUp() {
        bookService = mock(BookService.class);
        cinemaService = mock(CinemaService.class);
        concertService = mock(ConcertService.class);
        museumsService = mock(MuseumsService.class);
        sportsService = mock(SportsService.class);
        concertRepository = mock(ConcertRepository.class);
        bookController = new BookController(bookService, cinemaService, concertService, museumsService, sportsService);
    }

    @Test
    void testGetBook() {
        //Mock data
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("123", "Sample name", "Sample booking", "Sample time", "Sample seat", 2.3f));

        //Mock behavior
        when(bookService.getBooking()).thenReturn(bookings);

        //Test
        ResponseEntity<List<Booking>> response = bookController.getBook();

        //Επιβεβαίωση αποτελέσματος
        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP status should be OK");
        assertEquals(bookings, response.getBody(), "Response body should match expected bookings");
    }

    @Test
    void testCancel() {
        //Mock data
        Booking booking = new Booking("123", "Sample name", "Sample booking", "Sample time", "Sample seat", 2.3f);

        //Test
        bookController.Cancel(booking);
        cinemaService.saveCinema(booking);

        //Επαλήθευση
        verify(bookService).Cancel("123");
        verify(cinemaService).saveCinema(booking);
    }

    @Test
    void findConcert_ValidId() {
        //Mock data
        Concert concert = new Concert("123", "Concert Name", "Concert Time", "Concert Seats", 10.0f);
        String festivalCode = "123";
        Concert expectedConcert = new Concert(festivalCode, "Concert Name", "Concert Time", "Concert Seats", 10.0f);
        
        when(concertRepository.findById(festivalCode)).thenReturn(Optional.of(expectedConcert));

        //Ελεγχος
        assertNotNull(concert);
        assertEquals(expectedConcert, concert,"Response body should match the concert");
    }

    @Test
    void findConcert_InvalidIId() {
        //Mock data
        Concert concert = new Concert("123", "Concert Name", "Concert Time", "Concert Seats", 10.0f);
        String festivalCode = "125";
        Concert expectedConcert = new Concert(festivalCode, "Concert Name", "Concert Time", "Concert Seats", 10.0f);
        
        when(concertRepository.findById(festivalCode)).thenReturn(Optional.of(expectedConcert));

        //Ελεγχος
        assertNotNull(concert);
        assertNotEquals(expectedConcert, concert,"Response body should not match the concert");
    }
}
