package Proxy;

import java.util.List;

import Bean.User;
import UserDao.UserDAO;
import UserDao.UserDAOImpl;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月11日 下午10:23:57 
* @function:
*/
public class UserProxy  implements UserDAO {
	private UserDAOImpl ud= null;

	public UserProxy() {		
		ud = new UserDAOImpl();
	}
	@Override
	public boolean addUser(User stu) {
		return ud.addUser(stu);
	}

	@Override
	public boolean deleteUser(int id) {
		return ud.deleteUser(id);
		
	}

	@Override
	public boolean updateUserInfo(User stu){ 
		return ud.updateUserInfo(stu);
	}

	@Override
	public List<User> getAllUser() {
		return ud.getAllUser();
	}

	@Override
	public User getUser(String name, String psd) {
		return ud.getUser(name,psd);
	}

	@Override
	public List<User> getUserByCondition(String name) {
		return ud.getUserByCondition(name);
	}
	@Override
	public boolean CheckUser(User user) {
		return ud.CheckUser(user);
	}
	
	
}
