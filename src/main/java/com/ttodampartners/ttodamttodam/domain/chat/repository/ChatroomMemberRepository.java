package com.ttodampartners.ttodamttodam.domain.chat.repository;

import com.ttodampartners.ttodamttodam.domain.chat.entity.ChatroomEntity;
import com.ttodampartners.ttodamttodam.domain.chat.entity.ChatroomMemberEntity;
import com.ttodampartners.ttodamttodam.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatroomMemberRepository extends JpaRepository<ChatroomMemberEntity, Long> {
    List<ChatroomMemberEntity> findAllByUserEntity(UserEntity user);
    List<ChatroomMemberEntity> findAllByChatroomEntity(ChatroomEntity chatroom);
    Optional<ChatroomMemberEntity> findByUserEntityAndChatroomEntity(UserEntity user, ChatroomEntity chatroom);
    boolean existsByUserEntityAndChatroomEntity(UserEntity user, ChatroomEntity chatroom);
}
