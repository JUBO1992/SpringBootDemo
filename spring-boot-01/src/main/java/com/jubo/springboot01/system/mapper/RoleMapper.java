package com.jubo.springboot01.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jubo.springboot01.system.bean.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jubo
 * @since 2021-03-21
 */
public interface RoleMapper extends BaseMapper<Role> {

    Page<Role> selectPageVo(Page<Role> page);
}
