<form class="form" action="adminUpdateUser" method="GET" >

    <label for="inputEmail" >Email</label>
    <input type="email" id="inputEmail"  name="email" placeholder="${theUser.email}" >
    <label for="inputFirstName">First Name</label>
    <input type="text" id="inputFirstName" name="firstName" placeholder="${theUser.firstName}" >
    <label for="inputLastName" >Last Name</label>
    <input type="text" id="inputLastName" name="lastName" placeholder="${theUser.lastName}" >
    <label for="inputUsername" >Username</label>
    <input type="text" id="inputUsername" name="userName" placeholder="${theUser.userName}" >
    <label for="inputPassword">Password</label>
    <input type="password" id="inputPassword"  name="pWord" placeholder="${theUser.password}" >
    <label for="inputPasswordConfirm" >Confirm Password</label>
    <input type="password" id="inputPasswordConfirm" name="pWordConfirm" placeholder="${theUser.password}">
    <input type="hidden" name="userId" value="${theUser.userid}"/>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

</form>
