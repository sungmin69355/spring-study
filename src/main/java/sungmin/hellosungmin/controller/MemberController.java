package sungmin.hellosungmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sungmin.hellosungmin.domain.Member;
import sungmin.hellosungmin.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    //: @Autowired 를 통한 DI는 helloConroller , memberService 등과 같이 스프링이 관리하는
    //객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.

    @Autowired //이거는 생성자에 스프링컨테이너에 있는 걸 연결시켜준다.
    public MemberController(MemberService memberService) { //생성자를 통해서 주입
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}