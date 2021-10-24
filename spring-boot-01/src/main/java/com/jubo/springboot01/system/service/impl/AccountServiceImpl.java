package com.jubo.springboot01.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jubo.springboot01.common.utils.RespStat;
import com.jubo.springboot01.system.bean.Account;
import com.jubo.springboot01.system.mapper.AccountMapper;
import com.jubo.springboot01.system.service.AccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    public Account findByLoginNameAndPassword(String loginName, String password) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name", loginName);
        wrapper.eq("password", password);
        Account account = baseMapper.selectOne(wrapper);
        return account;
    }

    public Page<Account> findByPage(int pageNum, int pageSize) {
        Page<Account> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return baseMapper.selectPageVo(page);
    }

    public RespStat deleteById(int id) {
        int row = baseMapper.deleteById(id);
        if (row == 1) {
            return RespStat.build(200, "success");
        } else {
            return RespStat.build(500, "error");
        }
    }

    public void update(Account account) {
        baseMapper.updateById(account);
    }
}
