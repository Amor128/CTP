package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DO.UserDO;
import com.ermao.ctp.pojo.DTO.UserDTO;
import com.ermao.ctp.service.UserService;
import com.ermao.ctp.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Response register(@RequestBody Map<String, String> map) {
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
            if (userService.getUser(phone) != null) {
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
    public Response login(@RequestBody Map<String, String> map) {
        if (map != null) {
            if (log.isDebugEnabled()) {
                log.debug("get user register info: {}", map);
            }
            String phone = map.get("phone");
            String password = map.get("password");
            if (phone == null || password == null) {
                return Response.fail();
            }
            UserDTO userDTO = userService.getUser(phone, password);
            if (userDTO != null) {
                HashMap<String, Long> resultMap = new HashMap<>();
                resultMap.put("id", userDTO.getId());
                return Response.ok(resultMap);
            }
        }
        return Response.fail();
    }

    @GetMapping("/{userID}")
    public Response getUser(@PathVariable("userID") Long userID) {
        if (log.isDebugEnabled()) {
            log.debug("UserController.getUser params, userID: {}", userID);
        }
        if (userID != null) {
            UserDTO userDTO = userService.getUser(userID);
            if (log.isDebugEnabled()) {
                log.debug("UserController.getUser return, userDTO: {}", userDTO);
            }
            return Response.ok(userDTO);
        }
        return Response.fail();
    }

    @PutMapping("/{userID}")
    public Response updateUser(@PathVariable Long userID, @RequestBody UserDTO userDTO) {
        if (log.isDebugEnabled()) {
            log.debug("UserController.updateUser params, userDTO: {}", userDTO);
        }

        userDTO.setId(userID);
        return userService.updateUser(userDTO) ? Response.ok() : Response.fail();
    }

    @GetMapping("/test")
    public Response getUser() {
        return Response.ok();
    }
}
