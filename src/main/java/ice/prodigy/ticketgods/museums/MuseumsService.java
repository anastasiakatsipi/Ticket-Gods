package ice.prodigy.ticketgods.museums;

import java.util.List;
import java.util.NoSuchElementException;

import ice.prodigy.ticketgods.booking.Booking;
import ice.prodigy.ticketgods.booking.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MuseumsService {
    
  @Autowired
  private final MuseumsRepository museumsRepository;
  @Autowired
  private final BookRepository bookRepository;

  //Επιστροφή ολών των museum
  public List<Museums> getMuseums() {
    return museumsRepository.findAll();
  }

  //Αποθηκευση του booking
  public void Book(Booking book){
    bookRepository.save(book);
  }
    
  //Διαγραφή του museum απο το db του
  public void Delete(String bookId){
    museumsRepository.deleteById(bookId);
  }

  //Αποθήκευση του museum στο db του
  public Museums saveMuseum(Booking book) {
    Museums concert = new Museums(book.getBookId(),book.getBookNames(),book.getBookPrice());
    return museumsRepository.save(concert);
  }

  //Ευρεση συγκεκριμένου entity
  public Museums findConcert(String id) {
    return museumsRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
  }

}
