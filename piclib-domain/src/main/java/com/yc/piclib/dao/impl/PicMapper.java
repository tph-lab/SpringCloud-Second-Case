package com.yc.piclib.dao.impl;

import com.yc.piclib.dao.MisBaseMapper;
import com.yc.piclib.entity.Pic;
import org.apache.ibatis.annotations.Mapper;

//记得加，
@Mapper  //具体操作某张表的mapper           //注意不能跟MisBaseMapper在同一个包下面
//具体的接口，注意要传泛型过去
public interface PicMapper extends MisBaseMapper<Pic> {
}