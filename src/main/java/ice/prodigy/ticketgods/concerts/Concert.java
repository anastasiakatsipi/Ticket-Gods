package ice.prodigy.ticketgods.concerts;

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
@Table(name = "festivals")
public class Concert {
    @Id
    @Column(name = "fcode", length = 20)
    private String festivalCode;

    @Column(name = "fnames", length = 40)
    private String festivalName;

    @Column(name = "times", length = 20)
    private String festivalTimes;

    @Column(name = "seats", length = 10)
    private String festivalSeats;

    @Column(name = "price")
    private float festivalPrice;
}