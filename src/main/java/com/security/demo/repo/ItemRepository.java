package com.security.demo.repo;

import com.security.demo.entity.Item;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("""
            SELECT item FROM Item item
            WHERE item.createdDateTime between :filterFromDate and :filterToDate
            and item.isDeleted is null or item.isDeleted = false
            ORDER BY item.createdDateTime DESC
            """)
    @NonNull
    Page<Item> findAll(LocalDateTime filterFromDate,
                       LocalDateTime filterToDate,
                       @NonNull Pageable pageable);

}
