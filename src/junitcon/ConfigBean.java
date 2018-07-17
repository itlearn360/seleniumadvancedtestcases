package junitcon;

import java.util.ArrayList;

public class ConfigBean {
private String url;
private long steptime;
private ArrayList<String> classname;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public ArrayList<String> getClassname() {
	return classname;
}
public void setClassname(ArrayList<String> classname) {
	this.classname = classname;
}
public long getSteptime() {
	return steptime;
}
public void setSteptime(long steptime) {
	this.steptime = steptime;
}


}
