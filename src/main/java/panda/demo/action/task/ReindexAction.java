package panda.demo.action.task;

import java.util.ArrayList;
import java.util.List;

import panda.app.action.work.SyncWorkAction;
import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.app.index.RevisionedIndexerManager;
import panda.dao.Dao;
import panda.dao.DaoIterator;
import panda.demo.entity.Pet;
import panda.demo.util.PetIndexer;
import panda.idx.IDocument;
import panda.idx.Indexer;
import panda.idx.IndexerManager;
import panda.lang.Exceptions;
import panda.mvc.annotation.At;

@At("/task/reindex")
@Auth({ AUTH.LOCAL, AUTH.TOKEN, AUTH.SUPER })
public class ReindexAction extends SyncWorkAction {
	@Override
	protected void doExecute() {
		final Dao dao = getDaoClient().getDao();
		
		initPetIndex(dao);
	}
	
	protected void initPetIndex(Dao dao) {
		IndexerManager indexes = context.getIoc().get(IndexerManager.class);
		if (!(indexes instanceof RevisionedIndexerManager)) {
			return;
		}
		
		Throwable ex = null;
		RevisionedIndexerManager ridxs = (RevisionedIndexerManager)indexes;
		Indexer idx = ridxs.newIndexer();
		DaoIterator<Pet> it = dao.iterate(Pet.class);
		try {
			List<IDocument> docs = new ArrayList<IDocument>();
			while (it.hasNext()) {
				Pet p = it.next();
				printInfo("Index Pet: " + p.getId() + " / " + p.getName());
				
				IDocument doc = idx.newDocument();
				PetIndexer.document(doc, p);
				docs.add(doc);
				
				if (docs.size() >= 100) {
					idx.inserts(docs);
					docs.clear();
				}
			}
			
			if (!docs.isEmpty()) {
				idx.inserts(docs);
			}
		}
		catch (Throwable e) {
			ex = e;
		}
		finally {
			it.close();
		}

		if (ex != null || getStatus().stop) {
			try {
				idx.drop();
			}
			catch (Throwable e) {
				log.error("Failed to drop index: " + idx, e);
			}
		}
		
		if (ex != null) {
			throw Exceptions.wrapThrow(ex);
		}
		
		if (!getStatus().stop) {
			ridxs.setIndexer(idx);
		}
	}
}
