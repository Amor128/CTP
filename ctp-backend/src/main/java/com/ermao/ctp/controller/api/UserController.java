package com.ermao.ctp.controller.api;

import com.ermao.ctp.service.UserService;
import com.ermao.ctp.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Ermao
 * Date: 2022/12/7 11:19
 */
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Response<Object> register(@RequestBody Map<String, String> map) {
        if (map != null) {
            if (log.isDebugEnabled()) {
                log.debug("get user register info: {}", map);
            }
            String phone = map.get("phone");
            String password = map.get("password");
            String confirmPassword = map.get("confirmPassword");
            if (phone == null || password == null || confirmPassword == null) {
                return Response.fail();
            }
            if (!password.equals(confirmPassword)) {
                return Response.fail();
            }

            Boolean registerResult = userService.userRegister(phone, password);
            if (registerResult) {
                return Response.ok();
            }
        }
        return Response.fail();
    }

    @PostMapping("/sessions")
    public Response<Object> login(@RequestBody Map<String, String> map) {
        if (map != null) {
            if (log.isDebugEnabled()) {
                log.debug("get user register info: {}", map);
            }
            String phone = map.get("phone");
            String password = map.get("password");
            if (phone == null || password == null) {
                return Response.fail();
            }

            Boolean loginResult = userService.userLogin(phone, password);
            if (loginResult) {
                return Response.ok();
            }
        }
        return Response.fail();
    }
}
