package com.wx.util;

import java.io.Serializable;
/**
 * ���ؽ��
 * @author shenyanchun
 *
 */
public class Result implements Serializable {

		private static final long serialVersionUID = 2267751680865696851L;
		/**�Ƿ�ɹ�**/
		private Boolean success = false ;
		/**������Ϣ**/
		private String message;
		/**��������**/
		private Object data;
		
		
		
		public Boolean getSuccess() {
			return success;
		}
		public void setSuccess(Boolean success) {
			this.success = success;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
}



