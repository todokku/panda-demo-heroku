package panda.demo.action.tool;

import panda.app.auth.Auth;
import panda.gems.media.action.MediaBrowseAction;
import panda.mvc.annotation.At;


@At("${media_path}")
@Auth
public class MediaBrowseExAction extends MediaBrowseAction {
}
