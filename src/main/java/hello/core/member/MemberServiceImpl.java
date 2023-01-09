package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

//    기획자가 없는 경우
//    private final MemberRepository memberRepository = new MemoryMemberRepository();


//    1) AppConfig.java라는 기획자 섭외
    private final MemberRepository memberRepository;

//    2) 생성자를 통해서 MemberRepository(역할)에 어떤 구현체(배우)가 들어갈지 정할 것임 - memory가 올지 db가 올지
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // test 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
