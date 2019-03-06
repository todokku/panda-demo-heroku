package panda.demo.action.entity.petimage;

import panda.dao.Dao;
import panda.demo.action.WebAction;
import panda.demo.constant.S;
import panda.demo.constant.V;
import panda.demo.entity.PetImage;
import panda.demo.entity.query.PetImageQuery;
import panda.io.MimeTypes;
import panda.lang.Strings;
import panda.mvc.annotation.At;
import panda.mvc.annotation.param.Param;
import panda.net.http.HttpStatus;
import panda.servlet.HttpServletResponser;

@At("/petimage")
public class PetImageDownloadAction extends WebAction {
	@At
	public void pimage(@Param("id") Long id, @Param("pid") Long pid) throws Exception {
		int maxage = getSettings().getPropertyAsInt(S.PETIMG_CACHE_MAXAGE, V.PETIMG_CACHE_MAXAGE);

		if (id != null && id > 0) {
			PetImageQuery piq = new PetImageQuery();
			piq.id().eq(id).imageData().exclude();
			
			Dao dao = getDaoClient().getDao();
			PetImage pi = dao.fetch(piq);
			if (pi != null) {
				piq.clear().id().eq(id);
				pi = dao.fetch(piq);
				if (pi.getImageData() != null) {
					writeImage(pi, maxage);
					return;
				}
			}
		}
		else if (pid != null && pid > 0) {
			PetImageQuery piq = new PetImageQuery();
			piq.pid().eq(pid).imageData().exclude();
			
			Dao dao = getDaoClient().getDao();
			PetImage pi = dao.fetch(piq);
			if (pi != null) {
				piq.clear().pid().eq(pid);
				pi = dao.fetch(piq);
				if (pi.getImageData() != null) {
					writeImage(pi, maxage);
					return;
				}
			}
		}

		getResponse().sendError(HttpStatus.SC_NOT_FOUND);
	}

	private void writeImage(PetImage pi, int maxage) throws Exception {
		HttpServletResponser hsrs = new HttpServletResponser(getRequest(), getResponse());
		hsrs.setFileName(Strings.isEmpty(pi.getImageName()) ? ("pet-image-" + pi.getId() + ".jpg") : pi.getImageName());
		hsrs.setContentType(MimeTypes.getMimeType(hsrs.getFileName()));
		hsrs.setContentLength(pi.getImageData().length);
		hsrs.setMaxAge(maxage);
		hsrs.writeHeader();
		hsrs.writeBytes(pi.getImageData());
	}
}

