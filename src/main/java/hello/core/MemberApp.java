package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        기획자 없을때 DIP OCP 무시한 code
//        MemberService memberService = new/ MemberServiceImpl(memberRepository);

//        기획자 실행법
//        AppConfig appConfig = new AppConfig(); // 1) 생성
//        MemberService memberService = appConfig.memberService(); // 2) 필요 주입 method 호출


//      spring 기획자 실행법
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
