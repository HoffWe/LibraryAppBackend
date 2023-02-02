package libraryapp.repository;

import libraryapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {

    public List<Review> findByBook_Id(UUID uuid);

    @Query("select avg(r.rating) from Review as r where r.book.id='bookId'" )
    Double getBookRating (@Param("bookId") UUID bookId);

}
