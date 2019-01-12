package com.geral.springboot07.es;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.geral.springboot07.es.domin.entity.Article;
import com.geral.springboot07.es.domin.entity.Book;
import com.geral.springboot07.es.repository.BookRepository;

//import io.searchbox.client.JestClient;
//import io.searchbox.core.Index;
//import io.searchbox.core.Search;
//import io.searchbox.core.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot07EsApplicationTests {
	
	
	
//	@Autowired
//	JestClient jestClient;
//	@Test
//	public void contextLoads() {
//		//给es中索引（保存）一个文档
//		Article article=new Article();
//		article.setId(1);
//		article.setTitle("美特斯邦威");
//		article.setContent("Hello world");
//		article.setAuthor("panpan");
//		//构建一个索引功能
//		Index index=new Index.Builder(article).index("panpanwork").type("news").build();
//		//查询http://192.168.0.11:9200/panpanwork/news/1
//		try {
//			jestClient.execute(index);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 测试搜索全文搜索
//	 */
//	@Test
//	public void search() 
//	{
//		//查询表达式
//		String json="{\"query\":{\"match\":{\"content\":\"hello\"}}}";
//		Search search=new Search.Builder(json).addIndex("panpanwork").addType("news").build();
//		
//		try {
//		SearchResult result	=jestClient.execute(search);
//		System.out.println(result.getJsonString());
////		{"took":372,"timed_out":false,"_shards":{"total":5,"successful":5,"skipped":0,"failed":0},"hits":{"total":1,"max_score":0.25811607,"hits":[{"_index":"panpanwork","_type":"news","_id":"1","_score":0.25811607,"_source":{"id":1,"author":"panpan","title":"美特斯邦威","content":"Hello world"}}]}}
//		//可以参考官方文档https://github.com/searchbox-io/Jest/tree/master/jest
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	//////////////////////第二种方式///////////////////
	
	@Autowired
	BookRepository bookRepository;
	
	/**
	 * 写入一个索引
	 */
	@Test
	public void test02() 
	{
		Book book=new Book();
		book.setId(4);
		book.setAuthor("美国英雄");
		book.setTitle("复仇者联盟");
		book.setContent("一群土豪和屌丝的团队、");
		
		//这两个方法都一样
		bookRepository.index(book);
//		bookRepository.save(book);
	}
	
	/**
	 * 查询
	 */
	@Test
	public void test02_1() 
	{
//		bookRepository.findBy("新").forEach(book->System.out.println(book.getTitle()));
//		System.out.println(bookRepository.findByBookName("新"));
		//查询所有
//		bookRepository.findAll().forEach(book->System.out.println(book.getTitle()));
//		System.out.println(bookRepository.findOne(1).getTitle());
//		https://github.com/spring-projects/spring-data-elasticsearch
		
		//从第几页开始第一页为0，每页显示条数，排序规则、排序字段
		Pageable pageable = new PageRequest(1,2, Sort.Direction.ASC,"id");
		bookRepository.findByTitle("事件",pageable).forEach(book->System.out.println(book));
		
//		System.out.println("--------1------");
//		bookRepository.findByContent("联盟").forEach(book->System.out.println(book));
//		System.out.println("-----------2----------");
//		bookRepository.findByAuthor("英雄").forEach(book->System.out.println(book));
//		System.out.println("-----------3----------");
		
//		bookRepository.findByTitleAndContent("事件","222").forEach(book->System.out.println(book));
//		bookRepository.findByTitleOrContent("事件","222").forEach(book->System.out.println(book));
		
//		And  Or  Not Between Like 例如下面
//		List<Book> findByNameAndPrice(String name, Integer price);
//		List<Book> findByNameOrPrice(String name, Integer price);
//	    Page<Book> findByName(String name,Pageable page);
//		Page<Book> findByNameNot(String name,Pageable page);
//		Page<Book> findByPriceBetween(int price,Pageable page);
//		Page<Book> findByNameLike(String name,Pageable page);

	}
	
	

}

