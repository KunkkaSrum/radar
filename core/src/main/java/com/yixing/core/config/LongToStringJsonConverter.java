package com.yixing.core.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class LongToStringJsonConverter extends ObjectMapper {
    /**
     *
     */
    private static final long serialVersionUID = 1683531771040674386L;

    @Override
    public ObjectMapper registerModule(Module module) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        return super.registerModule(simpleModule);
    }
}