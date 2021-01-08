package vo;

public class ActionForward {
	private boolean isRedirect=false;
	private String path=null;
	
	public ActionForward(String string, boolean b) {
		path = string;
		isRedirect = b;
	}
	
	public ActionForward() {
		
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean b) {
		isRedirect = b;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String string) {
		path = string;
	}
	
}
