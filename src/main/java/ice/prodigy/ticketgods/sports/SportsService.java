package ice.prodigy.ticketgods.sports;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ice.prodigy.ticketgods.booking.BookRepository;
import ice.prodigy.ticketgods.booking.Booking;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SportsService {
    
  @Autowired
  private final SportsRepository sportRepository;
  @Autowired
  private final BookRepository bookRepository;

  //Επιστροφή ολών των sport 
  public List<Sports> getSports() {
    return sportRepository.findAll();
  }
    
  //Αποθηκευση του booking
  public void Book(Booking book){
    bookRepository.save(book);
  }

  //Διαγραφή του sport απο το db του
  public void Delete(String bookId){
    sportRepository.deleteById(bookId);
  }

  //Αποθήκευση του sport στο db του
  public Sports saveSports(Booking book) {
    Sports sports = new Sports(book.getBookId(), book.getBookNames(), book.getBookTimes(), book.getBookSeats(), book.getBookPrice());
    return sportRepository.save(sports);
  }

  //Ευρεση συγκεκριμένου entity
  public Sports findSports(String id) {
    return sportRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
  }
}
