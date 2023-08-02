package com.itbaizhan.cacheweb.service;

import com.alibaba.fastjson.JSON;
import com.itbaizhan.cacheweb.entity.GoodsEntity;
import com.itbaizhan.cacheweb.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 商品业务层
 */
@Service
public class GoodsService
{
    @Autowired
     private GoodsRepository goodsRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 根据id查询商品信息
     * @param id 商品id
     * @return
     */
    public GoodsEntity getById(Long id)
    {
        // 查询缓存
        String goodsString = stringRedisTemplate.opsForValue().get("goods:" + id);
        //判断有没有缓存
        if(StringUtils.isEmpty(goodsString))
        {
            // 从数据库中查询商品信息
            Optional<GoodsEntity> optionalGoodsEntity = goodsRepository.findById(id);
            if(optionalGoodsEntity.isPresent())
            {
                GoodsEntity goodsEntity = optionalGoodsEntity.get();
                String goodsEntityJson = JSON.toJSONString(goodsEntity);
                stringRedisTemplate.opsForValue().set("goods:"+id,goodsEntityJson);
                return goodsEntity;
            }
        }
        else
        {
            GoodsEntity goodsEntity = JSON.parseObject(goodsString, GoodsEntity.class);
            return goodsEntity;
        }



        return null;
    }
}
