package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "email", source = "userProfile.email")
    @Mapping(target = "firstName", source = "userProfile.firstName")
    @Mapping(target = "lastName", source = "userProfile.lastName")
    @Mapping(target = "phone", source = "userProfile.phone")
    @Mapping(target = "avatar", source = "userProfile.avatar.id")
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "regDate", ignore = true)
    @Mapping(target = "name", ignore = true)
    UserDto dtoToUserDto(UserProfile userProfile);

}
