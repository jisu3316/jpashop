package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //jpa의 모든 데이터변경이나 로직들은 트랜잭션안에서 실행되어야한다. //readOnly=true jpa가 조회(읽기)전용 성능 최적화
//@AllArgsConstructor //생성자 인젝션을 만들어준다.
@RequiredArgsConstructor //final이 있는 필드생성자를 만들어준다.
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 생성자인젝션
     */
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    /**
     * setterInjection
     */
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }


    /**
     * 회원가입
     */
    @Transactional //defalut 값 readOnly=false 이게 우선권이라 false가 먹힌다.
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    //회원가입조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
