package ice.prodigy.ticketgods.concerts;

import java.util.List;
import java.util.NoSuchElementException;

import ice.prodigy.ticketgods.booking.Booking;
import ice.prodigy.ticketgods.booking.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcertService {
    
  @Autowired
  private final ConcertRepository concertRepository;
  @Autowired
  private final BookRepository bookRepository;

  //Επιστροφή ολών των concert
  public List<Concert> getConcert() {
    return concertRepository.findAll();
  }

  //Αποθηκευση του booking
  public void Book(Booking book){
    bookRepository.save(book);
  }

  //Διαγραφή του concert απο το db του
  public void Delete(String bookId){
    concertRepository.deleteById(bookId);
  }

  //Αποθήκευση του concert στο db του
  public Concert saveConcert(Booking book) {
    Concert concert = new Concert(book.getBookId(), book.getBookNames(), book.getBookTimes(), book.getBookSeats(), book.getBookPrice());
    return concertRepository.save(concert);
  }

  //Ευρεση συγκεκριμένου entity
  public Concert findConcert(String id) {
    return concertRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
  }

}
