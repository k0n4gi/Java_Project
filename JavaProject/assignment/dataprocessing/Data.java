package dataprocessing;

public class Data {
	private int count = 0;
	private String head = "";
	private String txt = "";
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	@Override
	public String toString() {
		return "Data [count=" + count + ", head=" + head + ", txt=" + txt + "]";
	}
}
