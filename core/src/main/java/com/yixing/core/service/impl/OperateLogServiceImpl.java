package com.yixing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yixing.core.dao.OperateLogMapper;
import com.yixing.core.entity.OperateLog;
import com.yixing.core.service.IOperateLogService;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog>  implements IOperateLogService {
}
