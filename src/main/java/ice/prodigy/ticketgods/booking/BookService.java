package ice.prodigy.ticketgods.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
  @Autowired
  private final BookRepository bookRepository;

  //Ευρεση του booking
  public List<Booking> getBooking() {
    return bookRepository.findAll();
  }

  //Ακύρωση του booking
  public void Cancel(String book){
    bookRepository.deleteById(book);
      
  }
}
