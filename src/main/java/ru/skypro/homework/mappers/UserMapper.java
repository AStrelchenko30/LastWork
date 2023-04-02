package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    
    @Mapping(target = "image", expression = "java(\"/avatar/\"+userProfile.getId())")
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "regDate", ignore = true)
    @Mapping(target = "name", ignore = true)

    UserDto dtoToUserDto(UserProfile userProfile);

}
