package com.dao;

import com.entity.FenshujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FenshujiluView;

/**
 * 分数记录 Dao 接口
 *
 * @author 
 */
public interface FenshujiluDao extends BaseMapper<FenshujiluEntity> {

   List<FenshujiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
