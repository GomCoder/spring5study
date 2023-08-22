package spring;

/**
 * 회원가입을 처리할 때 필요한 email, password, name 데이터를 담고 있는 클래스
 * @author devkdwDesktop
 *
 */
public class RegisterRequest {
	
	private String email; //회원 email 
	private String password; //회원 password
	private String confirmPassword; //회원 password 확인
	private String name; //회원 name
	
	/**
	 * 회원 email Getter 메서드
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 회원 email Setter 메서드
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 회원 password Getter 메서드
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 회원 password Setter 메서드
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * 회원 cofirmPassword Getter 메서드
	 * @return
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	/**
	 * 회원 cofirmPassword Setter 메서드
	 * @param cofirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/**
	 * 회원 name Getter 메서드
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 회원 name Setter 메서드
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 확인된 패스워드와 일치하는지 
	 * @return
	 */
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
	

}
