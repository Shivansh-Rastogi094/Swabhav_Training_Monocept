<!DOCTYPE html>
<html>
<body>

<h2>Course Registration</h2>

<form action="register" method="post">

    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Age: <input type="number" name="age"><br><br>

    Course:
    <select name="course">
        <option value="">Select</option>
        <option>Java Full Stack</option>
        <option>Python Full Stack</option>
        <option>MERN Stack</option>
        <option>Data Analytics</option>
    </select><br><br>

    Batch:
    <select name="batch">
        <option value="">Select</option>
        <option>Morning</option>
        <option>Afternoon</option>
        <option>Evening</option>
    </select><br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>