package pl.sii.linkshortener.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface LinkRepository extends CrudRepository<LinkEntity, String> {

    @Query("SELECT e FROM LinkEntity e WHERE e.expirationDate < ?1")
    List<LinkEntity> findLinksBeforeDate(LocalDate localDate);

    List<LinkEntity> findAllByVisitsGreaterThan(int minimumVisits);
}
