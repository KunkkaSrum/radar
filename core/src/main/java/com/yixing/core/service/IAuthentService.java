package com.yixing.core.service;

import com.yixing.core.vo.AuthVo;

import java.util.List;

public interface IAuthentService {
    List<AuthVo> listHasPower(Integer id);
    List<AuthVo> listNav();
}
