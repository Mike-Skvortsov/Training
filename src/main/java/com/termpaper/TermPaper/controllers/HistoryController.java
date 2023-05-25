package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.historyDTO.HistoryWithoutUserDTO;
import com.termpaper.TermPaper.mappers.HistoryMapper;
import com.termpaper.TermPaper.models.History;
import com.termpaper.TermPaper.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/histories")
public class HistoryController {
    @Autowired
    private final HistoryService historyService;
    private final HistoryMapper historyMapper;

    public HistoryController(HistoryService historyService, HistoryMapper historyMapper) {
        this.historyService = historyService;
        this.historyMapper = historyMapper;
    }
    @GetMapping("/{userId}")
    public List<HistoryWithoutUserDTO> getAllHistorySpecificUser(@PathVariable int userId)
    {
        Iterable<History> history = historyService.getAllHistoriesThisUser(userId);
        List<HistoryWithoutUserDTO> historyWithoutUserDTOS = StreamSupport.stream(history.spliterator(), false)
            .map(historyMapper::toHistoryWithoutUserDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(historyWithoutUserDTOS).getBody();
    }
}
