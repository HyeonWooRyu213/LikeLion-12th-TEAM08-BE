package org.likelion.tm8.user.api;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.user.api.dto.request.UserSaveReqDto;
import org.likelion.tm8.user.api.dto.request.UserUpdateReqDto;
import org.likelion.tm8.user.api.dto.response.UserInfoResDto;
import org.likelion.tm8.user.api.dto.response.UserListResDto;
import org.likelion.tm8.user.application.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> userSave(@RequestBody UserSaveReqDto userSaveReqDto) {
        userService.userSave(userSaveReqDto);
        return new ResponseEntity<>("회원저장", HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<UserListResDto> userFindAll() {
        List<UserInfoResDto> users = userService.userFindAll();
        UserListResDto userListResDto = UserListResDto.from(users);
        return new ResponseEntity<>(userListResDto, HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> userUpdate(@PathVariable("userId") Long userId, @RequestBody UserUpdateReqDto userUpdateReqDto) {
        userService.userUpdate(userId, userUpdateReqDto);
        return new ResponseEntity<>("회원수정",HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> userDelete(@PathVariable("userId") Long userId) {
        userService.userDelete(userId);
        return new ResponseEntity<>("회원삭제",HttpStatus.OK);
    }

=======
public class UserController {
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
