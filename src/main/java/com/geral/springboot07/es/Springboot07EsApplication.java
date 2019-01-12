package com.geral.springboot07.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和ES交互
 * 1.Jest 默认不生效，需要导入jest工具包（io.searchbox.client.JestClient）
 * 2.SpringData ElaticSearch【ES版本有可能不合适】
 * 	 版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 * 	如果版本不适配：2.4.6(1)升级springboot版本。（2）安装对应版本的ES (3)配置yml注意端口用的不是9200是9300那个。
 * spring data elasticsearch	elasticsearch
 *	3.2.x							6.5.0
 *	3.1.x							6.2.2
 *	3.0.x							5.5.0
 *	2.1.x							2.4.0
 *	2.0.x							2.2.0
 *	1.3.x							1.5.2
 * 		 
 * 	 （1）Client 节点信息clustertNodes;cluestrtName
 * 	 （2）ElasticSearchTemplate操作es
 * 	 (3)编写一个ElasticSearchRepository的子接口来操作ES
 * 两种用法：
 * （1）编写一个ElasticSearchRepository
 * @author Panhui
 *
 */
@SpringBootApplication
public class Springboot07EsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot07EsApplication.class, args);
	}

}

