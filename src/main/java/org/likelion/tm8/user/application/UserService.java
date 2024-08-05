package org.likelion.tm8.user.application;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.user.api.dto.request.UserSaveReqDto;
import org.likelion.tm8.user.api.dto.request.UserUpdateReqDto;
import org.likelion.tm8.user.api.dto.response.UserInfoResDto;
import org.likelion.tm8.user.domain.User;
import org.likelion.tm8.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void userSave(UserSaveReqDto userSaveReqDto) {
        if (userRepository.existsByEmail(userSaveReqDto.email())) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }
        User user = User.builder()
                .email(userSaveReqDto.email())
                .name(userSaveReqDto.name())
                .age(userSaveReqDto.age())
                .build();

        userRepository.save(user);
    }

    public List<UserInfoResDto> userFindAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserInfoResDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserInfoResDto userUpdate(Long userId, UserUpdateReqDto userUpdateReqDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("회원 없음"));

        user.update(userUpdateReqDto);

        return UserInfoResDto.from(user);
    }

    @Transactional
    public UserInfoResDto userDelete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("회원 없음 id = " + userId));

        userRepository.delete(user);

        return UserInfoResDto.from(user);
    }
}
