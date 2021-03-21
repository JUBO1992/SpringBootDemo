package com.jubo.demo.system.service.impl;

import com.jubo.demo.system.bean.Account;
import com.jubo.demo.system.mapper.AccountMapper;
import com.jubo.demo.system.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jubo
 * @since 2021-03-21
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
