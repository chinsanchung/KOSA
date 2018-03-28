
public class TestGetterSetter {
	private String grade;
	private String name;
	private int kor;
	
	//getter setter메소드. 다른 데에서도 접근가능하게 public
	public String getgrade() {
		return grade;
	}
	public void  setgrade(String grade) {
		this.grade = grade;
	}
	public String getname() {
		return name;
	}
	public void  setname(String name) {
		this.name = name;
	}
	public int kor() {
		return kor;
	}
	public void  setkor(int kor) {
		this.kor = kor;
	}
}
