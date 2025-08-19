package com.example.BE.ForgetPassWord;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatePasswordRepository extends JpaRepository<UpdatePassword, Integer>
{
  Optional<UpdatePassword> findByEmail(String email);

  
}
