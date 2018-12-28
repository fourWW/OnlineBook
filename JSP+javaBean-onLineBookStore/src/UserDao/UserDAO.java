package UserDao;

import java.util.List;

import Bean.User;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月6日 上午9:23:53 
* @function:
*/
public interface UserDAO {
	//查询用户是否存在
	public boolean CheckUser(User user);
    //添加学生
    public boolean addUser(User user);

    //删除学生
    public boolean deleteUser(int id);

    //修改学生
    public boolean  updateUserInfo(User user);

    //查询所有学生
    public List<User> getAllUser();

    //根据学号查询学生
    public User getUser(String name, String psd) ;

    //根据条件模糊查询
    public List<User> getUserByCondition(String name);

}
