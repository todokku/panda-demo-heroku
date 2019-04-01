package panda.demo.action.entity.user;

import java.util.ArrayList;
import java.util.List;
import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.dao.query.DataQuery;
import panda.demo.action.WebListAction;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.bean.Queryer;
import panda.mvc.bean.QueryerEx;
import panda.mvc.view.Views;
import panda.mvc.view.util.ListColumn;

@At("${!!super_path|||'/super'}/user")
@Auth(AUTH.SUPER)
public class UserListAction extends WebListAction<User> {

	/**
	 * Constructor
	 */
	public UserListAction() {
		setType(User.class);
		addDisplayFields(User.ID, User.NAME, User.EMAIL, User.ROLE, User.STATUS, User.CREATED_AT, User.CREATED_BY, User.CREATED_BY_USER, User.UPDATED_AT, User.UPDATED_BY, User.UPDATED_BY_USER);
	}


	/*----------------------------------------------------------------------*
	 * Joins
	 *----------------------------------------------------------------------*/
	/**
	 * add query joins
	 * @param dq data query
	 */
	@Override
	protected void addQueryJoins(DataQuery<User> dq) {
		super.addQueryJoins(dq);

		UserQuery eq = new UserQuery(dq);
		eq.autoLeftJoinCU();
		eq.autoLeftJoinUU();
	}

	/*----------------------------------------------------------------------*
	 * Actions
	 *----------------------------------------------------------------------*/
	/**
	 * list
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object list(@Param @VisitValidate Queryer qr) {
		return super.list(qr);
	}
	
	/**
	 * list_print
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object list_print(@Param @VisitValidate Queryer qr) {
		return super.list_print(qr);
	}
	
	/**
	 * list_json
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(Views.SJSON)
	public Object list_json(@Param @VisitValidate Queryer qr) {
		return super.list_json(qr);
	}
	
	/**
	 * list_xml
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(Views.SXML)
	public Object list_xml(@Param @VisitValidate Queryer qr) {
		return super.list_xml(qr);
	}
	
	/**
	 * expo_csv
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object expo_csv(@Param @VisitValidate QueryerEx qr) {
		List<ListColumn> columns = new ArrayList<ListColumn>();
		if (displayField("id")) {
			ListColumn lc = new ListColumn();
			lc.name = "id";
			lc.header = getFieldLabel("id");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("name")) {
			ListColumn lc = new ListColumn();
			lc.name = "name";
			lc.header = getFieldLabel("name");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("email")) {
			ListColumn lc = new ListColumn();
			lc.name = "email";
			lc.header = getFieldLabel("email");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("role")) {
			ListColumn lc = new ListColumn();
			lc.name = "role";
			lc.header = getFieldLabel("role");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "code";
			lcf.codemap = consts().getAuthRoleMap();
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("status")) {
			ListColumn lc = new ListColumn();
			lc.name = "status";
			lc.header = getFieldLabel("status");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "code";
			lcf.codemap = consts().getDataStatusMap();
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("createdAt")) {
			ListColumn lc = new ListColumn();
			lc.name = "createdAt";
			lc.header = getFieldLabel("createdAt");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "datetime";
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("createdBy")) {
			ListColumn lc = new ListColumn();
			lc.name = "createdBy";
			lc.header = getFieldLabel("createdBy");
			lc.hidden = true;
			columns.add(lc);
		}
		if (displayField("createdByUser")) {
			ListColumn lc = new ListColumn();
			lc.name = "createdByUser";
			lc.header = getFieldLabel("createdByUser");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("updatedAt")) {
			ListColumn lc = new ListColumn();
			lc.name = "updatedAt";
			lc.header = getFieldLabel("updatedAt");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "datetime";
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("updatedBy")) {
			ListColumn lc = new ListColumn();
			lc.name = "updatedBy";
			lc.header = getFieldLabel("updatedBy");
			lc.hidden = true;
			columns.add(lc);
		}
		if (displayField("updatedByUser")) {
			ListColumn lc = new ListColumn();
			lc.name = "updatedByUser";
			lc.header = getFieldLabel("updatedByUser");
			lc.hidden = false;
			columns.add(lc);
		}
		return super.expo_csv(qr, columns);
	}
	
	/**
	 * expo_xlsx
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object expo_xlsx(@Param @VisitValidate QueryerEx qr) {
		List<ListColumn> columns = new ArrayList<ListColumn>();
		if (displayField("id")) {
			ListColumn lc = new ListColumn();
			lc.name = "id";
			lc.header = getFieldLabel("id");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("name")) {
			ListColumn lc = new ListColumn();
			lc.name = "name";
			lc.header = getFieldLabel("name");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("email")) {
			ListColumn lc = new ListColumn();
			lc.name = "email";
			lc.header = getFieldLabel("email");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("role")) {
			ListColumn lc = new ListColumn();
			lc.name = "role";
			lc.header = getFieldLabel("role");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "code";
			lcf.codemap = consts().getAuthRoleMap();
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("status")) {
			ListColumn lc = new ListColumn();
			lc.name = "status";
			lc.header = getFieldLabel("status");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "code";
			lcf.codemap = consts().getDataStatusMap();
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("createdAt")) {
			ListColumn lc = new ListColumn();
			lc.name = "createdAt";
			lc.header = getFieldLabel("createdAt");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "datetime";
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("createdBy")) {
			ListColumn lc = new ListColumn();
			lc.name = "createdBy";
			lc.header = getFieldLabel("createdBy");
			lc.hidden = true;
			columns.add(lc);
		}
		if (displayField("createdByUser")) {
			ListColumn lc = new ListColumn();
			lc.name = "createdByUser";
			lc.header = getFieldLabel("createdByUser");
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField("updatedAt")) {
			ListColumn lc = new ListColumn();
			lc.name = "updatedAt";
			lc.header = getFieldLabel("updatedAt");
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "datetime";
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField("updatedBy")) {
			ListColumn lc = new ListColumn();
			lc.name = "updatedBy";
			lc.header = getFieldLabel("updatedBy");
			lc.hidden = true;
			columns.add(lc);
		}
		if (displayField("updatedByUser")) {
			ListColumn lc = new ListColumn();
			lc.name = "updatedByUser";
			lc.header = getFieldLabel("updatedByUser");
			lc.hidden = false;
			columns.add(lc);
		}
		return super.expo_xlsx(qr, columns);
	}
	
}

