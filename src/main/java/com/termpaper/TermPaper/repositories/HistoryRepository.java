package com.termpaper.TermPaper.repositories;

import com.termpaper.TermPaper.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}
