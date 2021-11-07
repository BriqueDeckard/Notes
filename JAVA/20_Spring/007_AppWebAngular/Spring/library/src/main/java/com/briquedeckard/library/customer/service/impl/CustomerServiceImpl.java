package com.briquedeckard.library.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briquedeckard.library.customer.Customer;
import com.briquedeckard.library.customer.dao.CustomerDao;
import com.briquedeckard.library.customer.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerDao.deleteById(customerId);

	}

	@Override
	public boolean checkIfIdexists(Integer id) {
		return customerDao.existsById(id);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerDao.findCustomerByEmailIgnoreCase(email);
	}

	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
		return customerDao.findCustomerByLastNameIgnoreCase(lastName);
	}

	@Override
	public Customer findCustomerById(Integer customerId) {
		return customerDao.getOne(customerId);
	}

	@Override
	public Page<Customer> getPaginatedCustomersList(int begin, int end) {
		Pageable page = PageRequest.of(begin, end);
		return customerDao.findAll(page);

	}

}
