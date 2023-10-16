package com.app.usearth.controller;

import com.app.usearth.domain.ComplainDTO;
import com.app.usearth.domain.ReserveCarVO;
import com.app.usearth.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
@Slf4j
public class MyPageController {
    private final MypageService mypageService;
    @GetMapping("complain")
    public void goToMyComplain(ComplainDTO complainDTO){;}
    @PostMapping("complain")
    public RedirectView complainSubmit(ComplainDTO complainDTO){
        //세션아이디 넣고
        mypageService.addComplain(complainDTO);
        return new RedirectView("/mypage/complain-detail");
    }
    @GetMapping("complain-detail")
    public void goToMyComplainDetail(){;}
    @GetMapping("edit-personal")
    public void goToMyEditPersonal(){;}
    @GetMapping("inquiry")
    public void goToMyInquiry(){;}
    @GetMapping("member-withdrawal")
    public void goToMyMemberWithDrawl(){;}
    @GetMapping("mypage")
    public void goToMyPage(){;}
    @PostMapping("mypage")
    //업로드 된개수 ,INPUT 3개
    public RedirectView updateProfile(@RequestParam("uuid") List<String> uuids, @RequestParam("uploadFile") List<MultipartFile> uploadFiles) {
//        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
        //업로드한거만 보냄
//        if (uploadFiles.get(0).isEmpty()) {
//           }
//        memberVO.setFileName(uuids.get(0) + "_" + uploadFiles.get(0).getOriginalFilename());
//        memberVO.setFilePath(getPath());
//            fileService.register(fileVO);

        return new RedirectView("/mypage/mypage");
    }
    @GetMapping("reserve-car")
    public void goToMyReserveCar(ReserveCarVO reserveCarVO){;}
    @PostMapping("reserve-car")
    public RedirectView reserve(ReserveCarVO reserveCarVO){
//        세션에 아이디 가져와서 밑에 넣고 실행 하면 될듯
//        reserveCarVO.setUserId(1L);
        mypageService.saveCar(reserveCarVO);
        return new RedirectView("/mypage/reserve-carlist");
    }
    @GetMapping("reserve-carlist")
    public void goToMyReserveCarList(RedirectAttributes redirectAttributes){
        //        세션에서 가지고온 id로 넣고
//        List<ReserveCarVO> foundLists=mypageService.searchCar();
//        redirectAttributes.addFlashAttribute("car", foundLists);
    }
    @GetMapping("mycommunity")
    public void goToMyCommunity(){;}
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        if(session!=null) {
            session.invalidate();
        }
        return new RedirectView("/");
    }

}
