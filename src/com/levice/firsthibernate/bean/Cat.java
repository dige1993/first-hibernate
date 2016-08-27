package com.levice.firsthibernate.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity                              //注解Entity表示该类能被Hibernate持久化
@Table(name = "tb_cat")              //指定该Entity对应的数据表名
public class Cat {

	@Id                              //指定该列为主键。主键类型最好不要使用int等原始类型
	@GeneratedValue(strategy = GenerationType.AUTO) //主键类型auto表示该主键为自增长型
	private Integer id;
	
	@Column(name = "name")           //指定该属性对应的数据库表的列为name，列名与属性名一样时这句注解可省略
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne                       //指定实体类之间的关系，本例表示多对一关系
	@JoinColumn(name = "mother_id")
	private Cat mother;
	
	@Temporal(TemporalType.TIMESTAMP)//日期类型（DATE，TIME或TIMESTEMP）
	@Column(name = "birthday")
	private Date birthday;
	
	
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Cat getMother() {
		return mother;
	}
	public void setMother(Cat mother) {
		this.mother = mother;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}	
}
