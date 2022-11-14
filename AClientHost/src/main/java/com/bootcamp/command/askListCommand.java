package com.bootcamp.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.dto.AskDto;
import com.bootcamp.host.dao.HAskDao;

public class askListCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String cId =(String)session.getAttribute("CID");
		HAskDao dao = new HAskDao();
		ArrayList<AskDto> dtos = dao.askList(cId);
		request.setAttribute("list", dtos);

	}

	@Override
	public Boolean execute1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		int ok = Integer.parseInt((String) request.getParameter("aSeq"));
		
		HAskDao dao = new HAskDao();
		
		boolean result = dao.commentCheck(ok);
		
		if(result ==true) {
			request.getParameter("1");
		}else {
			request.getParameter("0");
		}
		
	return null;
	}

}
