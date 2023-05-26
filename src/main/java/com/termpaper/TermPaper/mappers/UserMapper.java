package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.userDTO.UserDTOWithoutIdAndHistories;
import com.termpaper.TermPaper.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTOWithoutIdAndHistories toUserDTOWithoutIdAndHistories (User user);
}
