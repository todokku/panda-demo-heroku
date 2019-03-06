package panda.demo.action;

import panda.app.action.media.MediaBrowseAction;
import panda.app.auth.Auth;
import panda.mvc.annotation.At;


@At("${media_path}")
@Auth
public class MediaBrowseExAction extends MediaBrowseAction {
}
