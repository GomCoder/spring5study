package spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 암호 변경 관련 기능 서비스 클래스
 * @author devkdwDesktop
 *
 */
public class ChangePasswordService {
	
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member =  memberDao.selectByEmail(email);
		
		//email에 해당하는 회원이 존재하지 않으면 Exception을 발생시킴
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		//email에 해당하는 회원이 존재하면 암호를 변경하고 변경된 데이터를 저장함
		member.changePassword(oldPwd, newPwd);		
		memberDao.update(member);
	}
	
	/**
	 * setMemberDao() 매서드로 의존하는 MemberDao를 전달 받음
	 * @param memberDao
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
