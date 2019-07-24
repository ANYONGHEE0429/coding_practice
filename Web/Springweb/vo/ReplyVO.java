package com.test.web.vo;

import lombok.Data;

@Data
public class ReplyVO {
	private int replynum;
	private int boardNum;
	private String userid;
	private String replytext;
	private String inputdate;
	private String originalFilename;
	private String savedFilename;
}
