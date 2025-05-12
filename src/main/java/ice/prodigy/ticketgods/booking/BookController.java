package ice.prodigy.ticketgods.booking;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ice.prodigy.ticketgods.cinema.CinemaService;
import ice.prodigy.ticketgods.concerts.ConcertService;
import ice.prodigy.ticketgods.museums.MuseumsService;
import ice.prodigy.ticketgods.sports.SportsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/bookapi")
@RequiredArgsConstructor
public class BookController{
    
    private final BookService bookService;
    private final CinemaService cinemaService;
    private final ConcertService concertService;
    private final MuseumsService museumsService;
    private final SportsService sportsService;

    //Κλήση του service getBook για να επιστραφούν όλα τα bookings
    @GetMapping("/Bookings")
    public ResponseEntity<List<Booking>> getBook() {
        return ResponseEntity.ok(bookService.getBooking());
    }

    @PostMapping("/Cancel")
    public void Cancel(@RequestBody Booking book) {
        //Ελεγχος του id ετσι ώστε να δούμε τι είδος είναι το booking (museum, sport, concert ή cinema) και να μπορέσουμε να καλέσουμε το κατάλληλο save service
        if(book.getBookId().substring(0, 2).equals("#1")){
            museumsService.saveMuseum(book);
        }
        else if(book.getBookId().substring(0, 2).equals("#2")){
            concertService.saveConcert(book);
        }
        else if(book.getBookId().substring(0, 2).equals("#3")){
            cinemaService.saveCinema(book);
        }
        else if(book.getBookId().substring(0, 2).equals("#4")){
            sportsService.saveSports(book);
        }
        bookService.Cancel(book.getBookId());
    }
    
    
}