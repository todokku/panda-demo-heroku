package panda.demo.action.sample;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import panda.app.action.base.BaseTaskAction;
import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.lang.Arrays;
import panda.lang.Numbers;
import panda.lang.Strings;
import panda.lang.Threads;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.view.Views;

@Auth(AUTH.ADMIN)
@At("/memtest")
public class MemTestAction extends BaseTaskAction {
	private final List<byte[]> data = new ArrayList<byte[]>(); 
	private final List<Reference<byte[]>> refs = new ArrayList<Reference<byte[]>>(); 

	private static final Map<String, String> types = Arrays.toLinkedMap("Hard", "Hard Memory", "Soft", "Soft Reference", "Weak", "Weak Reference");

	private static final Map<String, String> sizes = Arrays.toLinkedMap("1048576", "1M", "10485760", "10M", "104857600", "100M");
	
	private static final Set<String> rs = Arrays.toSet("Soft", "Weak");

	public Map getMemTypes() {
		return types;
	}

	public Map getMemSizes() {
		return sizes;
	}

	private int getMemSize() {
		int size = 0;
		
		List<Reference<byte[]>> ds = new ArrayList<Reference<byte[]>>();
		
		for (Reference<byte[]> r : refs) {
			if (r.get() == null) {
				ds.add(r);
			}
			else {
				size += r.get().length;
			}
		}
		
		for (Reference<byte[]> r : ds) {
			refs.remove(r);
		}
		
		return size;
	}

	@At("")
	@To(Views.SFTL)
	public void input() {
		getContext().setParams(Arrays.toMap(
			"m", Strings.defaultIfBlank((String)getReqParams().get("m"), "Hard"),
			"s", Strings.defaultIfBlank((String)getReqParams().get("s"), "1048576")));
	}

	@Override
	protected void doExecute() {
		int s = Numbers.toInt((String)getReqParams().get("s"), Numbers.MB * 10);
		String m = (String)getReqParams().get("m");
		
		if (rs.contains(m)) {
			while (!isStop()) {
				Reference<byte[]> r;
				if ("Soft".equals(m)) {
					r = new SoftReference<byte[]>(new byte[s]);
				}
				else {
					r = new WeakReference<byte[]>(new byte[s]);
				}
				refs.add(r);
				
				int size = getMemSize();
				printInfo("Allocate " + m + "Reference memory: " + Numbers.formatSize(size));
				Threads.safeSleep(100);
			}
		}
		else {
			long size = 0;
			while (!isStop()) {
				data.add(new byte[s]);
				size += s;
				
				printInfo("Allocate memory: " + Numbers.formatSize(size));
				Threads.safeSleep(100);
			}
		}
	}
}
