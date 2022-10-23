package com.moviedbcrud.repository;

import com.moviedbcrud.model.entity.AdminEntity;
import com.moviedbcrud.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
//    Boolean existByEmail(String email);
      @Query("from AdminEntity where admin_email = :admin_email")
      public AdminEntity getUserByName(String admin_email);
}
