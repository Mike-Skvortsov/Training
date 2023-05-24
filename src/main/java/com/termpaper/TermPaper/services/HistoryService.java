package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.History;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void create(History model)
    {
        historyRepository.save(model);
    }
    public Iterable<History> getAllMuscleGroup()
    {
        return historyRepository.findAll();
    }
}
