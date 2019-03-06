package com.cn.custom_service.dao;
import java.util.List;

import com.cn.custom_service.pojo.Customer;

public interface CustomerDao {
    	
	public Customer CustomerLogin(String mailaddress,String password);
	public void CustomerRegister(Customer customer);
	public Customer getCSByMailaddress(String mailaddress);
	public void updatestatus(int cid);
}
/**

 *  @author锛氬闇�
 *  @time : 2018.4.14
 *
 **/
