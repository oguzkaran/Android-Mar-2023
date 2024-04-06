package org.csystem.app.chatsystem.repository;

import org.csystem.app.chatsystem.repository.entity.LoginInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginInfoRepository extends CrudRepository<LoginInfo, Long> {
    @Query("FROM LoginInfo li WHERE li.user.nickName = :nickName")
    Iterable<LoginInfo> findByUserNickName(@Param("nickName")String nickName);

    @Query(value = "SELECT * FROM login_info WHERE date_part('day', date_time) = :day AND date_part('month', date_time) = :month AND date_part('year', date_time) = :year", nativeQuery = true)
    Iterable<LoginInfo> findByDate(@Param("day") int day, @Param("month") int month, @Param("year") int year);
}
