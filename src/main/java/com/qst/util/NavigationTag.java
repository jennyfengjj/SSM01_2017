package com.qst.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.qst.po.Customer;

public class NavigationTag extends TagSupport{

	private String bean = "page";
	
	private String url;
	//��ʾҳ������
	private int number = 5;
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter writer = super.pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest)super.pageContext.getRequest();
		
		Page page = (Page)request.getAttribute(bean);
		if(page == null)
			return super.SKIP_BODY;
		
		int pageCount = page.getTotal() / page.getSize();
		if(page.getTotal()%page.getSize()>0)
			pageCount++;
		
		//��ȡ��ҳ�������
		url = resolveUrl(url,pageContext);
		String preUrl = this.urlAppend(url, "page", String.valueOf(page.getPage()-1));
		System.out.println("-------"+preUrl);
		try {
			//��ʾ����һҳ��
			if(page.getPage()>1)
				writer.print("<li><a href=\""+preUrl+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
			else
				writer.print("<li class=\"disabled\"><span aria-hidden=\"true\">&laquo;</span></li>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//��ʾ��ǰҳ���ǰ��ҳ��ͺ���ҳ��
		int indexPage = 1;
		if(page.getPage()-2 <= 0)
			indexPage = 1;
		else if(pageCount-page.getPage() <= 2)
			indexPage = pageCount-4;
		else
			indexPage=page.getPage()-2;
		try {
			for(int i=1;i<=number && indexPage<=pageCount;indexPage++,i++){
				if(indexPage == page.getPage()){
						writer.print("<li class=\"active\"><a href=\"#\">"+indexPage+"</a></li>");
						continue;
				}
				String pageUrl = this.urlAppend(url, "page", String.valueOf(indexPage));
				writer.print("<li><a href=\""+pageUrl+"\">"+indexPage+"</a></li>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//��ʾ����һҳ��
		String nextUrl = this.urlAppend(url, "page", String.valueOf(page.getPage()+1));
		try {
			if(page.getPage()<pageCount)
				writer.print("<li><a href=\""+nextUrl+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
			else
				writer.print("<li class=\"disabled\"><span aria-hidden=\"true\">&raquo;</span></li>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.SKIP_BODY;
	}

	/**
	 * ΪURL��ӷ�ҳ�������
	 * @param url
	 * @param pageContext
	 * @return
	 */
	private String resolveUrl(String url,PageContext pageContext){
		Map params = pageContext.getRequest().getParameterMap();
		for(Object key:params.keySet()){
			if("page".equals(key) || "rows".equals(key))//�˴���������ҳ�����Ӵ����
				continue;
			
			Object value = params.get(key);
			
			System.out.println("kkk:"+value);
			
			if(value == null || "".equals(value)){
				continue;
			}
			if(value.getClass().isArray())
				url = urlAppend(url,key.toString(),((String[])value)[0]);
			else if(value instanceof String){
				System.out.println("---"+value.toString());
				url = urlAppend(url,key.toString(),value.toString());
			}
		}
		return url;
	}
	/**
	 * ΪURL��Ӳ�������ֵ
	 * @param url
	 * @param key
	 * @param value
	 * @return
	 */
	public String urlAppend(String url,String key,String value){
		System.out.println("key:"+key+"value:"+value);
		if(url==null || url.trim().length()==0)
			return "";
		if(url.indexOf("?") == -1)
			url=url+"?"+key+"="+value;
		else{
			if(url.endsWith("?"))
				url=url+key+"="+value;
			else
				url=url+"&amp;"+key+"="+value;
		}
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public String getBean() {
		return bean;
	}

	public String getUrl() {
		return url;
	}

	public int getNumber() {
		return number;
	}
	
	
}
