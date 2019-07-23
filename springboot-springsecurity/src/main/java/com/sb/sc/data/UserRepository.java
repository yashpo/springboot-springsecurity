package com.sb.sc.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.sc.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
