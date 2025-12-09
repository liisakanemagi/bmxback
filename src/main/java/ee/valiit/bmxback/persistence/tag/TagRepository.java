package ee.valiit.bmxback.persistence.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Integer> {


    @Query("select t from Tag t where t.status = :status order by t.name")
    List<Tag> findTagsBy(String status);

}
