package Chapter02;

public class Greeter {
	
	private String format;
	
	/**
	 * String 문자열 포맷을 이용해서 새로운 문자열을 생성하는 메서도 -> 메시지 생성
	 * @param guest
	 * @return
	 */
	public String greet(String guest) {
		return String.format(format, guest);
	}
	
	/**
	 * greet() 메서드에서 사용할 문자열 포맷 설정하는 메서드
	 * format 필드는 setFormat() 메서드로 설정함
	 * @param format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

}
