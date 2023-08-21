package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * 회원 가입 클래스의 객체와 암호 변경 클래스의 객체 조립기
 * @author devkdwDesktop
 *
 */
public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	/**
	 * Assembler 생성자
	 */
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao); //MemberDao 생성자를 통해 객체 의존 주입
		pwdSvc = new ChangePasswordService(); 
		pwdSvc.setMemberDao(memberDao); //setter를 통해 객체 의존 주입
	}
	
	/**
	 * MemberDao에 대한 Getter 메서드
	 * @return
	 */
	public MemberDao getMemberDao() {
		return memberDao;
	}


	/**
	 * MemberRegisterService에 대한 Getter 메서드
	 * @return
	 */
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}


	/**
	 * ChangePasswordService에 대한 Getter 메서드
	 * @return
	 */
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}


	
	
	
	

}
