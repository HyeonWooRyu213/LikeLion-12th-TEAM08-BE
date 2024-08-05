package org.likelion.tm8.auth.api;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.auth.api.dto.Token;
import org.likelion.tm8.auth.application.AuthLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login/oauth2")
public class AuthLoginController {
    private final AuthLoginService authLoginService;

    //콘솔에 Authorization code 출력
//    @GetMapping("/code/{registrationId}")
//    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
//        authLoginService.socialLogin(code, registrationId);
//    }

    @GetMapping("/code/google")
    public Token googleCallback(@RequestParam(name = "code") String code) {
        String googleAccessToken = authLoginService.getGoogleAccessToken(code);
        return loginOrSignup(googleAccessToken);
    }

    public Token loginOrSignup(String googleAccessToken) {
        return authLoginService.loginOrSignUp(googleAccessToken);
    }
}
