import React, {useState} from "react";


const Login = () => {
    const [showPassword, setShowPassword] = useState(false)

    const showedPw = () => {
        setShowPassword(!showPassword)
    }

  return (
    <div>
      <div className="login-logo">
        <p><b style={{color : "red"}}>D</b>OMINO <b style={{color : "blue"}}>P</b>IZZA</p>
      </div>
      <div className="login-bg">
        <div className="login-id">
          {/* <p>ID</p> */}
          <input type="text" placeholder="ID"></input>
        </div>
        <div className="login-pw">
          {/* <p>PASSWORD</p> */}
          <input type={showPassword ? "text" : "password"} placeholder="PASSWORD"></input>
          <button className="show-pw-state" onClick={showedPw}>{showPassword ? "🔴" : "🟢"}</button>
        </div>
        <div className="login-bt-div">
          <button className="login-bt">LOGIN</button>
        </div>
        <div className="login-fd">
          <p>회원가입</p>
          <p>아이디 찾기</p>
          <p>비밀번호 찾기</p>
        </div>
      </div>
    </div>
  );
};

export default Login;
