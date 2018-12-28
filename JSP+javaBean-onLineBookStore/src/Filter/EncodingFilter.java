package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月27日 下午9:50:15 
* @function:
*/
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月27日 下午9:50:38 
		* @function 避免提交数据的中文乱码问题
		*/ 
		System.out.println("EncodingFilter is called!");
		 request.setCharacterEncoding("utf-8");
		 chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("EncodingFilter is destroied!");;
	}

}
