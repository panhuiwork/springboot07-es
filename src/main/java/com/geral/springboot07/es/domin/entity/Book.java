package com.geral.springboot07.es.domin.entity;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName="panpanwork",type="book")
public class Book implements Serializable{
	private Integer id;
	private String author;
	private String title;
	private String content;
}
