package com.jubo.springboot01.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jubo.springboot01.system.bean.Role;
import com.jubo.springboot01.system.mapper.RoleMapper;
import com.jubo.springboot01.system.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    public Page<Role> findByPage(int pageNum, int pageSize) {
        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return baseMapper.selectPageVo(page);
    }
}
