package ru.skypro.homework.mappers;


import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.entity.Ads;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdsMapper {

    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(target = "image", source = "image.id")
    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "title", source = "description")
    AdsDto dtoToAdsDto(Ads ads);

    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "email", source = "author.email")
    @Mapping(target = "phone", source = "author.phone")
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "title", source = "title")
    FullAds dtoToFullAds(Ads ads);

    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Ads dtoToCreateAds(CreateAds createAds, User author, String image);

    List<AdsDto> toDtoList(List<Ads> adsList);

}
