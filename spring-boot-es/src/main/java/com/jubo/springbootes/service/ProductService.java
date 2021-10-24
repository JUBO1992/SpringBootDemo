package com.jubo.springbootes.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jubo.springbootes.model.bean.Product;
import com.jubo.springbootes.model.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
 * @author JUBO
 */
@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> {
}
