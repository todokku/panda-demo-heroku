package panda.demo.action.pet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import panda.app.action.BaseAction;
import panda.app.bean.IndexArg;
import panda.demo.entity.Pet;
import panda.demo.util.PetIndexer;
import panda.idx.IDocument;
import panda.idx.IQuery;
import panda.idx.IResult;
import panda.idx.Indexer;
import panda.idx.Indexes;
import panda.lang.Strings;
import panda.lang.time.DateTimes;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.param.PathArg;
import panda.mvc.view.Views;
import panda.net.URLBuilder;
import panda.net.URLHelper;


@At
@To(Views.SFTL)
public class PetSearchAction extends BaseAction {
	public static class Arg extends IndexArg {
		public Date ds;
		public Date de;
	}
	
	@At("/petquery")
	@To(Views.REDIRECT)
	public String query(@Param Arg arg) throws Exception {
		URLBuilder ub = new URLBuilder();
		
		String url = "/petsearch/";
		if (Strings.isNotEmpty(arg.getKey())) {
			url += URLHelper.encodeURL(arg.getKey());
		}
		ub.setPath(url);

		Map<String, String> ps = new HashMap<String, String>();
		if (arg.ds != null) {
			ps.put("ds", DateTimes.isoDateFormat().format(arg.ds));
		}
		if (arg.de != null) {
			ps.put("de", DateTimes.isoDateFormat().format(arg.ds));
		}
		ub.setParams(ps);
		
		return ub.build();
	}

	@At("/petsearch/(.*)$")
	public Object search(@PathArg String key, @Param Arg arg) throws Exception {
		key = Strings.stripToEmpty(key);
		if (Strings.isEmpty(key)) {
			return null;
		}

		arg.setKey(key);
		assist().loadLimitParams(arg.getPager());

		Indexes indexes = context.getIoc().get(Indexes.class);
		Indexer indexer = indexes.getIndexer();
		IQuery query = indexer.newQuery();

		query.start(arg.getPager().getStart()).limit(arg.getPager().getLimit());
		query.field(Pet.NAME).eq().value(key);
		if (arg.ds != null) {
			query.and().field(Pet.BIRTHDAY).ge().value(arg.ds);
		}
		if (arg.de != null) {
			Date de = DateTimes.addDays(arg.de, 1);
			query.and().field(Pet.BIRTHDAY).lt().value(de);
		}
		query.sort(Pet.BIRTHDAY, IQuery.SortType.DATE, false);

		IResult ir = indexer.search(query);

		List<Pet> list = new ArrayList<Pet>();
		arg.getPager().setTotal(ir.getTotalHits());
		arg.getPager().normalize();
		if (arg.getPager().getTotal() > 0) {
			for (IDocument doc : ir.getDocuments()) {
				Pet pet = PetIndexer.doc2Pet(doc);
				list.add(pet);
			}
		}
		
		assist().saveLimitParams(arg.getPager());

		return list;
	}
}
