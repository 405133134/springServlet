/*******************************************************************************
 数据库持久化层(For MySQL5.1 Java)
 创建日期  Tue Oct 25 14:16:01 CST 2016
 创建程序 Program 版本(3.0)
 程序设计 张建设 EMAIL:zhangjianshe@gmail.com PHONE:15910868680

<pre>

           =============================================================
           -   ____ _  _ ____ _  _ ____  _ _ ____ _  _ ____ _  _ ____  -
           -    __] |__| |__| |\ | | __  | | |__| |\ | [__  |__| |___  -
           -   [___ |  | |  | | \| |__| _| | |  | | \| ___] |  | |___  -
           -           http://hi.baidu.com/zhangjianshe                -
           =============================================================

</pre>
/******************************************************************************/
package cn.enn.springServlet;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
/**
 * 数据库表 <br/>
 * @author database2java@polatu.cn

 * <b>字段列表</b><br/>

 * ID   顾客ID Long<br/>
 * NAME   顾客名称 String<br/>
 * PWD   登录密码 String<br/>
 * EMAIL   电子邮件 String<br/>
 * MOBILE   手机号码 String<br/>
 * GENDER   性别 Integer<br/>
 * CITY   所在城市 String<br/>
 * REG_TIME   注册时间 java.sql.Timestamp<br/>
 * SUMMARY   介绍 String<br/>
 * AVATOR   头像路径 String<br/>
 * TOKEN   登录标识 String<br/>
 * LAST_TIME   最后登录时间 java.sql.Timestamp<br/>
 * LAST_IP   最后登录IP String<br/>
 * ACCOUNT_ID   财经账户 Long<br/>
 */
@Table("NE_CUSTOM")

public class NE_CUSTOMObj implements java.io.Serializable{
public NE_CUSTOMObj(){}
	 public final static String FLD_ID="ID";
	@Id
	private Long ID;

	/**
	 * @return ID  顾客ID  bigint
	 */
	public Long getID(){
		return ID;
		}

	/**
	 * @param ID  顾客ID  bigint
	 */
	public void setID(Long ID){
		this.ID=ID;
		}

	 public final static String FLD_NAME="NAME";
	private String NAME;

	/**
	 * @return NAME  顾客名称  varchar
	 */
	public String getNAME(){
		return NAME;
		}

	/**
	 * @param NAME  顾客名称  varchar
	 */
	public void setNAME(String NAME){
		this.NAME=NAME;
		}

	 public final static String FLD_PWD="PWD";
	private String PWD;

	/**
	 * @return PWD  登录密码  varchar
	 */
	public String getPWD(){
		return PWD;
		}

	/**
	 * @param PWD  登录密码  varchar
	 */
	public void setPWD(String PWD){
		this.PWD=PWD;
		}

	 public final static String FLD_EMAIL="EMAIL";
	private String EMAIL;

	/**
	 * @return EMAIL  电子邮件  varchar
	 */
	public String getEMAIL(){
		return EMAIL;
		}

	/**
	 * @param EMAIL  电子邮件  varchar
	 */
	public void setEMAIL(String EMAIL){
		this.EMAIL=EMAIL;
		}

	 public final static String FLD_MOBILE="MOBILE";
	private String MOBILE;

	/**
	 * @return MOBILE  手机号码  varchar
	 */
	public String getMOBILE(){
		return MOBILE;
		}

	/**
	 * @param MOBILE  手机号码  varchar
	 */
	public void setMOBILE(String MOBILE){
		this.MOBILE=MOBILE;
		}

	 public final static String FLD_GENDER="GENDER";
	private Integer GENDER;

	/**
	 * @return GENDER  性别  int
	 */
	public Integer getGENDER(){
		return GENDER;
		}

	/**
	 * @param GENDER  性别  int
	 */
	public void setGENDER(Integer GENDER){
		this.GENDER=GENDER;
		}

	 public final static String FLD_CITY="CITY";
	private String CITY;

	/**
	 * @return CITY  所在城市  varchar
	 */
	public String getCITY(){
		return CITY;
		}

	/**
	 * @param CITY  所在城市  varchar
	 */
	public void setCITY(String CITY){
		this.CITY=CITY;
		}

	 public final static String FLD_REG_TIME="REG_TIME";
	private java.sql.Timestamp REG_TIME;

	/**
	 * @return REG_TIME  注册时间  timestamp
	 */
	public java.sql.Timestamp getREG_TIME(){
		return REG_TIME;
		}

	/**
	 * @param REG_TIME  注册时间  timestamp
	 */
	public void setREG_TIME(java.sql.Timestamp REG_TIME){
		this.REG_TIME=REG_TIME;
		}

	 public final static String FLD_SUMMARY="SUMMARY";
	private String SUMMARY;

	/**
	 * @return SUMMARY  介绍  varchar
	 */
	public String getSUMMARY(){
		return SUMMARY;
		}

	/**
	 * @param SUMMARY  介绍  varchar
	 */
	public void setSUMMARY(String SUMMARY){
		this.SUMMARY=SUMMARY;
		}

	 public final static String FLD_AVATOR="AVATOR";
	private String AVATOR;

	/**
	 * @return AVATOR  头像路径  varchar
	 */
	public String getAVATOR(){
		return AVATOR;
		}

	/**
	 * @param AVATOR  头像路径  varchar
	 */
	public void setAVATOR(String AVATOR){
		this.AVATOR=AVATOR;
		}

	 public final static String FLD_TOKEN="TOKEN";
	private String TOKEN;

	/**
	 * @return TOKEN  登录标识  varchar
	 */
	public String getTOKEN(){
		return TOKEN;
		}

	/**
	 * @param TOKEN  登录标识  varchar
	 */
	public void setTOKEN(String TOKEN){
		this.TOKEN=TOKEN;
		}

	 public final static String FLD_LAST_TIME="LAST_TIME";
	private java.sql.Timestamp LAST_TIME;

	/**
	 * @return LAST_TIME  最后登录时间  timestamp
	 */
	public java.sql.Timestamp getLAST_TIME(){
		return LAST_TIME;
		}

	/**
	 * @param LAST_TIME  最后登录时间  timestamp
	 */
	public void setLAST_TIME(java.sql.Timestamp LAST_TIME){
		this.LAST_TIME=LAST_TIME;
		}

	 public final static String FLD_LAST_IP="LAST_IP";
	private String LAST_IP;

	/**
	 * @return LAST_IP  最后登录IP  varchar
	 */
	public String getLAST_IP(){
		return LAST_IP;
		}

	/**
	 * @param LAST_IP  最后登录IP  varchar
	 */
	public void setLAST_IP(String LAST_IP){
		this.LAST_IP=LAST_IP;
		}

	 public final static String FLD_ACCOUNT_ID="ACCOUNT_ID";
	private Long ACCOUNT_ID;

	/**
	 * @return ACCOUNT_ID  财经账户  bigint
	 */
	public Long getACCOUNT_ID(){
		return ACCOUNT_ID;
		}

	/**
	 * @param ACCOUNT_ID  财经账户  bigint
	 */
	public void setACCOUNT_ID(Long ACCOUNT_ID){
		this.ACCOUNT_ID=ACCOUNT_ID;
		}

}
