package dev.nicklx2.movies;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody Map<String,String> map){
        String email= map.get("email");
        String userAccount= map.get("userAccount");
        String userPassword= map.get("userPassword");
        String result="請輸入賬號密碼!";
        if(StringUtils.isBlank(email)||StringUtils.isBlank(userAccount)||StringUtils.isBlank(userPassword)){
            return ResponseEntity.ok(result);
        }else{
            result=userService.verifyUser(email, userAccount, userPassword);
            return ResponseEntity.ok(result);
        }
    }
}
