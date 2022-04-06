<!DOCTYPE html>
<html>
   <head>
      <title>Employee Reimbursement System</title>
      <meta charset="UTF-8">
      <meta name="description" content="Employee Reimbursement System Website">
      <meta name="keywords" content="HTML, CSS, JavaScript">
      <meta name="author" content="Runval Borse">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="style.css" type="text/css">
   </head>
   <body>
      <div class="center">
      <h2>Expense Reimbursement System</h2><hr>
         <form name="loginForm" action="Login" method="post" autocomplete="on">
            <div  class="txt_field">
               <!--Define List for select User role-->
               <select name="user-role">
                  <option value="">Select Role</option>
                  <option value="employee">Employee</option>
                  <option value="manager">Manager</option>
               </select>
            </div>
            
           <div class="txt_field">
           <!-- Define email input for user -->
           <input type="email" name="user-email" required>
           <span></span>
           <label>Email</label>
           </div>
           
            <div class="txt_field">
            <!-- Define password input for user -->
            <input type="password" name="user-password" required>
            <span></span>
            <label>Password</label>
            </div>
            
            
            <input type="submit" name="SubmitButton" Value="Login">
         </form>
      </div>
   </body>
</html>