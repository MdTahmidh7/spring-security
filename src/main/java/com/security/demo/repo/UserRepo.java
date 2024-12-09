package com.security.demo.repo;

import com.security.demo.dto.CustomUserDto;
import com.security.demo.dto.UserDTO;
import com.security.demo.entity.Users;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.QueryHint;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    Optional<Users> findByUsername(String username);

   /* Optional<Users> findByUsernameAndEmail(String username, String email);*/

    @Query(value =
            "SELECT u.username, u.email FROM users u" +
                    " WHERE username = :username " +
                    "AND email = :email", nativeQuery = true)
    List<Object[]> findByUsernameAndEmail(@Param("username") String username,
                                          @Param("email") String email);




}
