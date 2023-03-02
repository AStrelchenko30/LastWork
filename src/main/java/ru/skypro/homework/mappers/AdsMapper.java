package ru.skypro.homework.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.entity.Ads;

@Mapper
public interface AdsMapper {

    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "image.id", target = "image")
    @Mapping(source = "author.id", target = "author")
    AdsDto adsToAdsDto(Ads ads);

    @Mapping(source = "pk", target = "id")
    @Mapping(source = "image", target = "image.id")
    @Mapping(source = "author", target = "author.id")
    Ads adsDtoToAds(AdsDto ads);

}
