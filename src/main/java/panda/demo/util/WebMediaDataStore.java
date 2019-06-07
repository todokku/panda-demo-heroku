package panda.demo.util;

import panda.gems.media.store.MediaDataDaoStore;
import panda.gems.media.store.MediaDataStore;
import panda.ioc.annotation.IocBean;

@IocBean(type=MediaDataStore.class)
public class WebMediaDataStore extends MediaDataDaoStore {
}
