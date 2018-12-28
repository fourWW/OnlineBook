package Bean;
/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 下午10:40:11 
* @function:
*/
public class Cart {
	private int CartID;
	private int UserID;
	private int BookID;
	private String bookName;
	private double price;//价格
	private int quantity;//数量
	public Cart(int CartID,int UserID, int BookID,String bookName,double price, int quantity) {
		this.CartID = CartID;
		this.BookID = BookID;
		this.UserID = UserID;
		this.bookName = bookName;
		this.price = price;
		this.quantity= quantity;
	}

	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCartID() {
		return CartID;
	}
	public void setCartID(int cartID) {
		CartID = cartID;
	}
}
