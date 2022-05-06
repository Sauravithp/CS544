package com.example.exercise16_2;

import com.example.exercise16_2.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	private SessionFactory sf;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		Transaction tx=null;
		try{
			tx=sf.getCurrentSession().beginTransaction();
			chain.doFilter(request,response);
			tx.commit();
		}catch (RuntimeException e){
			try{
				e.printStackTrace();
				tx.rollback();
			}catch (RuntimeException e1){
				System.out.println("Couldnt rollback transaction"+e1);
				e1.printStackTrace();
			}
			throw e;
		}
		// pass the request along the filter chain
		System.out.println("receiving request");
		chain.doFilter(request, response);
		System.out.println("sending response");
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
		sf = HibernateUtils.getSessionFactory();
	}
}
