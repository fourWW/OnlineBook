package Bean;
/** 
* @author four_WW: 
* @version 创建时间：2018年12月6日 上午9:24:27 
* @function:
*/
public class User {
    private int UserID;
    private String name;
    private String password;
    private String phone = null;
    private String email = null;
    private String address = null;
    public User(int UserID,String name, String psd){
    	this.UserID = UserID;
    	this.name = name;
    	this.password = psd;
    }
    public User(String name, String psd){
    	this.name = name;
    	this.password = psd;
    } 
    public User(int UserID,String name, String psd, String phone,String email, String address){
    	this.UserID = UserID;
    	this.name = name;
    	this.password = psd;
    	this.email = email;
    	this.address = address;
    	this.phone = phone;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}

}
