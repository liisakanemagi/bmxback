package ee.valiit.bmxback.persistence.favoritelocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FavoriteLocationRepository extends JpaRepository<FavoriteLocation, Integer> {


    @Query("select (count(f) > 0) from FavoriteLocation f where f.user.id = :userId and f.location.id = :locationId")
    boolean locationIsInFavourites(Integer userId, Integer locationId);

    Optional <FavoriteLocation> findByUserIdAndLocationId ( Integer userId, Integer locationId);
    List<FavoriteLocation> findFavoriteLocationsBy (Integer userId);
}