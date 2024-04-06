package org.csystem.app.chatsystem.service;

import org.csystem.app.chatsystem.repository.dal.ChatSystemAppDataHelper;
import org.csystem.app.chatsystem.repository.entity.LoginInfo;
import org.csystem.app.chatsystem.repository.entity.User;
import org.csystem.app.chatsystem.service.dto.LoginInfoDTO;
import org.csystem.app.chatsystem.service.dto.LoginInfosDTO;
import org.csystem.app.chatsystem.service.dto.UserDTO;
import org.csystem.app.chatsystem.service.dto.UserSaveDTO;
import org.csystem.app.chatsystem.service.mapper.ILoginInfoMapper;
import org.csystem.app.chatsystem.service.mapper.IUserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.karandev.util.data.error.DataUtil.doForDataService;
import static java.util.stream.StreamSupport.stream;

@Service
public class ChatSystemService
{
    private final ChatSystemAppDataHelper m_chatSystemAppDataHelper;
    private final ILoginInfoMapper m_loginInfoMapper;
    private final IUserMapper m_userMapper;

    private void saveLoginInfoByUser(User user)
    {
        var loginInfo = new LoginInfo();
        loginInfo.user = user;
        loginInfo.localDateTime = LocalDateTime.now();

        doForDataService(() -> m_chatSystemAppDataHelper.saveLoginInfo(loginInfo), "ChatSystemService::saveLoginInfo");
    }

    public ChatSystemService(ChatSystemAppDataHelper chatSystemAppDataHelper, IUserMapper userMapper, ILoginInfoMapper loginInfoMapper)
    {
        m_chatSystemAppDataHelper = chatSystemAppDataHelper;
        m_userMapper = userMapper;
        m_loginInfoMapper = loginInfoMapper;
    }

    public UserDTO saveUser(UserSaveDTO userSaveDTO)
    {
        var user = doForDataService(() -> m_chatSystemAppDataHelper.saveUser(m_userMapper.toUser(userSaveDTO)),
                "ChatSystemService::saveUser");

        return m_userMapper.toUserDTO(user, new LoginInfosDTO(List.of()));
    }

    public boolean saveLoginInfoByNickNameAndPassword(String nickname, String password)
    {
        var userOpt = doForDataService(() -> m_chatSystemAppDataHelper.findUserByNickNameAndPassword(nickname, password),
                "ChatSystemService::saveLoginInfoByNickName");

        if (userOpt.isPresent()) {
            saveLoginInfoByUser(userOpt.get());
            return true;
        }

        return false;
    }


    public Optional<UserDTO> findUserByNickName(String nickName)
    {
        var userOpt = doForDataService(() -> m_chatSystemAppDataHelper.findUserByNickName(nickName),
                "ChatSystemService::findUserByNickName");

        return userOpt.map(user -> m_userMapper.toUserDTO(user, new LoginInfosDTO(List.of())));
    }

    public Optional<UserDTO> findUserByNickNameAndPassword(String nickName, String password)
    {
        var userOpt = doForDataService(() -> m_chatSystemAppDataHelper.findUserByNickNameAndPassword(nickName, password),
                "ChatSystemService::findUserByNickNameAndPassword");

        return userOpt.map(user -> m_userMapper.toUserDTO(user, new LoginInfosDTO(List.of())));
    }

    public Optional<LoginInfosDTO> findLoginInfoByUserNickName(String nickName)
    {
        var loginInfos = doForDataService(() -> m_chatSystemAppDataHelper.findLoginInfoByUserNickName(nickName),
                "ChatSystemService::findLoginInfoByUserNickName");

        var loginInfosDTO = m_loginInfoMapper.toLoginInfosDTO(stream(loginInfos.spliterator(), false)
                .map(m_loginInfoMapper::toLoginInfoDTO).toList());

        return Optional.of(loginInfosDTO);
    }

    public Optional<LoginInfosDTO> findLoginInfoByDateTime(LocalDate localDate)
    {
        var loginInfos = doForDataService(() -> m_chatSystemAppDataHelper.findLoginInfoByDateTime(localDate),
                "ChatSystemService::findLoginInfoByDateTime");

        var loginInfosDTO = m_loginInfoMapper.toLoginInfosDTO(stream(loginInfos.spliterator(), false)
                .map(m_loginInfoMapper::toLoginInfoDTO).toList());

        return Optional.of(loginInfosDTO);
    }


    public boolean existsUserByNickname(String username)
    {
        return doForDataService(() -> m_chatSystemAppDataHelper.existsUserByNickname(username),
                "ChatSystemService::existsUserByNickname");
    }

    public boolean existsUserByNickNameAndPassword(String nickName, String password)
    {
        return doForDataService(() -> m_chatSystemAppDataHelper.existsUserByNickNameAndPassword(nickName, password),
                "ChatSystemService::existsUserByNickNameAndPassword");
    }



}