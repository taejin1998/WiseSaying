package com.back.domain.wiseSaying;

import com.back.domain.global.AppContext;
import com.back.domain.global.Rq;
import com.back.domain.system.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {

    private Scanner sc = new Scanner(System.in);
    private SystemController systemController = AppContext.systemController;
    private WiseSayingController wiseSayingController = AppContext.wiseSayingController;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd); // cmd 분석 객체
            String action = rq.getAction();

            if (action.equals("종료")) {
                systemController.exit();
                break;
            } else if (action.equals("등록")) {
                wiseSayingController.actionWrite();
            } else if (action.equals("목록")) {
                wiseSayingController.actionList();
            } else if (action.startsWith("삭제")) {
                wiseSayingController.actionDelete(rq);
            } else if (action.startsWith("수정")) {
                wiseSayingController.actionModify(rq);
            }
        }
    }
}