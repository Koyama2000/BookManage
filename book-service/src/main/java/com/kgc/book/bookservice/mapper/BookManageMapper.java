package com.kgc.book.bookservice.mapper;

import com.kgc.book.bean.BookManage;
import com.kgc.book.bean.BookManageExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BookManageMapper {
    int countByExample(BookManageExample example);

    int deleteByExample(BookManageExample example);

    int deleteByPrimaryKey(Integer bId);

    int insert(BookManage record);

    int insertSelective(BookManage record);

    List<BookManage> selectByExample(BookManageExample example);

    BookManage selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") BookManage record, @Param("example") BookManageExample example);

    int updateByExample(@Param("record") BookManage record, @Param("example") BookManageExample example);

    int updateByPrimaryKeySelective(BookManage record);

    int updateByPrimaryKey(BookManage record);
}