package org.likelion.tm8.user.api.dto.request;

public record UserUpdateReqDto(
        String email,
        String name,
        String pw,
        int age
) {
}
