package ice.prodigy.ticketgods.cinema;

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
@Table(name = "cinema")
public class Cinema {
    
    @Id
    @Column(name = "ccode",length = 20)
    private String cinemaCode;

    @Column(name = "cnames",length = 40)
    private String cinemaNames;

    @Column(name = "times",length = 20)
    private String cinemaTimes;

    @Column(name = "seats",length = 10)
    private String cinemaSeats;

    @Column(name = "price")
    private float cinemaPrice;
}








