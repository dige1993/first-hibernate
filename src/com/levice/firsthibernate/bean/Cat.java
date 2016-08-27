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

@Entity                              //ע��Entity��ʾ�����ܱ�Hibernate�־û�
@Table(name = "tb_cat")              //ָ����Entity��Ӧ�����ݱ���
public class Cat {

	@Id                              //ָ������Ϊ����������������ò�Ҫʹ��int��ԭʼ����
	@GeneratedValue(strategy = GenerationType.AUTO) //��������auto��ʾ������Ϊ��������
	private Integer id;
	
	@Column(name = "name")           //ָ�������Զ�Ӧ�����ݿ�����Ϊname��������������һ��ʱ���ע���ʡ��
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne                       //ָ��ʵ����֮��Ĺ�ϵ��������ʾ���һ��ϵ
	@JoinColumn(name = "mother_id")
	private Cat mother;
	
	@Temporal(TemporalType.TIMESTAMP)//�������ͣ�DATE��TIME��TIMESTEMP��
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
