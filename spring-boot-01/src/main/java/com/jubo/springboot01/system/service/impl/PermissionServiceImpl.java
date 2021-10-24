package com.jubo.springboot01.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jubo.springboot01.system.bean.Permission;
import com.jubo.springboot01.system.mapper.PermissionMapper;
import com.jubo.springboot01.system.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jubo
 * @since 2021-03-21
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    public Page<Permission> findByPage(int pageNum, int pageSize) {
        Page<Permission> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return baseMapper.selectPageVo(page);
    }
}
