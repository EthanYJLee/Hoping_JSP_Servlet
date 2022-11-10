package com.bootcamp.host.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.dto.MyregcampDto;
import com.bootcamp.host.dao.HostRegMDao;

public class HostInfoMRMSelectCommand implements BCCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HostRegMDao dao = new HostRegMDao();
		
		MyregcampDto dto = dao.selectInfoRoughMap(1);
		
		request.setAttribute("roughMap", dto);
		
	}

}
