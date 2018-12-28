package Bean;
/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 上午9:58:17 
* @function:
*/
public class Book {
	private int bookID;
	private String bookName;//书名
	private String author;//作者
	private String publishDate;//出版日期
	private String catagory;//类别
	private double unit;//价格
	private String synopsis;	//简介
	public Book(int bookID, String bookName,String author, String publishDate,String catagory,double unit,String synopsis) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.catagory = catagory;
		this.unit = unit;
		this.synopsis = synopsis;
	}
	public Book(String bookName,String author, String publishDate,String catagory,double unit,String synopsis) {
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.catagory = catagory;
		this.unit = unit;
		this.synopsis = synopsis;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public double getUnit() {
		return unit;
	}
	public void setUnit(double unit) {
		this.unit = unit;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getInventoy() {
		return inventoy;
	}
	public void setInventoy(String inventoy) {
		this.inventoy = inventoy;
	}
	private String inventoy;
}
