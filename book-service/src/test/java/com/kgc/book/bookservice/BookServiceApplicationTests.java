package com.kgc.book.bookservice;

import com.kgc.book.bean.BookManage;
import com.kgc.book.bookservice.mapper.BookManageMapper;
import com.kgc.book.bookservice.service.EsService;
import com.kgc.book.service.BookManageService;
import com.kgc.book.util.RedisUtil;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookServiceApplicationTests {
    @Resource
    BookManageMapper bookManageMapper;
    @Resource
    JestClient jestClient;
    @Resource
    RedissonClient redissonClient;
    @Resource
    RedisUtil redisUtil;
    @Resource
    BookManageService bookManageService;
    @Test
    void contextLoads2() {
        List<BookManage> allbook = bookManageMapper.selectByExample(null);
        System.out.println("bookmanagelist:"+allbook);
        for (BookManage book : allbook) {
            Index index=new Index.Builder(book).index("book").type("bookmanage").id(book.getbId()+"").build();
            try {
                jestClient.execute(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  /*  @Resource
    EsService esService;
    @Resource
    SearchResult searchResult;
    @Test
    void  test(){
        List<BookManage> list=new ArrayList<>();
        try {
            esService.getIndexMapping("book","bookmanage");
            List<SearchResult.Hit<BookManage,Void>> hits=searchResult.getHits(BookManage.class);
            for (SearchResult.Hit<BookManage,Void> hit: hits){
                list.add(hit.source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }*/
}
