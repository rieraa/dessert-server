package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.mapper.DessertMapper;
import com.example.desserts.model.vo.DessertListVO;
import com.example.desserts.model.entity.Dessert;
import com.example.desserts.service.DessertService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class DessertServiceImpl extends ServiceImpl<DessertMapper, Dessert> implements DessertService {


    @Override
    public DessertListVO getDessertList(Integer pageNum, Integer pageSize) {
        // 创建一个 DessertListVO 对象
        DessertListVO result = new DessertListVO();

        // 查询第 pageNum 页数据，每页 pageSize 条
        Page<Dessert> page = new Page<>(pageNum, pageSize);

        // todo 哪里来的this
        page = this.page(page, null);
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总共多少页：" + page.getPages());
        System.out.println("当前页码：" + page.getCurrent());

        // 当前页数据
        List<Dessert> list = page.getRecords();
        System.out.println("当前页数据：" + list);

        // 将查询结果设置到 DessertListVO 对象中
        result.setDesserts(list);

        // 判断是否还有更多数据
        result.setHasMoreData(page.hasNext());

        return result;
    }

}
