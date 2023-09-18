// 로고 이미지

// 카카오로그인버튼
// 구글로그인
// 최초 로그인:  -> <SignUpPage/>
// 기존 회원: ->  <SunsetMainPage/>

import React from "react";
import styled from "styled-components";

// 스타일
import Button from "components/common/Button";
import axios from "axios";

const LoginContainer = styled.div`
  width: 80%;
  margin:auto;
  margin-top: 45vh;
`;

// 로그인 함수



const openKakaoLogin = () => {
  const REDIRECT_URI = 'http://localhost:9090/login/oauth2/code/kakao'  
  const CLIENT_ID = 'b23cd8eabfec28093bf91fefbce93b8d'
  const KakaoLoginAPI = `https://kauth.kakao.com/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code`;
  
  window.open(KakaoLoginAPI, "_self");
}


const Login = () => {

  return (
    <LoginContainer>
      <Button 
      $fullWidth 
      $kakao
      onClick={()=>{openKakaoLogin()}}
      >Login with Kakao</Button>
    </LoginContainer>
  )
}

export default Login