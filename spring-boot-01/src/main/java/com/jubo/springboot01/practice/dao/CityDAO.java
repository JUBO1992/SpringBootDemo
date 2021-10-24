package com.jubo.springboot01.practice.dao;

import com.jubo.springboot01.practice.bean.City;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/02/25
 */
@Repository
public class CityDAO {
    /**
     * 在内存中虚拟出一份数据
     * List
     * Map
     * 需要保证现场安全
     */

    static Map<Integer, City> dataMap = Collections.synchronizedMap(new HashMap<>());

    public List<City> findAll() {
        return new ArrayList<>(dataMap.values());
    }

    public void save(City city) throws Exception {
        City data = dataMap.get(city.getId());
        if (data != null) {
            throw new Exception("数据已存在");
        } else {
            dataMap.put(city.getId(), city);
            System.out.println("数据已经添加");
        }
    }
}
