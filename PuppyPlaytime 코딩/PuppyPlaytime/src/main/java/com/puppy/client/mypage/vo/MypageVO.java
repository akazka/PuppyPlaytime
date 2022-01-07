package com.puppy.client.mypage.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;



public class MypageVO {
	
	private int page;
	private int sizePerPage;
	private String m_id;
	
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public MypageVO() {
		this.page = 1;
		this.sizePerPage = 10;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public void setSizePerPage(int size) {
		if(size <= 0 || size > 100) {
			this.sizePerPage =10;
			return;
		}
		this.sizePerPage = size;
	}
	public int getPage() {
		return page;
	}
	//마이바티스 SQL 매퍼를 위한 메서드
	public int getPageStart() {
		return (this.page - 1) * sizePerPage;
	}
	//마이바티스 SQL 매퍼를 위한 메서드
	public int getSizePerPage() {
		return this.sizePerPage;
	}
	
	//멤버 변수를 활용하여 다양한 형태의 쿼리파라미터를 생성한다.
	public String toUriString() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", this.page)
				.queryParam("size", this.sizePerPage)
				.build();
		return uriComponents.toUriString();
	}	
	
	public String toUriString(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("size",this.sizePerPage)
				.build();
				
		return uriComponents.toUriString();
		
	}
	
	
}
