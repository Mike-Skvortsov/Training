package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.historyDTO.HistoryWithoutUserDTO;
import com.termpaper.TermPaper.mappers.HistoryMapper;
import com.termpaper.TermPaper.models.History;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.services.HistoryService;
import com.termpaper.TermPaper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/histories")
public class HistoryController {
    @Autowired
    private final HistoryService historyService;
    private final HistoryMapper historyMapper;
    private final UserService userService;

    public HistoryController(HistoryService historyService, HistoryMapper historyMapper, UserService userService) {
        this.historyService = historyService;
        this.historyMapper = historyMapper;
        this.userService = userService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllHistorySpecificUser(@PathVariable int userId)
    {
        User user = userService.getUser(userId)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("User with this id does not exist: " + userId));

        List<History> history = (List<History>) historyService.getAllHistoriesThisUser(userId);
        if (history.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("Histories not found");
        }
        List<HistoryWithoutUserDTO> historyWithoutUserDTOS = history.stream()
                .map(historyMapper::toHistoryWithoutUserDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(historyWithoutUserDTOS);
    }
}
