package spring;

import java.time.LocalDateTime;

/**
 * 회원 데이터를 표현하기 위한 크래스
 * @author devkdwDesktop
 *
 */
public class Member {
	private Long id; //회원 id
	private String email; //회원 email
	private String password; //회원 password
	private String name; //회원 name
	private LocalDateTime registerDateTime; //회원 registerDatetime
	
	/**
	 * Member 클래스의 생성자
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param regDateTime
	 */
	public Member(String email, String password, String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}
		
	/**
	 * 회원 id Setter 메소드
	 * @param id
	 */
	void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 회원 id Getter 메서드
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 회원 email Getter 메서드
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 회원 password Getter 메서드
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	
	/**
	 * 회원 name Getter 메서드
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 회원 regDateTime Getter 메서드
	 * @return registerDateTime
	 */
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;	
	}
	
	/**
	 * 암호 변경 기능
	 * oldPasswor가 현재 암호인 password 필드와 값이 다르면 WrongIdPasswordException을 발생시킴
	 * 값이 같으면 password 필드를 newPassword로 변경함
	 * @param oldPassword
	 * @param newPassword
	 */
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		
		this.password = newPassword;
	}
	
}
