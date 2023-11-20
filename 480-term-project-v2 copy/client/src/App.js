import React, {useState, useEffect} from 'react';
import './index.css';
import {Routes, Route} from 'react-router-dom';
import AccessLevel from './AccessLevel';
import User from './User';
import UserBenefits from './UserBenefits';
import UserSignup from './UserSignup';
import UserFlightList from './UserFlightList';
import UserBuyFlight from './UserBuyFlight';
import Employee from './Employee';
import EmployeeViewPassengers from './EmployeeViewPassengers';
import Admin from './Admin';
import AdminVerification from './AdminVerification';
import AdminAddFlight from './AdminAddFlight';
import AdminAircrafts from './AdminAircrafts';
import AdminCrew from './AdminCrew';
import AdminViewUsers from './AdminViewUsers';
import NotFound from './NotFound';
import { googleLogout, useGoogleLogin } from '@react-oauth/google';
import axios from 'axios';

function App() {

  // "npm install @react-oauth/google@latest" and "npm install axios" to use google login

  const [ user, setUser ] = useState([]);
  const [ profile, setProfile ] = useState([]);
  const [ accessToken, setAccessToken ] = useState(null);
  const [ email, setEmail ] = useState(null);

  const login = useGoogleLogin({
      onSuccess: (codeResponse) => setUser(codeResponse),
      onError: (error) => console.log('Login Failed:', error)
  });

  useEffect( () => {
      setUser(null);
      setProfile(null);
  }, []);

  useEffect(
      () => {
          if (user) {
              axios
                  .get(`https://www.googleapis.com/oauth2/v1/userinfo?access_token=${user.access_token}`, {
                      headers: {
                          Authorization: `Bearer ${user.access_token}`,
                          Accept: 'application/json'
                      }
                  })
                  .then((res) => {
                      setProfile(res.data);
                      setAccessToken(user.access_token);
                      setEmail(res.data.email);
                  })
                  .catch((err) => console.log(err));
          }
      },
      [ user ]
  );

  // log out function to log the user out of google and set the profile array to null
  const logOut = () => {
      googleLogout();
      setProfile(null);
  };

  return (
    <>
      {profile ? (
        <Routes>
          <Route path = "/" element={<AccessLevel accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "user" element={<User accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "user-signup" element={<UserSignup accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "user-benefits" element={<UserBenefits accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "user-flight-list" element={<UserFlightList accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "user-book-flight/:id" element={<UserBuyFlight accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "employee" element={<Employee accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "employee-view-passengers/:id" element={<EmployeeViewPassengers accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "admin" element={<Admin accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "verify-admin" element={<AdminVerification accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "admin-view-crew/:id" element={<AdminCrew accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "admin-view-aircrafts" element={<AdminAircrafts accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "admin-view-users" element={<AdminViewUsers accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "admin-add-flight" element={<AdminAddFlight accessToken={accessToken} email={email} logOut = {logOut}/>}/>
          <Route path = "*" element = {<NotFound />}/>
        </Routes>
        ): (
          <>
          <div class = "header-cont">
            <div class = "header-button"></div>
            <div class = "header-title-1">
              <div id = "title"><b>&#9992;Airline Reservation System&#9992;</b></div>
              <div id = "title-desc"><b>Reserve a flight to any location!</b></div>
            </div>
            <div class = "header-title-2"></div>
          </div>
          <div id = "login-button-cont">
            <div id = "login-button-center">
                <button id = "login-button" onClick={() => login()}>✍ Sign in to the system here! ✍</button>
            </div>
          </div>
          <div class = "flex-end">
            <p id = "copyright">&#169; Harris Hasnain 2023</p>
          </div>
          </>
        )}
</>

  )

}

export default App;