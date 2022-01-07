package dev.fringe.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

import lombok.SneakyThrows;

@Configuration
@MapperScan(basePackages = "dev.fringe.mapper")
public class MapperConfig {

	@Bean
	@SneakyThrows
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource d){
		MybatisSqlSessionFactoryBean s = new MybatisSqlSessionFactoryBean();
		GlobalConfig config = new GlobalConfig();
		config.setBanner(false);
		s.setGlobalConfig(config);
		s.setDataSource(d);
		s.setTypeAliasesPackage("dev.fringe.model");
		return s.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory s) {
		return new SqlSessionTemplate(s);
	}
}
