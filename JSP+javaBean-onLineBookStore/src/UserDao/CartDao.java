package UserDao;

import java.util.List;

import Bean.Book;
import Bean.Cart;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 上午10:13:56 
* @function:
*/
public interface CartDao {
    //删除书籍
    public boolean deleteBook(int UserID,Book book);
    //修改书籍数量
    public boolean updateBookNumber(Book book,int UserID, int number);
    //查询所有购物车信息
    public List<Cart> getAllBookFromCart(int UserID);
    //根据id计算所有的价格
    public double getAllPrice(int UserID);
    //添加购物车通过ID
    public boolean addCart(Book book,int UserID);
    //清空购物车
    public boolean clearCart(int UserID);
    //查看书籍是否还存在
    public boolean isExist(int UserID,int BookID);
    //得到购物车某本书的数量
    public int getCartNumberByID(int UserID,int BookID);
}
