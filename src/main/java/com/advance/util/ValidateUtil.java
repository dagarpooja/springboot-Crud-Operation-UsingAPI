package com.advance.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	public static final String nameReg = "^[a-zA-Z]{2,}$";
	public static final String name_msg = "will except a name with at least two characters";
	public static final String name_fieldName = "name";
	

	public static final String phoneReg = "^\\d{10}$";
	public static final String phone_msg = "invalid phone number entered";
	public static final String phone_fieldName = "phone";

	public static final String passwordReg = "^\\d{10}$";
	public static final String password_msg = "The password should be 10 digits";
	public static final String password_fieldName = "password";
	
	

	public static class MyValidData {
		private String text;
		private String reg;
		private String msg;
		private boolean isValid;
		private String fieldName;

		

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public MyValidData(String text, String reg, String msg ,String fieldName) {
			this.text = text;
			this.reg = reg;
			this.msg = msg;
			this.fieldName = fieldName;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getRegMsg() {
			return reg;
		}

		public void setRegMsg(String regMsg) {
			this.reg = regMsg;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public boolean isValid() {
			return isValid;
		}

		public void setValid(boolean isValid) {
			this.isValid = isValid;
		}

		public static boolean isValidName(String names) {
			Pattern p = Pattern.compile(nameReg);
			Matcher m = p.matcher(names);
			return m.matches();
		}

		public static boolean isValidPhone(String phones) {
			Pattern p = Pattern.compile(phoneReg);
			Matcher m = p.matcher(phones);
			return m.matches();

		}

		public static boolean isValidPassword(String passwd) {
			Pattern p = Pattern.compile(passwordReg);
			Matcher m = p.matcher(passwd);
			return m.matches();

		}
	}

	public static class DataValidate {
		private boolean isValid;

		private List<String> errors = new ArrayList<>();
		
		private Map<String,Object> mapErrors = new HashMap<String, Object>();

		public boolean isValid() {
			return isValid;
		}

		public void setValid(boolean isValid) {
			this.isValid = isValid;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}

		public Map<String, Object> getMapErrors() {
			return mapErrors;
		}

		public void setMapErrors(Map<String, Object> mapErrors) {
			this.mapErrors = mapErrors;
		}
		
		
	}

		public static DataValidate validate(List<MyValidData> list) {
			DataValidate listValidate = new DataValidate();

			listValidate.isValid = true;

			if (list == null) {
				listValidate.isValid = false;
				return listValidate;
			}
			
			
			for (MyValidData myValid : list) {
				
				
				if (myValid.fieldName.equals("name")) {
					if (!MyValidData.isValidName(myValid.text)) {
						listValidate.mapErrors.put(myValid.fieldName,myValid.msg);
						listValidate.isValid = false;
						}
					}
				if (myValid.fieldName.equals("phone")) {
					if (!MyValidData.isValidPhone(myValid.text)) {
						listValidate.mapErrors.put(myValid.fieldName,myValid.msg);
						listValidate.isValid = false;
						}
					}
				if (myValid.fieldName.equals("password")) {
					if (!MyValidData.isValidPassword(myValid.text)) {
						listValidate.mapErrors.put(myValid.fieldName,myValid.msg);
						listValidate.isValid = false;
						}
					}
//				if (!myValid.isValid) {
//					listValidate.errors.add(myValid.msg);
//					listValidate.mapErrors.put(myValid.fieldName,myValid.msg);
//					listValidate.isValid = false;
//				}
			}

			return listValidate;

		}
	}

