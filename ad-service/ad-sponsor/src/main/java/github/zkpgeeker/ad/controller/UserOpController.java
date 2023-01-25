package github.zkpgeeker.ad.controller;

import com.alibaba.fastjson.JSON;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.service.UserService;
import github.zkpgeeker.ad.vo.CreateUserRequest;
import github.zkpgeeker.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
@Slf4j
@RestController
public class UserOpController {

    private final UserService userService;

    public UserOpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
