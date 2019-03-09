package com.dominos.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.sql.SQLException;
import java.util.Set;

import com.dominos.dao.*;
import com.dominos.models.*;

import org.junit.Test;

public class UsersTest {

	@Test
	void testAddUser() throws SQLException, ClassNotFoundException {
		UserDAO dao = new UserDAO();
		int oldCountOfUsers = dao.getAllUsers().size();
		
		dao.register(new User(1, "Ivan", "Georgiev", "ul.Vishneva N30", "ivanGeorgiev@abv.bg", "pecheniq"));
		int newCountOfUsers = dao.getAllUsers().size();
	
		assertNotSame(oldCountOfUsers, newCountOfUsers);
	}
	
	@Test
	void testAddUserAgain() throws ClassNotFoundException, SQLException {
		UserDAO dao = new UserDAO();
		User user = new User(1, "Ivan", "Georgiev", "ul.Vishneva N30", "ivanGeorgiev@abv.bg", "pecheniq");
		dao.register(user);
		
		List<User> users = dao.getAllUsers();
		assertTrue(users.stream().filter(user1 -> 
		user1.getEmail().equals(user.getEmail()))
				.findAny().isPresent());
		
		dao.removeUser(user.getId());
	}
	
	@Test
	void testDeleteUser() {
		
	}
	
	
}
