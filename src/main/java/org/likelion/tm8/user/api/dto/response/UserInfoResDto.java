package org.likelion.tm8.user.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.user.domain.User;

@Builder
public record UserInfoResDto(
    Long userId,
    String email,
    String name,
    int age
) {
    public static UserInfoResDto from(User user) {
        return UserInfoResDto.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
