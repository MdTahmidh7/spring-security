package com.security.demo.repo;



import com.security.demo.entity.Member;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {


    @Query("""
            SELECT member FROM Member member
            WHERE LOWER(member.name) like LOWER(concat('%', :searchParam, '%'))
            """)
    @NonNull
    Page<Member> findBySearchParam(
            String searchParam,
            Pageable pageable
    );

}
