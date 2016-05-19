package day10_servlet_exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import day7_sax.Contact;

/**
 * 联系人关联系统，主控制面板
 * @author L
 * @date 2016年5月18日
 */
public class MainC extends HttpServlet{
	Document document;
	File xml;
	//初始化方法
	@Override
	public void init() throws ServletException {
		xml = new File(this.getServletConfig().getInitParameter("dataXML"));
		document= null;
		try {
			if (!xml.exists()) {
				document = DocumentHelper.createDocument();
				document.addElement("contactList");
				saveXML(xml, document);
			} else {
				document = new SAXReader().read(xml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//存储document对象到指定xml
	private void saveXML(File xml, Document document) throws Exception {
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(xml),format);
		xmlWriter.write(document);
		xmlWriter.close();
		System.out.println("操作成功");
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String str=req.getParameter("gn");
		//根据相应功能转发到不同功能页面
		if("1".equals(str)){
			//到达添加联系人页面
			resp.sendRedirect(this.getServletContext().getContextPath()+"/page/day10/addc.html");
		}else if("2".equals(str)){
			//到达修改联系人页面
//			resp.sendRedirect(this.getServletContext().getContextPath()+"/page/day10/addc.html");
//			toSaveOrUpdate();
//			this.getServletContext().getRequestDispatcher("/page/day10/addc.html").forward(req, resp);
			
		}else if("3".equals(str)){
			//删除联系人
//			resp.sendRedirect(this.getServletContext().getContextPath()+"/page/day10/addc.html");
		}else if("4".equals(str)){
			//查询联系人
			try {
				this.selectC(document,resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String q = req.getParameter("q");
		if("add".equals(q)){
			addC(req, resp);
		}
	}
	
	//添加联系人
	private void addC(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MainC.addC()");
	}
	
	//查询联系人
	private void selectC(Document document, HttpServletResponse resp) throws Exception {
		//显示所有联系人在页面上
		StringBuilder sBuilder=new StringBuilder();
		List<Node> contacts = document.selectNodes("/contactList/contact");
		for(Node c:contacts){
			Contact contact=new Contact();
			Element element=(Element) c;
			contact.setId(element.attributeValue("id"));
			contact.setName(element.element("name").getText());
			contact.setAge(element.element("age").getText());
			contact.setPhone(element.element("phone").getText());
			contact.setEmail(element.element("email").getText());
			contact.setQq(element.element("qq").getText());
			sBuilder.append(contact.toString()+"<br>");
		}
		resp.getWriter().write(sBuilder.toString());
	}
	
	
	
}
