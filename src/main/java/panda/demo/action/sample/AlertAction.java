package panda.demo.action.sample;

import panda.demo.action.WebAction;
import panda.lang.Strings;
import panda.mvc.ValidateException;
import panda.mvc.annotation.At;
import panda.mvc.annotation.Redirect;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;

@At("/")
@To(value=Views.SFTL, error=Views.SFTL)
public class AlertAction extends WebAction {
	public static class Arg {
		private String strError;
		private String strWarn;
		private String strInfo;
		private String strConf;
		private String strExcep;
		private String strField;
		private String strCheck;
	
		/**
		 * @return the strError
		 */
		public String getStrError() {
			return strError;
		}
	
		/**
		 * @param strError the strError to set
		 */
		public void setStrError(String strError) {
			this.strError = strError;
		}
	
		/**
		 * @return the strWarn
		 */
		public String getStrWarn() {
			return strWarn;
		}
	
		/**
		 * @param strWarn the strWarn to set
		 */
		public void setStrWarn(String strWarn) {
			this.strWarn = strWarn;
		}
	
		/**
		 * @return the strInfo
		 */
		public String getStrInfo() {
			return strInfo;
		}
	
		/**
		 * @param strInfo the strInfo to set
		 */
		public void setStrInfo(String strInfo) {
			this.strInfo = strInfo;
		}
	
		/**
		 * @return the strConf
		 */
		public String getStrConf() {
			return strConf;
		}
	
		/**
		 * @param strConf the strConf to set
		 */
		public void setStrConf(String strConf) {
			this.strConf = strConf;
		}
	
		/**
		 * @return the strExcep
		 */
		public String getStrExcep() {
			return strExcep;
		}
	
		/**
		 * @param strExcep the strExcep to set
		 */
		public void setStrExcep(String strExcep) {
			this.strExcep = strExcep;
		}
	
		/**
		 * @return the strField
		 */
		public String getStrField() {
			return strField;
		}
	
		/**
		 * @param strField the strField to set
		 */
		public void setStrField(String strField) {
			this.strField = strField;
		}

		/**
		 * @return the strCheck
		 */
		public String getStrCheck() {
			return strCheck;
		}

		/**
		 * @param strCheck the strCheck to set
		 */
		public void setStrCheck(String strCheck) {
			this.strCheck = strCheck;
		}
		
	}

	@Redirect(toslash=true)
	public Object input() {
		return null;
	}

	@At
	public void alert(@Param Arg arg) throws Exception {
		if (Strings.isNotEmpty(arg.strError)) {
			addActionError(arg.strError);
		}
		if (Strings.isNotEmpty(arg.strWarn)) {
			addActionWarning(arg.strWarn);
		}
		if (Strings.isNotEmpty(arg.strConf)) {
			addActionConfirm(arg.strConf);
		}
		if (Strings.isNotEmpty(arg.strInfo)) {
			addActionMessage(arg.strInfo);
		}
		if (Strings.isNotEmpty(arg.strField)) {
			addFieldError("strField", arg.strField);
		}
		if (Strings.isNotEmpty(arg.strCheck)) {
			addActionError(arg.strCheck);
			throw new ValidateException(arg.strCheck);
		}
		if (Strings.isNotBlank(arg.strExcep)) {
			throw new Exception(arg.strExcep);
		}
	}
}
