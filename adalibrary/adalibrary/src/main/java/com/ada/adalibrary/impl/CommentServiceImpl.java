package com.ada.adalibrary.impl;

import com.ada.adalibrary.domain.CommentEntity;
import com.ada.adalibrary.repos.CommentRepo;
import com.ada.adalibrary.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepo commentRepo;


    public CommentServiceImpl(CommentRepo commentRepo){
        this.commentRepo =commentRepo;

    }
    @Override
    public List<CommentEntity> getCommentByExtid(int id) {
        Optional<List<CommentEntity>> result = commentRepo.findAllByBookExtid(id);
        if (result.isEmpty()) return new ArrayList<>(1);

        return result.get();

    }


}
