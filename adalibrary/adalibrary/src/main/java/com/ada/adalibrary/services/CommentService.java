package com.ada.adalibrary.services;

import com.ada.adalibrary.domain.CommentEntity;

import java.util.List;

public interface CommentService {


List<CommentEntity> getCommentByExtid(int id);

}
