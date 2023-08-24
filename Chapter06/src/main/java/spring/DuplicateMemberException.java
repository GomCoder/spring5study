package spring;

/**
 * 동일한 email을 갖고 있는 회원이 이미 존재 할 때 MemberRegisterService가 발생시키는 Exception 타입
 * @author devkdwDesktop
 *
 */
public class DuplicateMemberException extends RuntimeException {

	/**
	 * DuplicateMemberException 생성자, message를 발생시킴
	 * @param message
	 */
	public DuplicateMemberException(String message) {
		super(message);
	}

}
