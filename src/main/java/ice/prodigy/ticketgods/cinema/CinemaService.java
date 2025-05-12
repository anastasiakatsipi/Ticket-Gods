package ice.prodigy.ticketgods.cinema;

import java.util.List;
import java.util.NoSuchElementException;

import ice.prodigy.ticketgods.booking.Booking;
import ice.prodigy.ticketgods.booking.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CinemaService {
    
  @Autowired
  private final CinemaRepository cinemaRepository;
  @Autowired
  private final BookRepository bookRepository;

  //Επιστροφή ολών των cinema 
  public List<Cinema> getCinema() {
    return cinemaRepository.findAll();
  }

  //Αποθηκευση του booking
  public void Book(Booking book){
    bookRepository.save(book);
  }

  //Διαγραφή του cinema απο το db του
  public void Delete(String bookId){
    cinemaRepository.deleteById(bookId);
  }

  //Αποθήκευση του cinema στο db του
  public Cinema saveCinema(Booking book) {
    Cinema cinema = new Cinema(book.getBookId(), book.getBookNames(), book.getBookTimes(), book.getBookSeats(), book.getBookPrice());
    return cinemaRepository.save(cinema);
  }
    
  //Ευρεση συγκεκριμένου entity
  public Cinema findCinema(String id) {
    return cinemaRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
  }
}
 