package ice.prodigy.ticketgods.museums;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumsRepository extends JpaRepository<Museums, String>{
    
}