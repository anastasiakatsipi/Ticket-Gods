package ice.prodigy.ticketgods.concerts;

import ice.prodigy.ticketgods.booking.Booking;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/conapi")
@RequiredArgsConstructor
public class ConcertController{
    
    private final ConcertService concertService;

    //Κληση του service για την ευρεση του concert
    @GetMapping("/Concert")
    public ResponseEntity<List<Concert>> getConcert() {
        return ResponseEntity.ok(concertService.getConcert());
    }

    //Κληση του service για την αφερεση του concert απο το db και τη προσθήκη του στο booking
    @PostMapping("/Book")
    public void Booking(@RequestBody Booking book) {
        concertService.Book(book);
        concertService.Delete(book.getBookId());
    }
    
    
}