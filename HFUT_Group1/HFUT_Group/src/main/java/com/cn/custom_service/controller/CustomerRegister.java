package com.cn.custom_service.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.custom_service.pojo.Customer;
import com.cn.custom_service.service.impl.CustomerServiceImpl;

/**
 * 
 * @author：夏震
 * 
 * @time : 2018.4.20
 *
 **/

@Controller
public class CustomerRegister {
	Pattern pattern1 = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");// 验证邮箱格式
	Pattern pattern2 = Pattern.compile("^\\+?[1-9][0-9]*$");// 验证年龄为正整数
	@Resource
	private CustomerServiceImpl Icustomer;

	@RequestMapping("/register.action")
	@ResponseBody
	public Customer customerRegister(@RequestBody Customer customer) {
		
		Customer customer1 = new Customer();
		customer1 = Icustomer.getCSByMailaddress(customer.getMailaddress());
		System.out.println("到达regist"+customer);
		String mailaddress = customer.getMailaddress();
		System.out.println(mailaddress);
		int gender = customer.getGender();
		int age = customer.getAge();
	
		
		if (mailaddress == null || mailaddress.trim() == "") {
			customer.setErrorMessage("邮箱不能为空！");
			return customer;

		}

		if (!pattern1.matcher(mailaddress).matches()) {
			customer.setErrorMessage("邮箱格式不正确！请输入正确的邮箱地址！");
			return customer;

		}
		if (Integer.toString(gender)== null ||Integer.toString(gender).trim() == ""){
			customer.setErrorMessage("请输入性别！");
			return customer;
		}
		if (Integer.toString(age)== null ||Integer.toString(age).trim() == ""){
			customer.setErrorMessage("年龄不能为空！");
			return customer;
		}
		if (!pattern2.matcher(Integer.toString(age)).matches()) {
			customer.setErrorMessage("年龄应为正整数！");
			return customer;
		
		}

		try {
			customer1 = Icustomer.getCSByMailaddress(mailaddress);
			System.out.println(customer.getMailaddress());
			customer.setErrorMessage("用户已注册！");
			customer1.setStatus1(6);
			//errors.put("error4", "用户已注册！");
			System.out.println("adsdasdas");	
			return customer;

		} catch (Exception e) {
			//mav.addObject("success", "注册成功！");
			customer.setPassword("123456");
			customer.setImages(" ");
			customer.setTelno(" ");
			Icustomer.CustomerRegister(customer);
			//customer1.setStatus1(0);
			System.out.println(customer);
			System.out.println("chenggong");
			return customer;
		}
	}
}
