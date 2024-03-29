package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "text", source = "text")
    CommentsDto dtoToCommentsDto(Comment comment);

  @Mapping(target = "id", source = "pk")
    Comment dtoToComments(CommentsDto commentDto);


}
