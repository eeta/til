<template>
    <div>
        <!-- 카카오 로그인 버튼 노출 영역 -->
        <a id="kakao-login-btn" @click="kakaoLogin()">
            <img src="../assets/kakao_login_medium_narrow.png" width="222"/>
        </a>
        <br>
        <button type="button" @click="kakaoLogout()">카카오 로그아웃</button>
    </div>
</template>

<script>
export default {
    methods: {
        // 카카오 로그인
        kakaoLogin() {
            // window.Kakao.Auth.login 함수를 호출함으로써 카카오 계정으로 로그인 팝업을 호출할 수 있다.
            window.Kakao.Auth.login({
                scope: 'profile_nickname, account_email',
                success: this.getKakaoAccount
            });
        },
        getKakaoAccount() {
            window.Kakao.API.request({
                url: '/v2/user/me',
                success : res => {
                    const kakao_account = res.kakao_account;
                    const nickname = kakao_account.profile.nickname;  // 카카오 닉네임
                    const email = kakao_account.email;  // 카카오 이메일
                    console.log('nickname', nickname);
                    console.log('email', email);

                    alert("로그인 성공!");
                },
                fail : error => {
                    console.log(error);
                }
            });
        },
        kakaoLogout() {
            window.Kakao.Auth.logout((response) => {
                console.log(response);
            });
        },
    }
}
</script>