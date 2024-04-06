package org.csystem.app.chatsystem.repository.dal;

import com.karandev.util.data.repository.exception.RepositoryException;
import org.csystem.app.chatsystem.repository.ILoginInfoRepository;
import org.csystem.app.chatsystem.repository.IUserRepository;
import org.csystem.app.chatsystem.repository.entity.LoginInfo;
import org.csystem.app.chatsystem.repository.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
@Component
public class ChatSystemAppDataHelper {
    private final IUserRepository m_userRepository;
    private final ILoginInfoRepository m_loginInfoRepository;

    public ChatSystemAppDataHelper(IUserRepository userRepository, ILoginInfoRepository loginInfoRepository)
    {
        m_userRepository = userRepository;
        m_loginInfoRepository = loginInfoRepository;
    }

    public User saveUser(User user)
    {
        try {
            return m_userRepository.save(user);
        }
        catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.saveUser", ex);
        }
    }
    public LoginInfo saveLoginInfo(LoginInfo loginInfo)
    {
        try {
            return m_loginInfoRepository.save(loginInfo);
        }
        catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.saveLoginInfo", ex);
        }
    }
    public boolean existsUserByNickname(String username)
    {
        try {
            return m_userRepository.existsById(username);
        }
        catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.existsUserByNickName", ex);
        }
    }

    public boolean existsUserByNickNameAndPassword(String nickName, String password)
    {
        try {
            return m_userRepository.existsUserByNickNameAndPassword(nickName, password);
        }
        catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.existsUserByNickNameAndPassword", ex);
        }
    }

    public Optional<User> findUserByNickName(String nickName)
    {
        try {
            return m_userRepository.findById(nickName);
        }
        catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.findUserByNickName", ex);
        }
    }

    public Optional<User> findUserByNickNameAndPassword(String nickName, String password)
    {
        try {
            return m_userRepository.findUserByNickNameAndPassword(nickName, password);
        }
        catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.findUserByNickNameAndPassword", ex);
        }
    }
    public Iterable<LoginInfo> findLoginInfoByUserNickName(String nickName)
    {
        try {
            return m_loginInfoRepository.findByUserNickName(nickName);
        } catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.findLoginInfoByUserNickName", ex);
        }
    }
    public Iterable<LoginInfo> findLoginInfoByDateTime(LocalDate localDate)
    {
        try {
            return m_loginInfoRepository.findByDate(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
        } catch (Throwable ex) {
            throw new RepositoryException("ChatSystemAppDataHelper.findLoginInfoByDateTime", ex);
        }
    }

}
