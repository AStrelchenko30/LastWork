package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.entity.Comment;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "adsId", target = "pk")
    CommentsDto commentToCommentDto(Comment comment);

    @Mapping(source = "pk", target = "adsId")
    Comment commentsDtoToComment(CommentsDto comment);
}
