package com.jubo.springboot01.system.service.impl;

import com.jubo.springboot01.system.bean.AccountRole;
import com.jubo.springboot01.system.mapper.AccountRoleMapper;
import com.jubo.springboot01.system.service.AccountRoleService;
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
public class AccountRoleServiceImpl extends ServiceImpl<AccountRoleMapper, AccountRole> implements AccountRoleService {

}
