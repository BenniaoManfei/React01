package com.daniel.react.web.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class ReactServlet
 */
public class ReactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count = 1;
	private static List<Map<String,Object>> comments = new ArrayList<Map<String,Object>>();
	
	static{
		int a = count++;
		Map<String, Object> comment = new HashMap<String, Object>();
		comment.put("id", 1);
		comment.put("author", "Pete Hunt"+a);
		comment.put("text", "This is one comment");
		Map<String, Object> comment2 = new HashMap<String, Object>();
		comment2.put("id", 2);
		comment2.put("author", "Jordan Walke"+a);
		comment2.put("text", "This is *another* comment");
		comments.add(comment);
		comments.add(comment2);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");

		String json = JSONObject.toJSONString(comments);

		Writer out =response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = count++;
		response.setCharacterEncoding("UTF-8");
		int id = new Random().nextInt(100);
		String author = request.getParameter("author");
		String text = request.getParameter("text");
		Map<String, Object> comment = new HashMap<String, Object>();
		comment.put("id", id);
		comment.put("author", author+a);
		comment.put("text", text+a);
		comments.add(comment);
		
		String json = JSONObject.toJSONString(comments);
		try {
			Thread.currentThread().sleep(4000);//模拟请求的过程，达到延迟的效果
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Writer out =response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}

}
