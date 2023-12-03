package model;

import java.util.ArrayList;
import java.util.List;

public class TheLoai {
	private String name;
	private List<String> values;

	public TheLoai(String name, List<String> values) {
		super();
		this.name = name;
		this.values = values;
	}

	public TheLoai() {
		name="";
		values = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	public String checked(String value) {
		String result="";
		if(values.contains(value)) {
			result="checked=\"checked\"";
		}
		
		return result;
	}
	public String name(String name) {
		String result="";
		if(this.name.equalsIgnoreCase(name)) {
			result="checked=\"checked\"";
		}
		return result;
	}

	@Override
	public String toString() {
		return "TheLoai [name=" + name + ", values=" + values + "]";
	}

	
}
