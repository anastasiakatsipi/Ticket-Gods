package ice.prodigy.ticketgods.cinema;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ice.prodigy.ticketgods.booking.Booking;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/cineapi")
@RequiredArgsConstructor
public class CinemaController{
    
    private final CinemaService cinemaService;
    //Κληση του service για την ευρεση του cinema
    @GetMapping("/Cinema")
    public ResponseEntity<List<Cinema>> getCinemas() {
        return ResponseEntity.ok(cinemaService.getCinema());
    }
    //Κληση του service για την αφερεση του cinema απο το db και τη προσθήκη του στο booking
    @PostMapping("/Book")
    public void Booking(@RequestBody Booking book) {
        cinemaService.Book(book);
        cinemaService.Delete(book.getBookId());
    }
}