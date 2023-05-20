package com.termpaper.TermPaper.repositories;

import com.termpaper.TermPaper.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
