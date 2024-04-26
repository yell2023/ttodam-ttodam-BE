package com.ttodampartners.ttodamttodam.domain.request.repository;

import com.ttodampartners.ttodamttodam.domain.request.entity.RequestEntity;
import com.ttodampartners.ttodamttodam.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

    List<RequestEntity> findAllByPost_postId(Long postId);
    List<RequestEntity> findAllByRequestUser_Id(Long RequestUserId);

    @Query("SELECT DISTINCT r.requestUser FROM request r " +
            "WHERE r.post.postId = :postId AND r.requestStatus = 'ACCEPT'")
    List<UserEntity> findAcceptedRequestUsersByPostId(Long postId);
}
