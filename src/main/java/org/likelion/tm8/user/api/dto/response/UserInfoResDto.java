package org.likelion.tm8.user.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.user.domain.User;

@Builder
public record UserInfoResDto(
    Long userId,
    String email,
    String name,
    String gender,
    int age,
    int height
) {
    public static UserInfoResDto from(User user) {
        return UserInfoResDto.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .gender(user.getGender())
                .age(user.getAge())
                .height(user.getHeight())
                .build();
    }
}
