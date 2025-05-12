package ice.prodigy.ticketgods.museums;

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
@Table(name = "Museums")
public class Museums {
    @Id
    @Column(name = "mcode",length = 20)
    private String museumCode;

    @Column(name = "gal_names",length = 40)
    private String galeryNames;

    @Column(name = "price")
    private float museumPrice;
}
