<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Employee Management System - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <div class=container style="border: 2px solid black; padding: 30px; margin: 30px;">
      <form action="loginCheck.spring" method="post">
        <div class="form-group">
          <label for="userid" class="col-sm-2 col-form-label">User ID</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="userid" name="userid">
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-sm-2 col-form-label">Password</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="password" name="password">
          </div>
        </div>
        <fieldset class="form-group">
          <legend class="col-form-label col-sm-2 pt-0">Type of User</legend>
          <div class="col-sm-10">
            <div class="form-check">
              <input class="form-check-input" type="radio" name="userTypes" id="userType1" value="admin">
              <label class="form-check-label" for="userType1">
                Admin
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="userTypes" id="userType2" value="employee">
              <label class="form-check-label" for="userType2">
                Employee
              </label>
            </div>
          </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">Sign in</button>
      </form>
    </div>
  </body>
</html>