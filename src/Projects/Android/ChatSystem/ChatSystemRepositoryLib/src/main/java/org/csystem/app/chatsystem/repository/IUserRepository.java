package org.csystem.app.chatsystem.repository;

import org.csystem.app.chatsystem.repository.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends CrudRepository<User, String> {
    boolean existsUserByNickNameAndPassword(@Param("nickName")String nickName, @Param("password")String password);

    Optional<User> findUserByNickNameAndPassword(@Param("nickName")String nickName, @Param("password")String password);
}
