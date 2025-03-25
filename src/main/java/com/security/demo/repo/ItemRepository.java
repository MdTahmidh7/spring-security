package com.security.demo.repo;

import com.security.demo.entity.Item;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("""
            SELECT i FROM Item i
            ORDER BY i.createdDateTime DESC
            """)
    @NonNull
    Page<Item> findAll(@NonNull Pageable pageable);

}
