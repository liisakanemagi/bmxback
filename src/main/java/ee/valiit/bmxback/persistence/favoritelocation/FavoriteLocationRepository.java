package ee.valiit.bmxback.persistence.favoritelocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FavoriteLocationRepository extends JpaRepository<FavoriteLocation, Integer> {


    @Query("select (count(f) > 0) from FavoriteLocation f where f.user.id = :userId and f.location.id = :locationId")
    boolean locationIsInFavouritesBy(Integer userId, Integer locationId);

}