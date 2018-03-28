
public class Ch11Member {
	//필드 id
	public String id;
	//지역변수 id
	public Ch11Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ch11Member) {
			Ch11Member Ch11Member = (Ch11Member) obj;
			if(id.equals(Ch11Member.id)) {
				return true;
			}
		}
		return false;
	}
}
