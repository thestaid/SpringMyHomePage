package com.test.myhomepage.users.dao;

import java.util.List;

import com.test.myhomepage.users.dto.UsersDto;

public interface UsersDao {
	public boolean insert(UsersDto dto);
	public boolean isValid(UsersDto dto);
	public UsersDto getData(String id);
	public List<UsersDto> getList();
	public boolean update(UsersDto dto);
	public boolean delete(String id);
}
