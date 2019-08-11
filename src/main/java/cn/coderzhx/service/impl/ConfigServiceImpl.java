package cn.coderzhx.service.impl;

import cn.coderzhx.entity.Config;
import cn.coderzhx.mapper.ConfigMapper;
import cn.coderzhx.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhx
 * @create 2019-08-11-18
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    ConfigMapper configMapper;
    @Override
    public void editconfig(Config config,String name) {
        if (name.equals("siteInfo")){
            configMapper.editconfigsiteInfo(config);
        }else if (name.equals("seoInfo")){
            configMapper.editconfigseoInfo(config);
        }else if (name.equals("meInfo")){
            configMapper.editconfigmeInfo(config);
        }else if (name.equals("picInfo")){
        configMapper.editconfigpicInfo(config);
        }
    }
}
