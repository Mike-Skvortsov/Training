package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.historyDTO.HistoryWithoutUserDTO;
import com.termpaper.TermPaper.models.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TrainingPlanMapper.class)
public interface HistoryMapper {
    @Mapping(source = "training", target = "training")
    HistoryWithoutUserDTO toHistoryWithoutUserDTO(History history);
}
