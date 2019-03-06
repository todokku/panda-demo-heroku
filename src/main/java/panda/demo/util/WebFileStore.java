package panda.demo.util;

import panda.ioc.annotation.IocBean;
import panda.mvc.vfs.MvcDaoFileStore;
import panda.vfs.FileStore;

@IocBean(type=FileStore.class)
public class WebFileStore extends MvcDaoFileStore {

}
