package com.xiao.web.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <p>分页信息。</p>
 * <p>继承ArrayList是因为如果BaseMapper.getPage方法的返回类型是Page，而mybatis有如下判断：</p>
 * <pre>
 * if (List.class.isAssignableFrom(method.getReturnType())) {
 *    returnsList = true;//即只有返回List才执行selectList。
 * }
 * </pre>
 * 
 * @see BaseMapper#getPage(Page, Object)
 * @author dixingxing	
 * @date 2012-7-12
 */
public class Page implements Serializable {
	private static final long serialVersionUID = -1241179900114637258L;
	
	/**每页显示几条*/
	private int size = 10;
	
	/**总条数*/
	private int total = 0; 
	
	/**当前页*/
	private int currentPage = 0; 
	
	/**当前记录起始索引*/
	private int currentResult = 0; 

	/**
	 * 
	 * <p>
	 * 获取总页数
	 * </p>
	 * 
	 * @return
	 */
	public int getTotalPage() {
		if (total % size == 0) {
			return total / size;
		}
		return total / size + 1;
	}

	/**
	 * 
	 * <p>
	 * 获取总条数
	 * </p>
	 * 
	 * @return
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 
	 * <p>
	 * 设置总条数
	 * </p>
	 * 
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		if (currentPage > getTotalPage()) {
			currentPage = getTotalPage();
		}
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		if(currentPage!=null)
			this.currentPage = currentPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(Integer size) {
		if (size==null||size <= 0) {
			size = 10;
		}
		this.size = size;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getSize();
		if (currentResult < 0) {
			currentResult = 0;
		}
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	/**
	 * 封装分页JSP显示内容
	 * @return
	 */
	public String getPageStr(){
		StringBuffer sb=new StringBuffer();
		sb.append("<lable>");
		  sb.append("<script language=\"javascript\">" +
		  		   "function changePageSubmit(path,which){"+
	    		        "page_submits(path,which.value);" +
	    		     "}"+
		  		 "</script>");
		  sb.append("共");
		  sb.append("<font color=\"#FF0000\">"+total+"</font>条记录,每页<font color=\"#FF0000\">"+size+"</font>条记录,共<font color=\"#FF0000\">"+getTotalPage()+"</font>页,当前第<font color=\"#FF0000\">"+currentPage+"</font>页\n");
		    if(currentPage>1){
		    	sb.append("<a style=\"cursor:hand;\" onclick=\"page_submits(1)\">首页</a>\n");
		    }else{
		    	sb.append("<a style=\"cursor:hand;\">首页</a>\n");
		    }
		    if(currentPage>1){
		    	sb.append("<a style=\"cursor:hand;\" onclick=\"page_submits("+(currentPage-1)+")\">上一页</a>\n");
		    }else{
		    	sb.append("<a style=\"cursor:hand;\">上一页</a>\n");
		    }
		    if(currentPage<getTotalPage()){
		    	sb.append("<a style=\"cursor:hand;\" onclick=\"page_submits("+(currentPage+1)+")\">下一页</a>\n");
		    }else{
		    	sb.append("<a style=\"cursor:hand;\">下一页</a>\n");
		    }
		    if(getTotalPage()>currentPage){
		    	sb.append("<a style=\"cursor:hand;\" onclick=\"page_submits("+getTotalPage()+")\">尾页</a>\n");
		    }else{
		    	sb.append("<a style=\"cursor:hand;\">尾页</a>\n");
		    }
		    sb.append("跳转到");
	        sb.append("<input type='text' size=1 value=''>\n");
	        sb.append("<input type='button' value='go'/>\n");
		  sb.append("</lable>");
		return sb.toString();
	}
}