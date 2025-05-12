package ice.prodigy.ticketgods.sports;

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
@RequestMapping("/api/spoapi")
@RequiredArgsConstructor
public class SportsController{
    
    private final SportsService sportService;

    //Κληση του service για την ευρεση του sport
    @GetMapping("/Sport")
    public ResponseEntity<List<Sports>> getSports() {
        return ResponseEntity.ok(sportService.getSports());
    }
    
    //Κληση του service για την αφερεση του sport απο το db και τη προσθήκη του στο booking
    @PostMapping("/Book")
    public void Booking(@RequestBody Booking book) {
        sportService.Book(book);
        sportService.Delete(book.getBookId());
    }
}