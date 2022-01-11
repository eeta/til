<template>
    <div>
        <!-- 네이버 로그인 버튼 노출 영역 -->
        <div id="naverIdLogin" @click="naverLogin()">
            <img src="../assets/naver_login_btnG_complete.png" width="222"/>
        </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
    // 네이버 로그인
    data() {
        return {
            naverLogin: null,
        };
    },
    mounted() {
        this.naverLogin = new window.naver.LoginWithNaverId({
            clientId: 'hsEMVuSpJOGlTFPLoErO',  // 개발자센터에 등록한 ClientId
            callbackUrl: 'http://localhost:8080/oauthnaver',
            //callbackUrl: 'http://localhost:8080/oauth/callback/naver',  // 개발자센터에 등록한 callback Url
            isPopup: true,  // 팝업을 통한 연동처리 여부
            loginButton: {  // 로그인 버튼의 타입을 지정
                color: "green",
                type: 3,
                height: 60
            }
        });

        // 설정 정보를 초기화하고 연동을 준비
        this.naverLogin.init();

        this.naverLogin.getLoginStatus((status) => {
            if (status) {
                console.log(status);
                console.log(this.naverLogin.user);

                // 필수적으로 받아야 하는 프로필 정보가 있다면 callback 처리 시점에 체크
                var email = this.naverLoginuser.getEmail();
                if (email == undefined || email == null) {
                    alert("이메일은 필수 정보입니다. 정보 제공에 동의해주세요.");
                    // 사용자 정보 재동의를 위해서 다시 네이버 동의 페이지로 이동함
                    this.naverLogin.reprompt();
                    return;
                }

            } else {
                console.log("callback 처리에 실패하였습니다.");
            }
        });
    },
    methods: {
        logout() {  // 토큰 삭제
            const accessToken = this.naverLogin.accessToken.accessToken;
            const url='/oauth2.0/token?grant_type=delete&client_id=hsEMVuSpJOGlTFPLoErO&client_secret=hsEMVuSpJOGlTFPLoErO&access_token=${accessToken}&service_provider=NAVER';

            axios.get(url).then((res) => {
                console.log(res.data);
            });
        }
    }
}
</script>