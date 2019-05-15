package com.yixing.core.controller;

import com.yixing.core.model.ResultData;
import com.yixing.core.service.IAuthentService;
import com.yixing.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/core/auth")
@Controller
public class AuthentController {
    @Autowired
    private IAuthentService iAuthentService;

    @RequestMapping(value = "/nav", method = RequestMethod.POST)
    @ResponseBody
    public ResultData listNav() {
        return new ResultData(1, 0, "查询成功！", iAuthentService.listNav());
    }

    @RequestMapping(value = "/power", method = RequestMethod.POST)
    @ResponseBody
    public ResultData listHasPower(@RequestParam("id")Integer id) {
        return new ResultData(1, 0, "查询成功！", iAuthentService.listHasPower(id));
    }
}
