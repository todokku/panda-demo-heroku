package panda.demo.util;

import panda.app.media.MediaDataDaoStore;
import panda.app.media.MediaDataStore;
import panda.ioc.annotation.IocBean;

@IocBean(type=MediaDataStore.class)
public class WebMediaDataStore extends MediaDataDaoStore {
}
