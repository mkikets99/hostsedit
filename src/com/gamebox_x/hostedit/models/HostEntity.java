package com.gamebox_x.hostedit.models;

public class HostEntity {

	private String ipaddress;
	private String webaddress;
	private Boolean disabled;
	
	
	
	public HostEntity() {
		this.ipaddress = "127.0.0.1";
		this.webaddress = "localhost";
		this.disabled = false;
	}
	public HostEntity(String ipaddress, String webaddress, Boolean disabled) {
		super();
		this.ipaddress = ipaddress;
		this.webaddress = webaddress;
		this.disabled = disabled;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public String getWebaddress() {
		return webaddress;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}
	
	@Override
	public String toString() {
		return ((disabled)? "#\t": " \t" ) + ipaddress + "\t" + webaddress; 
	}
}
