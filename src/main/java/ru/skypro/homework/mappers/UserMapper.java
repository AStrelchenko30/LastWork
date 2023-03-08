package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userProfile.id", target = "id")
    @Mapping(source = "userProfile.email", target = "email")
    @Mapping(source = "userProfile.firstName", target = "firstName")
    @Mapping(source = "userProfile.lastName", target = "lastName")
    @Mapping(source = "userProfile.phone", target = "phone")
   // @Mapping(source = "image.id", target = "image")
    UserProfile dtoToUserDto(UserProfile userProfile);

  //  UserDto userDtoToUserProfile(UserDto userDto);
}
