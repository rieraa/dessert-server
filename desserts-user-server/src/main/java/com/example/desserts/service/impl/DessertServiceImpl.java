package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.domain.DTO.AddDessertDTO;
import com.example.desserts.mapper.DessertMapper;
import com.example.desserts.mapper.SpecificationMapper;
import com.example.desserts.mapper.TasteMapper;
import com.example.desserts.model.entity.Dessert;
import com.example.desserts.model.entity.Specification;
import com.example.desserts.model.entity.Taste;
import com.example.desserts.model.vo.DessertDetailVO;
import com.example.desserts.model.vo.DessertListVO;
import com.example.desserts.service.DessertService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 甜品相关服务实现类
 */
@Transactional // 如果在任何步骤中出现错误，整个操作都会回滚
@Service
public class DessertServiceImpl extends ServiceImpl<DessertMapper, Dessert> implements DessertService {

    @Resource
    DessertMapper dessertMapper;
    @Resource
    SpecificationMapper specificationMapper;
    @Resource
    TasteMapper tasteMapper;


    @Override
    public DessertListVO getDessertList(Integer pageNum, Integer pageSize) {
        // 创建一个 DessertListVO 对象
        DessertListVO result = new DessertListVO();

        // 查询第 pageNum 页数据，每页 pageSize 条
        Page<Dessert> page = new Page<>(pageNum, pageSize);

        page = this.page(page, null);
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总共多少页：" + page.getPages());
        System.out.println("当前页码：" + page.getCurrent());

        // 当前页数据
        List<Dessert> list = page.getRecords();
        System.out.println("当前页数据：" + list);

        // 将查询结果设置到 DessertListVO 对象中
        result.setDesserts(list);
        result.setTotal(page.getTotal());

        // 判断是否还有更多数据
        result.setHasMoreData(page.hasNext());

        return result;
    }

    @Override
    public DessertDetailVO getDessertDetail(Integer dessertId) {

        DessertDetailVO dessertDetailVO;
        dessertDetailVO = dessertMapper.selectDetailById(dessertId);
        // 查询甜品规格及口味列表
        List<Specification> specificationList = specificationMapper.selectByDessertId(dessertId);
        List<Taste> tasteList = tasteMapper.selectByDessertId(dessertId);
        dessertDetailVO.setTasteList(tasteList);
        dessertDetailVO.setSpecificationList(specificationList);
        return dessertDetailVO;
    }

    @Override
    public void addDessert(AddDessertDTO addDessertDTO) {
        dessertMapper.insert(addDessertDTO);
        int dessertId = addDessertDTO.getDessertId();

        Specification specification = new Specification();
        Taste taste = new Taste();
        specification.setDessertId(dessertId);
        specification.setSpeName(addDessertDTO.getSpeName());
        specification.setExtra(addDessertDTO.getExtra());
        specificationMapper.insert(specification);
        taste.setDessertId(dessertId);
        taste.setTasteName(addDessertDTO.getTasteName());
        tasteMapper.insert(taste);

    }

    @Override
    public void deleteDessert(Integer dessertId) {
        dessertMapper.deleteById(dessertId);
        specificationMapper.deleteByDessertId(dessertId);
        tasteMapper.deleteByDessertId(dessertId);
    }


}
