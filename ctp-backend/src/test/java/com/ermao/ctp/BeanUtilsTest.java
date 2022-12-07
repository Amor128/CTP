package com.ermao.ctp;

import com.ermao.ctp.pojo.DO.UserDO;
import com.ermao.ctp.pojo.DTO.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author Ermao
 * Date: 2022/12/8 0:12
 */
public class BeanUtilsTest {

    @Test
    public void testBeanUtils() {
        UserDO userDO = new UserDO("12345678910", "12345");
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);
        System.out.println(userDTO);
    }
}
