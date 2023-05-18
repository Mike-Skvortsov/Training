package com.termpaper.TermPaper.repositories;

import com.termpaper.TermPaper.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
