package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.entity.Comment;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "pk", source = "comment.id")
    @Mapping(target = "author", source = "comment.author")
    @Mapping(target = "createdAt", source = "comment.createdAt")
    @Mapping(target = "text", source = "comment.text")
    CommentsDto dtoToCommentsDto(Comment comment);

}
