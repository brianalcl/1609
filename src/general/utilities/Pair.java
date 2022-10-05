package general.utilities;

public class Pair<R, C> {
	private R r;
	private C c;
	
	public Pair() {
		r = null;
		c = null;
	}
	
	public Pair(R f, C c) {
		this.r = f;
		this.c = c;
	}
	
	public void setRyC(R f, C c) {
		this.r = f;
		this.c = c;
	}
	
	public void setR(R f) {
		this.r = f;
	}
	
	public void setC(C c) {
		this.c = c;
	}
	
	public R getR() {
		return r;
	}
	
	public C getC() {
		return c;
	}
}
