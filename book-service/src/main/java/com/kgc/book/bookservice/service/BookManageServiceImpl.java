package com.kgc.book.bookservice.service;

import com.kgc.book.bean.BookManage;
import com.kgc.book.bookservice.mapper.BookManageMapper;
import com.kgc.book.service.BookManageService;
import com.kgc.book.util.RedisUtil;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.dubbo.config.annotation.Service;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class BookManageServiceImpl implements BookManageService {
    @Resource
    BookManageMapper bookManageMapper;
    @Resource
    JestClient jestClient;
    @Resource
    RedissonClient redissonClient;
    @Resource
    RedisUtil redisUtil;
    @Resource
    EsService esService;
    @Override
    public List<BookManage> BOOK_LIST() {
        List<BookManage> list=new ArrayList<>();
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder();
        searchSourceBuilder.query(boolQueryBuilder);
        String dsl=searchSourceBuilder.toString();
        Search search=new Search.Builder(dsl).addIndex("book").addType("bookmanage").build();
        try {
            SearchResult searchResult=jestClient.execute(search);
            List<SearchResult.Hit<BookManage,Void>> hits=searchResult.getHits(BookManage.class);
            for (SearchResult.Hit<BookManage,Void> hit: hits){
                list.add(hit.source);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int DEL_BOOK(int id) {
        String index=String.valueOf(id);
        int result=bookManageMapper.deleteByPrimaryKey(id);
        if(result>0){
            try {
                esService.deleteData(index,"book","bookmanage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int ADD_BOOK(BookManage bookManage) {
        int result=bookManageMapper.insertSelective(bookManage);
        if(result>0){
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
        return result;
    }

}
