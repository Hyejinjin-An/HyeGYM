package com.hyegym.notice;

import java.text.ParseException;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO extends CommonPagingDTO{
	
	private int idx;
	private int no;
	private String title;
	private String contents;
	private String id;
	private Date createAt;
	private String createAtStr;
	private Date updateAt;
	private String updateAtStr;
	private PaginationDTO paginationDTO;
	

	public int startNum;			// 시작 idx 번호
	public int listPerPage;			// 한 번에 출력할 글 갯수

	public NoticeDTO(int startNum, int listPerPage) {
		this.startNum = (startNum-1) * listPerPage + 1;
		this.listPerPage = listPerPage;
	}
	
	public PaginationDTO getPaginationDTO() {
		return paginationDTO;
	}

	public void setPaginationDTO(PaginationDTO paginationDTO) {
		this.paginationDTO = paginationDTO;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public String getCreateAtStr() {
		return createAtStr;
	}

	public void setCreateAtStr(String createAtStr) {
		this.createAtStr = createAtStr;
	}

	public String getUpdateAtStr() {
		return updateAtStr;
	}

	public void setUpdateAtStr(String updateAtStr) {
		this.updateAtStr = updateAtStr;
	}

	public void setUpdateAt(Date updateAt) throws ParseException {
		this.updateAt = updateAt;
	}
	
    @Override
    public String toString() {
        return "NoticeDTO info : {" +
        		"idx = " + idx + ", " +
                "no = " + no + ", " +
        		"title = " + title + ", " +
                "contents = " + contents + ", " +
                "id = " + id + ", " +
        		"createAt = " + createAt + ", " + 
        		"updateAt = " + updateAt +
                '}';
    }

}
