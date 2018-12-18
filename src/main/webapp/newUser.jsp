<form class="form" action="adminAddUser" method="GET" >

    <h1 class="h3 mb-3 font-weight-normal">Add User</h1>
    <label for="inputEmail" class="sr-only">Email</label>
    <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required autofocus>
    <label for="inputFirstName" class="sr-only">First Name</label>
    <input type="text" id="inputFirstName" class="form-control" name="firstName" placeholder="First Name" required>
    <label for="inputLastName" class="sr-only">Last Name</label>
    <input type="text" id="inputLastName" class="form-control" name="lastName" placeholder="Last Name" required>
    <label for="inputUsername" class="sr-only">Username</label>
    <input type="text" id="inputUsername" class="form-control" name="userName" placeholder="Username" required>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="pWord" placeholder="Password" required>
    <label for="inputPasswordConfirm" class="sr-only">Confirm Password</label>
    <input type="password" id="inputPasswordConfirm" class="form-control" name="pWordConfirm" placeholder="Password Confirmation" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

</form>