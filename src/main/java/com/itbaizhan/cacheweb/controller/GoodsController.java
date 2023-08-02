package com.itbaizhan.cacheweb.controller;

import com.itbaizhan.cacheweb.entity.GoodsEntity;
import com.itbaizhan.cacheweb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品控制层
 */
@RestController
@RequestMapping("/goods")
public class GoodsController
{
    //商品业务层
    @Autowired
    private GoodsService goodsService;

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public GoodsEntity getById(String id)
    {
        return goodsService.getById(Long.valueOf(id));
    }
}
