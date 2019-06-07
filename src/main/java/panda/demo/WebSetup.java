package panda.demo;


import panda.app.AppHelper;
import panda.app.AppIocProvider;
import panda.app.AppSetup;
import panda.app.constant.AUTH;
import panda.app.constant.VAL;
import panda.app.entity.ICreatedBy;
import panda.app.entity.IUpdatedBy;
import panda.dao.Dao;
import panda.dao.DaoClient;
import panda.dao.entity.EntityDao;
import panda.demo.auth.WebAuthenticator;
import panda.demo.constant.S;
import panda.demo.constant.V;
import panda.demo.entity.Pet;
import panda.demo.entity.PetCategory;
import panda.demo.entity.PetImage;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.gems.media.entity.Media;
import panda.gems.media.entity.MediaData;
import panda.idx.Indexes;
import panda.io.Settings;
import panda.ioc.annotation.IocBean;
import panda.ioc.annotation.IocInject;
import panda.lang.Randoms;
import panda.lang.Strings;
import panda.lang.time.DateTimes;
import panda.log.Log;
import panda.log.Logs;
import panda.mvc.Setup;
import panda.mvc.annotation.IocBy;
import panda.mvc.annotation.Modules;
import panda.vfs.dao.DaoFileData;
import panda.vfs.dao.DaoFileItem;

@Modules(scan = true, packages = { "panda.app.action", "panda.gems" })
@IocBy(type = AppIocProvider.class, args = { "*default", "*json", "mvc.json" })
@IocBean(type = Setup.class)
public class WebSetup extends AppSetup {
	private static final Log log = Logs.getLog(WebSetup.class);

	@IocInject
	private DaoClient daoClient;
	
	@IocInject
	private Settings settings;
	
	@IocInject
	private Indexes indexes;
	
	public static final Class[] ENTITIES = {
			DaoFileItem.class,
			DaoFileData.class,
			Media.class,
			MediaData.class,
			User.class,
			PetCategory.class,
			Pet.class,
			PetImage.class
	};
	
	/**
	 * initialize
	 */
	@Override
	public void initialize() {
		super.initialize();
		
		initEntities();
		
		initDatabase();
		
		initSystemUser();
		initSuperUser();
	}

	@SuppressWarnings("unchecked")
	private void initEntities() {
		//initialize entities
		for (Class c : ENTITIES) {
			daoClient.getEntity(c);
		}
	}

	private void initDatabase() {
		try {
			log.info("Initialize database");

			Dao dao = daoClient.getDao();
			AppHelper.createTables(dao, ENTITIES);
		}
		catch (Exception e) {
			log.error("Failed to init database", e);
		}
	}

	private void initSystemUser() {
		try {
			EntityDao<User> udao = daoClient.getEntityDao(User.class);
			if (udao.fetch(V.SYSTEM_UID) != null) {
				return;
			}
			
			User u = new User();
			u.setId(V.SYSTEM_UID);
			u.setEmail("SYSTEM");
			u.setName("SYSTEM");
			u.setPassword(WebAuthenticator.hashPassword(Randoms.randString(10)));
			u.setRole(AUTH.NONE);
			u.setStatus(VAL.STATUS_DISABLED);
			if (u instanceof ICreatedBy) {
				ICreatedBy c = (ICreatedBy)u;
				c.setCreatedBy(V.SYSTEM_UID);
				c.setCreatedAt(DateTimes.getDate());
			}
			if (u instanceof IUpdatedBy) {
				IUpdatedBy c = (IUpdatedBy)u;
				c.setUpdatedBy(V.SYSTEM_UID);
				c.setUpdatedAt(DateTimes.getDate());
			}
			
			log.info("Create default system user");
			udao.insert(u);
		}
		catch (Exception e) {
			log.error("Failed to init system user", e);
		}
	}

	private void initSuperUser() {
		try {
			if (Strings.isEmpty(settings.getProperty(S.SUPER_EMAIL))) {
				return;
			}
			
			EntityDao<User> udao = daoClient.getEntityDao(User.class);
			UserQuery uq = new UserQuery();
			uq.role().eq(AUTH.SUPER).limit(1);
			if (udao.fetch(uq) != null) {
				return;
			}
			
			User u = new User();
			u.setEmail(settings.getProperty(S.SUPER_EMAIL));
			u.setName(settings.getProperty(S.SUPER_USERNAME, "SUPER"));
			u.setPassword(WebAuthenticator.hashPassword(settings.getProperty(S.SUPER_PASSWORD, "trustme")));
			u.setRole(AUTH.SUPER);
			u.setStatus(VAL.STATUS_ACTIVE);
			if (u instanceof ICreatedBy) {
				ICreatedBy c = (ICreatedBy)u;
				c.setCreatedBy(V.SYSTEM_UID);
				c.setCreatedAt(DateTimes.getDate());
			}
			if (u instanceof IUpdatedBy) {
				IUpdatedBy c = (IUpdatedBy)u;
				c.setUpdatedBy(V.SYSTEM_UID);
				c.setUpdatedAt(DateTimes.getDate());
			}
			
			log.info("Create default super user: " + u.getEmail() + "/" + u.getPassword());
			udao.insert(u);
		}
		catch (Exception e) {
			log.error("Failed to init super user", e);
		}
	}

	/**
	 * destroy
	 */
	@Override
	public void destroy() {
		super.destroy();
	}
}
