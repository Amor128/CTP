package com.ermao.ctp.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/12 16:51
 */
@Data
public class MyPage implements Serializable {

    private final static long serialVersionUID = -3760445487636086034L;

    private Long page;

    private Long perPage;

    private Long total;

    private Object list;

    public MyPage(Long page, Long perPage, Long total, Object list) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.list = list;
    }
}
