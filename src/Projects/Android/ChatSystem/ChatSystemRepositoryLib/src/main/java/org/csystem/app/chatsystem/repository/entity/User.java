package org.csystem.app.chatsystem.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.Set;

@Entity
@Table(name = "user_info")
public class User {
    @Id
    @Column(name = "nick_name")
    public String nickName;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<LoginInfo> loginInfo;

    @Override
    public int hashCode()
    {
        return nickName.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof User u && u.nickName.equals(nickName);
    }
}
