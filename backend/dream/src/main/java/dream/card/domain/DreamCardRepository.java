package dream.card.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DreamCardRepository extends JpaRepository<DreamCard, Long> {

    @Query("select distinct d from DreamCard d " +
            "left join fetch d.dreamCardOwner " +
            "left join d.dreamCardAuthor " +
            "left join fetch d.cardKeyword dc " +
            "left join fetch dc.keyWordId  " +
            "where d.dreamCardId = :id")
    Optional<DreamCard> findDetailsById(@Param("id") Long id);

    @Query("select d from DreamCard d left join fetch d.dreamCardOwner " +
            "where d.dreamCardId = :id")
    Optional<DreamCard> findOwnerById(@Param("id") Long id);

    @Query("select d from DreamCard d left join fetch d.dreamCardLikes " +
            "where d.dreamCardId = :id")
    Optional<DreamCard> findLikeById(@Param("id") Long id);

    @Query("select distinct d from DreamCard d " +
            "left join fetch d.dreamCardOwner " +
            "left join fetch d.cardKeyword dc " +
            "left join fetch dc.keyWordId  " +
            "left join d.dreamCardLikes " +
            "left join d.wriggleReviews " +
            "where d.dreamCardId = :id")
    Optional<DreamCard> findDetailsLikeById(@Param("id") Long id);


    @Query("select distinct d from DreamCard d " +
            "left join fetch d.cardKeyword dc " +
            "left join fetch dc.keyWordId " +
            "where d.dreamCardId = :id")
    Optional<DreamCard> findKeywordById(@Param("id") Long id);

    @Query("select d from DreamCard d "+
            "where d.dreamCardOwner.userId=:userId")
    List<DreamCard> findByDreamCardOwnerId(@Param("userId") Long userId);

    @Query("select distinct d from DreamCard d " +
            "left join fetch d.auction " +
            "left join fetch d.dreamCardOwner " +
            "where d.dreamCardId = :id ")
    Optional<DreamCard> findAuctionById(@Param("id") Long id);

    @Query("select distinct d from DreamCard d " +
            "left join fetch d.wriggleReviews " +
            "left join fetch d.dreamCardOwner " +
            "where d.dreamCardId = :id")
    Optional<DreamCard> findReviewById(@Param("id") Long id);


    @Query("select distinct d from DreamCard d " +
            "left join fetch d.dreamCardOwner " +
            "left join fetch d.cardKeyword dc " +
            "left join fetch dc.keyWordId  " +
            "where d.dreamCardOwner.userId = :id")
    List<DreamCard> findKeywordByOwner(@Param("id") Long id);

}
