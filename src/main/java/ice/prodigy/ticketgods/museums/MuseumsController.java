package ice.prodigy.ticketgods.museums;

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
@RequestMapping("/api/musapi")
@RequiredArgsConstructor
public class MuseumsController{
    
    private final MuseumsService museumService;

    //Κληση του service για την ευρεση του museum
    @GetMapping("/Museum")
    public ResponseEntity<List<Museums>> getMuseums() {
        return ResponseEntity.ok(museumService.getMuseums());
    }
    
    //Κληση του service για την αφερεση του museum απο το db και τη προσθήκη του στο booking
    @PostMapping("/Book")
    public void Booking(@RequestBody Booking book) {
        museumService.Book(book);
        museumService.Delete(book.getBookId());
    }
}