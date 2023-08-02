package com.itbaizhan.cacheweb.repository;


import com.itbaizhan.cacheweb.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品持久层
 */
public interface GoodsRepository extends JpaRepository<GoodsEntity,Long>
{

}
