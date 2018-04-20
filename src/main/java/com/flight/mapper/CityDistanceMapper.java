package com.flight.mapper;

import com.flight.bean.CityDistance;
import com.flight.bean.CityDistanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityDistanceMapper {
    int countByExample(CityDistanceExample example);

    int deleteByExample(CityDistanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityDistance record);

    int insertSelective(CityDistance record);

    List<CityDistance> selectByExample(CityDistanceExample example);

    CityDistance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityDistance record, @Param("example") CityDistanceExample example);

    int updateByExample(@Param("record") CityDistance record, @Param("example") CityDistanceExample example);

    int updateByPrimaryKeySelective(CityDistance record);

    int updateByPrimaryKey(CityDistance record);
    
    int truncateTable();
}