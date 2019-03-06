package com.cn.custom_service.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.custom_service.dao.CsAdminDao;
import com.cn.custom_service.dao.CustomerDao;
import com.cn.custom_service.pojo.Admin;
import com.cn.custom_service.pojo.Customer;
import com.cn.custom_service.service.CustomerService;

/**

 *  @author锛氬闇�
 *  @time : 2018.4.14 
 *
 **/

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
@Resource
private CustomerDao customerDao;
@Resource
private CsAdminDao adminDao;
	@Override
	public Customer CustomerLogin(String mailaddress, String password) {
		
		
		return customerDao.CustomerLogin(mailaddress, password);
	}
	public void CustomerRegister(Customer customer) {
		
		 
		 customerDao.CustomerRegister(customer); 
	}
	public Customer getCSByMailaddress(String mailaddress){
		
		
		return customerDao.getCSByMailaddress(mailaddress);
		
	}
	public void updatestatus(int cid){
		customerDao.updatestatus(cid);
	}
	public Admin getAdminPasswordByMail(String mail, String password) {
		// TODO Auto-generated method stub
		return adminDao.customerAdminLogin(mail, password);
	}
}
