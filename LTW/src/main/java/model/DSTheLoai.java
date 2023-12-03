package model;

import java.util.ArrayList;

public class DSTheLoai {
	private TheLoai theLoaiChinh;
	private ArrayList<TheLoai> dsTheLoaiPhu;

	public DSTheLoai() {
		super();
		this.theLoaiChinh = null;
		this.dsTheLoaiPhu = new ArrayList<TheLoai>();
	}

	public DSTheLoai(TheLoai theLoaiChinh, ArrayList<TheLoai> dsTheLoaiPhu) {
		super();
		this.theLoaiChinh = theLoaiChinh;
		this.dsTheLoaiPhu = dsTheLoaiPhu;
	}

	public DSTheLoai(TheLoai theLoaiChinh) {
		super();
		this.theLoaiChinh = theLoaiChinh;
		this.dsTheLoaiPhu = new ArrayList<TheLoai>();
	}

	public void addTheLoai(TheLoai tl) {
		this.dsTheLoaiPhu.add(tl);
	}

	public void addTheLoai(ArrayList<TheLoai> dstl) {
		this.dsTheLoaiPhu.addAll(dstl);
	}

	public TheLoai getTheLoaiChinh() {
		return theLoaiChinh;
	}

	public void setTheLoaiChinh(TheLoai theLoaiChinh) {
		this.theLoaiChinh = theLoaiChinh;
	}

	public ArrayList<TheLoai> getDsTheLoaiPhu() {
		return dsTheLoaiPhu;
	}

	public void setDsTheLoaiPhu(ArrayList<TheLoai> dsTheLoaiPhu) {
		this.dsTheLoaiPhu = dsTheLoaiPhu;
	}

	@Override
	public String toString() {
		return "DSTheLoai [theLoaiChinh=" + theLoaiChinh + ", dsTheLoaiPhu=" + dsTheLoaiPhu + "]";
	}

}