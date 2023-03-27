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

    @Mapping(target = "image", source = "/image/{id}")
    @Mapping(target = "author", source = "ads.author.id")
    @Mapping(target = "pk", source = "ads.id")
    @Mapping(target = "price", source = "ads.price")
    @Mapping(target = "title", ignore = true)
    AdsDto dtoToAdsDto(Ads ads);

    @Mapping(target = "authorFirstName", source = "ads.author.firstName")
    @Mapping(target = "authorLastName", source = "ads.author.lastName")
    @Mapping(target = "description", source = "ads.description")
    @Mapping(target = "email", source = "ads.author.email")
    @Mapping(target = "phone", source = "ads.author.phone")
    @Mapping(target = "pk", source = "ads.id")
    @Mapping(target = "price", source = "ads.price")
    @Mapping(target = "title", source = "ads.title")
    FullAds dtoToFullAds(Ads ads);

    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Ads dtoToCreateAds(CreateAds createAds, User author, String image);


    List<AdsDto> toDtoList(List<Ads> adsList);
}
