package com.jubo.springboot01.system.service.impl;

import com.jubo.springboot01.system.bean.Menu;
import com.jubo.springboot01.system.mapper.MenuMapper;
import com.jubo.springboot01.system.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
