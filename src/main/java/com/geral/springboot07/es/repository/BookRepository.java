package com.geral.springboot07.es.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.geral.springboot07.es.domin.entity.Book;


public interface BookRepository extends ElasticsearchRepository<Book, Integer>{

	  List<Book> findByTitle(String title,Pageable page);
	  
	  List<Book> findByTitleAndContent(String title,String content);
	  List<Book> findByTitleOrContent(String title,String content);
	  
	  List<Book> findByContent(String content);
	  List<Book> findByAuthor(String author);
}
