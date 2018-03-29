package ch16;

import java.util.HashMap;

public class NestedClassEx07 {

	public static void main(String[] args) {
	//연락처 프로그램과 연락처 클래스
		class ContactInfo {
			String address;
			String phoneNo;
			ContactInfo(String address, String phoneNo) {
				this.address = address;
				this.phoneNo = phoneNo;
			}
		}
		HashMap<String, ContactInfo> hashtable = new HashMap<String, ContactInfo>();
		hashtable.put("Lee", new ContactInfo("서울시 강남구", "02-111-1111"));
		hashtable.put("Han", new ContactInfo("서울시 성북구", "02-222-2222"));
		hashtable.put("Park", new ContactInfo("경기도 고양시", "031-333-3333"));
		ContactInfo obj = hashtable.get("Han");
		System.out.println("<Han's phoneNo>");
		System.out.println("address: " + obj.address);
		System.out.println("phoneNo: " + obj.phoneNo);

	}

}
