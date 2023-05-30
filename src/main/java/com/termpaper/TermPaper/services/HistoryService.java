package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.History;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.repositories.HistoryRepository;
import com.termpaper.TermPaper.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;

    public HistoryService(HistoryRepository historyRepository, UserRepository userRepository) {
        this.historyRepository = historyRepository;
        this.userRepository = userRepository;
    }

    public Iterable<History> getAllHistoriesThisUser(int userId)
    {
        User user = userRepository.findById(userId).get();
        return user.getHistories();
    }
    public History createHistory(History history)
    {
        historyRepository.save(history);
        return history;
    }
}
