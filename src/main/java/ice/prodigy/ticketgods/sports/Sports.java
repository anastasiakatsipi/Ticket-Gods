package ice.prodigy.ticketgods.sports;

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
@Table(name = "Sports")
public class Sports {
    @Id
    @Column(name = "gcode", length = 20)
    private String gameCode;

    @Column(name = "gnames", length = 40)
    private String gameNames;

    @Column(name = "times", length = 20)
    private String gameTimes;

    @Column(name = "seats", length = 10)
    private String gameSeats;

    @Column(name = "price")
    private float gamePrice;
}
