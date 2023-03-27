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

    @Mapping(target = "image", expression = "java(\"/image/\"+ads.getId())")
    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "pk", source = "id")
    AdsDto dtoToAdsDto(Ads ads);


    List<AdsDto> toDtoList(List<Ads> adsList);
}
