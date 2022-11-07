package test;

public class Folder {

    private String folderId;
    private boolean isTagApplied = false;
    private String tagValue;
    
	public String getTagValue() {
		return tagValue;
	}
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	public String getFolderId() {
		return folderId;
	}
	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}
	public boolean isTagApplied() {
		return isTagApplied;
	}
	public void setTagApplied(boolean tagApplied) {
		this.isTagApplied = tagApplied;
	}
}
