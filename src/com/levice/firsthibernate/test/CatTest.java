package com.levice.firsthibernate.test;

import java.awt.Font;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.levice.firsthibernate.bean.Cat;
import com.levice.firsthibernate.util.HibernateUtil;

public class CatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*初始化几只Cat的信息*/
		Cat mother = new Cat();
		mother.setName("Mother White");
		mother.setDescription("This is mother cat");
		mother.setBirthday(new Date());

		Cat kitty = new Cat();
		kitty.setMother(mother);
		kitty.setName("Kitty");
		kitty.setDescription("This is Kitty");
		kitty.setBirthday(new Date());

		Cat tom = new Cat();
		tom.setMother(mother);
		tom.setName("Tom");
		tom.setDescription("This is Tom");
		tom.setBirthday(new Date());

		@SuppressWarnings("static-access")
		Session session = new HibernateUtil().getSessionFactory().openSession(); //获取session并open，开启一个Hibernate会话
		Transaction trans = session.beginTransaction(); //开启一个事务

		session.persist(mother); //将mother保存到数据库
		session.persist(kitty);
		session.persist(tom);

		@SuppressWarnings("all")
		List<Cat> catList = session.createQuery(" from Cat ").list(); //查询数据库中所有的猫
		StringBuffer result = new StringBuffer();
		result.append("all cats: \r\n\r\n");
		for (Cat cc : catList) {
			result.append("name:" + cc.getName() + "\n");
			result.append("mother:" + (cc.getMother() == null ? "null" : cc.getMother().getName()) + "\n");
			result.append("description:" + cc.getDescription() + "\r\n\r\n");
		}

		trans.commit(); //提交事务
		session.close(); //关闭Hibernate会话

		//用Swing显示查询结果
		JOptionPane.getRootFrame().setFont(new Font("Arial", Font.BOLD, 14));
		JOptionPane.showMessageDialog(null, result.toString());

	}

}

