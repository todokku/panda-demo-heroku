package panda.demo.action.entity.petcategory;

import java.util.ArrayList;
import java.util.List;
import panda.demo.action.WebListAction;
import panda.demo.entity.PetCategory;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.bean.Queryer;
import panda.mvc.bean.QueryerEx;
import panda.mvc.view.Views;
import panda.mvc.view.util.ListColumn;

@At("/petcategory")
public class PetCategoryListAction extends WebListAction<PetCategory> {

	/**
	 * Constructor
	 */
	public PetCategoryListAction() {
		setType(PetCategory.class);
		setDisplayFields(PetCategory.ID, PetCategory.NAME, PetCategory.STATUS, PetCategory.UPDATED_AT, PetCategory.UPDATED_BY);
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
	 * list_pdf
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object list_pdf(@Param @VisitValidate Queryer qr) {
		return super.list_pdf(qr);
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
		if (displayField(PetCategory.ID)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.ID;
			lc.header = getFieldLabel(PetCategory.ID);
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField(PetCategory.NAME)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.NAME;
			lc.header = getFieldLabel(PetCategory.NAME);
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField(PetCategory.STATUS)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.STATUS;
			lc.header = getFieldLabel(PetCategory.STATUS);
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "code";
			lcf.codemap = consts().get("dataStatusMap");
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField(PetCategory.UPDATED_AT)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.UPDATED_AT;
			lc.header = getFieldLabel(PetCategory.UPDATED_AT);
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "datetime";
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField(PetCategory.UPDATED_BY)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.UPDATED_BY;
			lc.header = getFieldLabel(PetCategory.UPDATED_BY);
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "expr";
			lcf.expr = "top.updatedByUser";
			lc.format = lcf;
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
		if (displayField(PetCategory.ID)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.ID;
			lc.header = getFieldLabel(PetCategory.ID);
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField(PetCategory.NAME)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.NAME;
			lc.header = getFieldLabel(PetCategory.NAME);
			lc.hidden = false;
			columns.add(lc);
		}
		if (displayField(PetCategory.STATUS)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.STATUS;
			lc.header = getFieldLabel(PetCategory.STATUS);
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "code";
			lcf.codemap = consts().get("dataStatusMap");
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField(PetCategory.UPDATED_AT)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.UPDATED_AT;
			lc.header = getFieldLabel(PetCategory.UPDATED_AT);
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "datetime";
			lc.format = lcf;
			columns.add(lc);
		}
		if (displayField(PetCategory.UPDATED_BY)) {
			ListColumn lc = new ListColumn();
			lc.name = PetCategory.UPDATED_BY;
			lc.header = getFieldLabel(PetCategory.UPDATED_BY);
			lc.hidden = false;
			ListColumn.Format lcf = new ListColumn.Format();
			lcf.type = "expr";
			lcf.expr = "top.updatedByUser";
			lc.format = lcf;
			columns.add(lc);
		}
		return super.expo_xlsx(qr, columns);
	}
	
}

