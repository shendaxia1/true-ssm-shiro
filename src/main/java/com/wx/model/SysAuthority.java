package com.wx.model;


public class SysAuthority {
	private String data_url;//����·���򷽷�
	private String menu_class;//�˵���ʽ
	private String menu_code;//�˵�����
	private String parent_menucode;//�ϼ��˵�����
	private Long sequence;//����
	private String menu_type;//�˵����ͣ�1�ǲ˵��󵼺���2�ǰ�ťȨ�ޣ�3���ı���
	private String create_time;//����ʱ��
	private int menu_state;//�˵�״̬
	public String getData_url() {
		return data_url;
	}
	public void setData_url(String data_url) {
		this.data_url = data_url;
	}
	public String getMenu_class() {
		return menu_class;
	}
	public void setMenu_class(String menu_class) {
		this.menu_class = menu_class;
	}
	public String getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	public String getParent_menucode() {
		return parent_menucode;
	}
	public void setParent_menucode(String parent_menucode) {
		this.parent_menucode = parent_menucode;
	}

	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	public String getMenu_type() {
		return menu_type;
	}
	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getMenu_state() {
		return menu_state;
	}
	public void setMenu_state(int menu_state) {
		this.menu_state = menu_state;
	}
	

}
