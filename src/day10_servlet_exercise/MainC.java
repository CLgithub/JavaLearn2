package day10_servlet_exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//输出主页面（有功能列表，联系人列表，点击不同的功能，到达不同的servlet处理）
		List<Contact> contacts = Dao.findAll();
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("<a href='"+req.getContextPath()+"/page/day10/addc.html'>新增</a>"
				+ "<table border='1'>"
				+ "<tr>	 <td colspan='6'>	"
				+ "</td>"
				+ "</tr>"
				+ "<tr>	"
				+ "<th>姓名</th>	 <th>年龄</th> <th>电话</th>	 <th>邮箱</th> <th>qq</th> <th>操作</th>	"
				+ "</tr>");
			//	+ "<tr>	<td>小明</td><td>23</td><td>4324</td><td>邮箱</td><td>qq</td>	<td><a href='#'>修改</a><a href='#'>删除</a></td>	</tr>"
		for(Contact contact:contacts){
			sBuffer.append("<tr>");
			sBuffer.append("<td>"+contact.getName()+"</td>");
			sBuffer.append("<td>"+contact.getAge()+"</td>");
			sBuffer.append("<td>"+contact.getPhone()+"</td>");
			sBuffer.append("<td>"+contact.getEmail()+"</td>");
			sBuffer.append("<td>"+contact.getQq()+"</td>");
			sBuffer.append("<td><a href='"+req.getContextPath()+"/updateC?id="+contact.getId()+"'>修改</a>"
					+ "<a href='"+req.getContextPath()+"/deleteC?id="+contact.getId()+"'>删除</a></td>");
			sBuffer.append("</tr>");
		}
		sBuffer.append( "</table>");
		resp.getWriter().write(sBuffer.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
}
