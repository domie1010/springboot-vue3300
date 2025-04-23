package com.dao;

import com.entity.ChuqinlvEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuqinlvView;

/**
 * 出勤率 Dao 接口
 *
 * @author 
 */
public interface ChuqinlvDao extends BaseMapper<ChuqinlvEntity> {

   List<ChuqinlvView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
