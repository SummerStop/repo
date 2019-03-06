package com.cn.custom_service.service;

import com.cn.custom_service.pojo.Admin;
import com.cn.custom_service.pojo.Customer;

public interface CustomerService {
	public Customer CustomerLogin(String mailaddress, String password);
	public void CustomerRegister(Customer customer);
	public Customer getCSByMailaddress(String mailaddress);
	public void updatestatus(int cid);
	public Admin getAdminPasswordByMail(String mail,String password);
}

/**

 *  @author閿涙艾顦撮棁锟�
 *  @time : 2018.4.14
 *
 **/