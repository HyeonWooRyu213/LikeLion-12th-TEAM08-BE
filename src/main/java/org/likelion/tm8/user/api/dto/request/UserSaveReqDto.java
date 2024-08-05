package org.likelion.tm8.user.api.dto.request;

public record UserSaveReqDto(
        String email,
        String name,
        String pw,
        String gender,
        int age,
        int height
) {
}
