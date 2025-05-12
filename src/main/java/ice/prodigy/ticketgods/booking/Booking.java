package ice.prodigy.ticketgods.booking;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    
    @Id
    @Column(name = "id",length = 8)
    private String bookId;

    @Column(name = "username",length = 8)
    private String username;

    @Column(name = "bookname",length = 40)
    private String bookNames;

    @Column(name = "booktimes",length = 20)
    private String bookTimes;

    @Column(name = "bookseats",length = 10)
    private String bookSeats;

    @Column(name = "bookprice")
    private float bookPrice;
}








