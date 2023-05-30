package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.historyDTO.HistoryWithoutUserDTO;
import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTOWithoutTrainingAndExercise;
import com.termpaper.TermPaper.mappers.HistoryMapper;
import com.termpaper.TermPaper.models.*;
import com.termpaper.TermPaper.services.HistoryService;
import com.termpaper.TermPaper.services.TrainingService;
import com.termpaper.TermPaper.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/histories")
public class HistoryController {
    @Autowired
    private final HistoryService historyService;
    private final HistoryMapper historyMapper;
    private final UserService userService;
    private final TrainingService trainingService;

    public HistoryController(HistoryService historyService, HistoryMapper historyMapper, UserService userService, TrainingService trainingService) {
        this.historyService = historyService;
        this.historyMapper = historyMapper;
        this.userService = userService;
        this.trainingService = trainingService;
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
    @PostMapping("/create")
    public ResponseEntity<History> createTrainingExercise(@RequestBody @Valid HistoryWithoutUserDTO model,
                                                          @RequestParam int userId,
                                                          @RequestParam int trainingId) {
        if (trainingService.getByIdTraining(trainingId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Training not found");
        }

        if (userService.getUser(userId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        User user = userService.getUser(userId).get();
        Training training = trainingService.getByIdTraining(trainingId).get();

        History history = historyMapper.toHistory(model);

        history.setUser(user);
        history.setTraining(training);

        return new ResponseEntity<>(historyService.createHistory(history), HttpStatus.CREATED);
    }
}
